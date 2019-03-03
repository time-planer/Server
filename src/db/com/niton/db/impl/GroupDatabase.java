package com.niton.db.impl;

import static com.niton.db.tables.Group.GROUP;
import static com.niton.db.tables.Groupmember.GROUPMEMBER;
import static com.niton.db.tables.Task.TASK;

import java.util.ArrayList;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SelectConditionStep;

import com.niton.db.tables.Groupmember;
import com.niton.db.tables.records.GroupRecord;
import com.niton.db.tables.records.GroupmemberRecord;
import com.niton.db.tables.records.TaskRecord;
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
		// TODO Auto-generated method stub
		sql.deleteFrom(GROUP).where(GROUP.UID.eq(uid));
	}
	
	public String getUserEmail() {
		String email;
		org.jooq.Result<GroupmemberRecord> gr = sql.selectFrom(GROUPMEMBER).where(GROUPMEMBER.GROUP.eq(uid)).and(GROUPMEMBER.GROUP.eq(user)).fetch();
		
		return email;
	}
	
	/**
	 * @return a list of all tasks of a group
	 */
	public ArrayList<String> getGroupTasksDetailed() {
		ArrayList<String> groupTaskList = new ArrayList<String>();
		org.jooq.Result<TaskRecord> gt = sql.selectFrom(TASK).where(TASK.GROUP_UID.eq(uid)).fetch();
		for (TaskRecord taskRecord : gt) {
			groupTaskList.add(taskRecord.toString());
		}
		return groupTaskList;
	}
	
	/**
	 * @param uid of the current group
	 * @return a list of all users in a group
	 */
	public ArrayList<Groupmember> getGroupMembers(String uid) {
		ArrayList<Groupmember> groupMemberList = new ArrayList<>();
		org.jooq.Result<GroupmemberRecord> gr = sql.selectFrom(GROUPMEMBER).where(GROUPMEMBER.GROUP.eq(uid)).fetch();
		for (GroupmemberRecord groupmemberRecord : gr) {
			GroupMember gm = new GroupMember().edit(gr.gete);
			groupMemberList.add(gm);
		}
		return groupMemberList;
	}

	/**
	 * @return a group object with all details
	 */
	public Group detailed() {
		// TODO Auto-generated method stub
		SelectConditionStep<GroupRecord> a = sql.selectFrom(GROUP).where(GROUP.UID.eq(uid));
		Result<GroupRecord> rs = a.fetch();
		GroupRecord gR = (GroupRecord) rs.get(0);
		Group rG = new Group().name(gR.getName()).description(gR.getDescription())
				.creationDate(gR.getCreationDate().toLocalDate()).creator(gR.getCreator())
				.uid(gR.getUid()).tasks(getGroupTasksDetailed()).members(getGroupMembersDetailed());
		return rG;
	}

	/**
	 * Used to edit a group
	 * @param name new for the group
	 */
	public void edit(EditGroup name) {
		// TODO Auto-generated method stub
		GroupRecord gR = sql.selectFrom(GROUP).where(GROUP.UID.eq(this.uid)).fetchOne();
		if(name.getName() != null) {
			gR.setName(name.getName());
		}
		gR.store();
	}

	/**
	 * @return returns a boolean which describes if a group exists
	 */
	public boolean exists() {
		// TODO Auto-generated method stub
		return sql.selectFrom(GROUP).where(GROUP.UID.eq(this.uid)).fetch().size() > 0;
	}

	/**
	 * @return integer with the numbers of tasks in it
	 */
	public int getGroupTasks() {
		int groupTaskList;
		org.jooq.Result<TaskRecord> gt = sql.selectFrom(TASK).where(TASK.GROUP_UID.eq(uid)).fetch();
		groupTaskList = gt.size();
		return groupTaskList;
	}
	
	/**
	 * @return integer with the numbers of members in it
	 */
	public int getGroupMembers() {
		int groupMemberList;
		org.jooq.Result<GroupmemberRecord> gr = sql.selectFrom(GROUPMEMBER).where(GROUPMEMBER.GROUP.eq(uid)).fetch();
		groupMemberList = gr.size();
		return groupMemberList;
	}
	
	/**
	 * @return a object with the group informations
	 */
	public ReducedGroup information() {
		// TODO Auto-generated method stub
		SelectConditionStep<GroupRecord> a = sql.selectFrom(GROUP).where(GROUP.UID.eq(uid));
		Result<GroupRecord> rs = a.fetch();
		GroupRecord gR = (GroupRecord) rs.get(0);
		ReducedGroup rG = new ReducedGroup().name(gR.getName()).description(gR.getDescription())
				.creationDate(gR.getCreationDate().toLocalDate()).uid(gR.getUid()).tasks(getGroupTasks()).members(getGroupMembers());
		return rG;
	}

	/**
	 * returns information of a user in a group
	 * 
	 * @param string user name
	 * @return informations about a user
	 */
	public GroupMember member(String string) {
		// TODO Auto-generated method stub
		GroupmemberRecord gR = sql.selectFrom(GROUPMEMBER).where(GROUPMEMBER.GROUP.eq(uid)).fetchOne();
		GroupMember groupMember = new GroupMember().email;
		return groupMember;
	}

	/**
	 * @return a list with all group members
	 */
	public ArrayList<GroupMember> members() {
		ArrayList<GroupMember> gML = new ArrayList<>();
		org.jooq.Result<GroupmemberRecord> gr = sql.selectFrom(GROUPMEMBER).where(GROUPMEMBER.GROUP.eq(uid)).fetch();
		for (GroupmemberRecord groupmemberRecord : gr) {
			GroupMember gM = new GroupMember().email();
			gML.add(gM);
		}
		return gML;
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
