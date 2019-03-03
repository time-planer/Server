package com.niton.db.impl;

import static com.niton.db.tables.Group.GROUP;
import static com.niton.db.tables.Groupmember.GROUPMEMBER;
import static com.niton.db.tables.Task.TASK;

import java.util.ArrayList;

import org.jooq.DSLContext;

import com.niton.db.Database;
import com.niton.db.tables.records.GroupRecord;
import com.niton.db.tables.records.GroupmemberRecord;
import com.niton.db.tables.records.TaskRecord;
import com.niton.model.InitialGroup;
import com.niton.model.ReducedGroup;
/**
 * Includes methodes for the groups
 * @author Tobias Schrottwieser
 * 27.02.2019
 * 17:11:30
 */
public class GroupsDatabase {

	private String user;
	private DSLContext sql;
	/**
	 * Default Constructor
	 * @param sql the sql connection
	 */
	public GroupsDatabase(DSLContext sql) {
		this.sql = sql;
	}

	/**
	 * Used to create a group
	 * @param description new description of the group
	 */
	public void create(InitialGroup description) {
		// TODO Auto-generated method stub
		GroupRecord gr = new GroupRecord();
		gr.setDescription(description.getDescription());
		gr.setName(description.getName());
		gr.setCreator(user);
		gr.store();
	}
	/**
	 * @return a list of all created group of the current user
	 */
	public ArrayList<ReducedGroup> created() {
		// TODO Auto-generated method stub
		ArrayList<ReducedGroup> list = new ArrayList<ReducedGroup>();
		org.jooq.Result<GroupRecord> rg = sql.selectFrom(GROUP).where(GROUP.CREATOR.eq(user)).fetch();
		for (GroupRecord f : rg) {
			ReducedGroup pushing = new ReducedGroup();
			pushing.description(f.getDescription()).name(f.getName()).creationDate(f.getCreationDate().toLocalDate())
					.members(getGroupMembers(f.getUid()).size()).tasks(getGroupTasks(f.getUid()).size());
			list.add(pushing);
		}
		return list;
	}
	/**
	 * @return a list of all groups with the current user in it
	 */
	public ArrayList<ReducedGroup> list() {
		// TODO Auto-generated method stub
		ArrayList<GroupmemberRecord> gmr = new ArrayList<>();
		gmr.addAll(sql.selectFrom(GROUPMEMBER).where(GROUPMEMBER.USER.eq(user)).fetch());
		ArrayList<ReducedGroup> list = new ArrayList<ReducedGroup>();
		Database db = Database.getInstance();
		for (GroupmemberRecord r : gmr) {
			list.add(db.group(r.getGroup()).information());
		}
		return list;
	}
	/**
	 * Sets a new sql connection
	 * @param sql2 the new sql connection
	 */ 
	public void setSQL(DSLContext sql2) {
		sql = sql2;
		
	}
	/**
	 * Sets a new user
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * @param uid of the current group
	 * @return a list of all users in a group
	 */
	public ArrayList<GroupmemberRecord> getGroupMembers(String uid) {
		ArrayList<GroupmemberRecord> groupMemberList = new ArrayList<GroupmemberRecord>();
		org.jooq.Result<GroupmemberRecord> gr = sql.selectFrom(GROUPMEMBER).where(GROUPMEMBER.GROUP.eq(uid)).fetch();
		groupMemberList.addAll(gr);
		return groupMemberList;
	}
	/**
	 * @param uid of the current group
	 * @return a list of all tasks of a group
	 */
	public ArrayList<TaskRecord> getGroupTasks(String uid) {
		ArrayList<TaskRecord> groupTaskList = new ArrayList<TaskRecord>();
		org.jooq.Result<TaskRecord> gt = sql.selectFrom(TASK).where(TASK.GROUP_UID.eq(uid)).fetch();
		groupTaskList.addAll(gt);
		return groupTaskList;
	}
}
