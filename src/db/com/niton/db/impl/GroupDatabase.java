package com.niton.db.impl;

import static com.niton.db.tables.EdsGroup.EDS_GROUP;
import static com.niton.db.tables.Groupmember.GROUPMEMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SelectConditionStep;

import com.niton.db.tables.Groupmember;
import com.niton.db.tables.records.EdsGroupRecord;
import com.niton.db.tables.records.GroupmemberRecord;
import com.niton.model.EditGroup;
import com.niton.model.Group;
import com.niton.model.GroupMember;
import com.niton.model.ReducedGroup;;

/**
 * Includes a few methodes to operate with the groups and a the data of groups
 * 
 * @author Tobias Schrottwieser 27.02.2019 17:12:36
 */
public class GroupDatabase {
	private String user;
	Integer uid;
	private DSLContext sql;
	private final GroupTasksDatabase tasks;
	private final GroupTaskDatabase task;

	/**
	 * Default Constructor
	 * 
	 * @param sql the default sql connection
	 */
	public GroupDatabase(DSLContext sql) {
		this.sql = sql;
		tasks = new GroupTasksDatabase(user, sql);
		task = new GroupTaskDatabase(user, sql);
	}

	/**
	 * Used to delete a group
	 */
	public void delete() {
		sql.deleteFrom(EDS_GROUP).where(EDS_GROUP.UID.eq(uid)).execute();
	}
	
	/**
	 * @return a group object with all details
	 */
	public Group detailed() {
		SelectConditionStep<EdsGroupRecord> a = sql.selectFrom(EDS_GROUP).where(EDS_GROUP.UID.eq(uid));
		Result<EdsGroupRecord> rs = a.fetch();
		EdsGroupRecord gR = rs.get(0);
		Group rG = new Group()
				.name(gR.getName())
				.description(gR.getDescription())
				.creationDate(gR.getCreationDate().toLocalDate())
				.creator(gR.getCreator())
				.uid(gR.getUid())
				.members(members())
				.tasks(tasks().list().stream().map(t -> t.getName()).collect(Collectors.toList()));
		return rG;
	}
	
	/**
	 * Used to edit a group
	 * @param name new for the group
	 */
	public void edit(EditGroup name) {
		EdsGroupRecord gR = sql.selectFrom(EDS_GROUP).where(EDS_GROUP.UID.eq(uid)).fetchOne();
		if(name.getName() != null) {
			gR.setName(name.getName());
		}
		if(name.getMembers() != null) {
			List<GroupMember> newMembers = name.getMembers();
			List<GroupMember> old = members();
			for(GroupMember  o : old) {
				boolean contained = false;
				for (GroupMember n : newMembers) {
					if(n.getEmail().equals(o.getEmail()))
						contained = true;
				}
				if(!contained) {
					sql.deleteFrom(GROUPMEMBER).where(GROUPMEMBER.USER.eq(user).and(GROUPMEMBER.GROUP.eq(uid))).execute();
				}
			}
			
			for(GroupMember n : newMembers){
				boolean contained = false;
				for (GroupMember o : old) {
					if(n.getEmail().equals(o.getEmail()))
						contained = true;
				}
				if(!contained) {
					GroupmemberRecord member = GROUPMEMBER.newRecord();
					member.attach(sql.configuration());
					member.setUser(user);
					member.setGroup(uid);
					member.setCreate((byte) (n.isCreate()?1:0));
					member.setEdit((byte) (n.isEdit()?1:0));
					member.setDelete((byte) (n.isDelete()?1:0));
					member.store();
				}
			}
		}
		//TODO: Alle Atribute
		gR.store();
	}

	/**
	 * @return returns a boolean which describes if a group exists
	 */
	public boolean exists() {
		return sql.selectFrom(EDS_GROUP).where(EDS_GROUP.UID.eq(uid)).fetch().size() > 0;
	}
	
	/**
	 * @return a object with the group informations
	 */
	public ReducedGroup information() {
		SelectConditionStep<EdsGroupRecord> a = sql.selectFrom(EDS_GROUP).where(EDS_GROUP.UID.eq(uid));
		Result<EdsGroupRecord> rs = a.fetch();
		EdsGroupRecord gR = rs.get(0);
		ReducedGroup rG = new ReducedGroup()
				.name(gR.getName())
				.description(gR.getDescription())
				.creationDate(gR.getCreationDate().toLocalDate())
				.uid(gR.getUid())
				.tasks(tasks().list().size())
				.members(members().size());
		return rG;
	}

	/**
	 * returns information of a user in a group
	 * 
	 * @param string user name
	 * @return informations about a user
	 */
	public GroupMember member(String string) {
		GroupmemberRecord gR = sql.selectFrom(GROUPMEMBER).where(GROUPMEMBER.GROUP.eq(uid).and(GROUPMEMBER.USER.eq(string))).fetchOne();
		return parseGroupMember(gR);
	}

	/**
	 * @return a list with all group members
	 */
	public ArrayList<GroupMember> members() {
		ArrayList<GroupMember> gML = new ArrayList<>();
		org.jooq.Result<GroupmemberRecord> gr = sql.selectFrom(GROUPMEMBER).where(GROUPMEMBER.GROUP.eq(uid)).fetch();
		for (GroupmemberRecord groupmemberRecord : gr) {
			gML.add(parseGroupMember(groupmemberRecord));
		}
		return gML;
	}

	private GroupMember parseGroupMember(GroupmemberRecord gR) {
		GroupMember groupMember = new GroupMember();
		groupMember.setCreate(gR.getCreate() == 1 ? true : false);
		groupMember.setEdit(gR.getEdit() == 1 ? true : false);
		groupMember.setDelete(gR.getDelete() == 1 ? true : false);
		groupMember.setEmail(gR.getUser());
		return groupMember;
	}

	/**
	 * Sets a sql connection
	 * 
	 * @param sql the new sql connection
	 */
	public void setSql(DSLContext sql) {
		this.sql = sql;
	}

	/**
	 * Sets the UID
	 * 
	 * @param integer the new UID
	 */
	public void setUid(Integer integer) {
		this.uid = integer;
		tasks.setUid(integer);
		task.setUid(integer);
	}

	/**
	 * Sets the user
	 * 
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
		task.setUser(user);
		tasks.setUser(user);
	}

	public GroupTaskDatabase task(String name) {
		task.setTaskName(name);
		return task;
	}

	public GroupTasksDatabase tasks() {
		return tasks;
	}
}
