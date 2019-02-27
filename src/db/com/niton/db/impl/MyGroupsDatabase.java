package com.niton.db.impl;

import static com.niton.db.tables.Group.GROUP;
import static com.niton.db.tables.Groupmember.GROUPMEMBER;
import static com.niton.db.tables.Task.TASK;

import java.util.ArrayList;

import org.jooq.DSLContext;

import com.niton.db.tables.records.GroupRecord;
import com.niton.db.tables.records.GroupmemberRecord;
import com.niton.db.tables.records.TaskRecord;
import com.niton.model.InitialGroup;
import com.niton.model.ReducedGroup;

/**
 * This class is coordinating the acivities if a group gets created or if a list
 * of group members should be returned
 * 
 * @author Tobias Schrottwieser 27.02.2019 16:45:49
 */
public class MyGroupsDatabase {

	private String user;
	private DSLContext sql;

	/**
	 * Default Constuctor
	 * 
	 * @param user User who is using the database
	 * @param sql  current sql connection
	 */
	public MyGroupsDatabase(String user, DSLContext sql) {
		this.user = user;
		this.sql = sql;
	}

	/**
	 * Creating a new group
	 * 
	 * @param description the describtion of the group
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
	 * @return a list of all groups who the user who is accessing the database
	 *         created
	 */
	public ArrayList<ReducedGroup> list() {
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
