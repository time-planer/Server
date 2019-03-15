package com.niton.db.impl;

import static com.niton.db.tables.Group.GROUP;
import static com.niton.db.tables.Groupmember.GROUPMEMBER;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SelectConditionStep;

import com.niton.db.tables.records.GroupRecord;
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
	private String user, uid;
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
		sql.deleteFrom(GROUP).where(GROUP.UID.eq(uid)).execute();
	}
	
	/**
	 * @return a group object with all details
	 */
	public Group detailed() {
		SelectConditionStep<GroupRecord> a = sql.selectFrom(GROUP).where(GROUP.UID.eq(uid));
		Result<GroupRecord> rs = a.fetch();
		GroupRecord gR = rs.get(0);
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
		GroupRecord gR = sql.selectFrom(GROUP).where(GROUP.UID.eq(uid)).fetchOne();
		if(name.getName() != null) {
			gR.setName(name.getName());
		}
		if(name.getMembers() != null) {
			sql.deleteFrom(GROUPMEMBER).where(GROUPMEMBER.GROUP.eq(uid)).execute();
			for(GroupMember  m : name.getMembers()) {
				GroupmemberRecord record = GROUPMEMBER.newRecord();
				record.attach(sql.configuration());
				record.setCreate((byte) (m.isCreate()?1:0));
				record.setEdit((byte) (m.isCreate()?1:0));
				record.setCreate((byte) (m.isCreate()?1:0));
				record.setUser(m.getEmail());
				record.setGroup(uid);
				record.store();
			}
		}
		//TODO: Alle Atribute
		gR.store();
	}

	/**
	 * @return returns a boolean which describes if a group exists
	 */
	public boolean exists() {
		return sql.selectFrom(GROUP).where(GROUP.UID.eq(uid)).fetch().size() > 0;
	}
	
	/**
	 * @return a object with the group informations
	 */
	public ReducedGroup information() {
		SelectConditionStep<GroupRecord> a = sql.selectFrom(GROUP).where(GROUP.UID.eq(uid));
		Result<GroupRecord> rs = a.fetch();
		GroupRecord gR = rs.get(0);
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
	 * @param uid the new UID
	 */
	public void setUid(String uid) {
		this.uid = uid;
		tasks.setUid(uid);
		task.setUid(uid);
	}

	/**
	 * Sets the user
	 * 
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	public GroupTaskDatabase task(String name) {
		task.setTaskName(name);
		return task;
	}

	public GroupTasksDatabase tasks() {
		return tasks;
	}
}
