package com.niton.db.impl;

import java.util.ArrayList;

import org.jooq.DSLContext;

import com.niton.model.EditGroup;
import com.niton.model.Group;
import com.niton.model.GroupMember;
import com.niton.model.ReducedGroup;

public class GroupDatabase {
	private String user,uid;
	private DSLContext sql;
	private final GroupTasksDatabase tasks;
	private final GroupTaskDatabase task;
	public GroupDatabase(DSLContext sql) {
		this.sql = sql;
		tasks = new GroupTasksDatabase(user, sql);
		task = new GroupTaskDatabase(user,sql);
	}
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public Group detailed() {
		// TODO Auto-generated method stub
		return null;
	}

	public void edit(EditGroup name) {
		// TODO Auto-generated method stub
		
	}

	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	public ReducedGroup information() {
		// TODO Auto-generated method stub
		return null;
	}

	public GroupMember member(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<GroupMember> members() {
		return null;
	}

	public void setSql(DSLContext sql) {
		this.sql = sql;
	}
	public void setUid(String uid) {
		this.uid = uid;
		tasks.setUid(uid);
		task.setUid(uid);
	}

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
