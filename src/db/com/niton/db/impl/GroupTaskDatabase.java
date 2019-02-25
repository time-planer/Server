package com.niton.db.impl;

import org.jooq.DSLContext;

import com.niton.model.EditTask;
import com.niton.model.Task;

public class GroupTaskDatabase {

	private String task;
	private String user;
	private String group;
	private final DSLContext sql;

	public GroupTaskDatabase(String user, DSLContext sql) {
		this.user = user;
		this.sql = sql;
	}

	public void delete() {
		// TODO Auto-generated method stub
		
	}

	public void edit(EditTask importance) {
		// TODO Auto-generated method stub
		
	}
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}

	public Task information() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public void setTaskName(String name) {
		task = name;
	}

	public void setUid(String uid) {
		group = uid;
	}

}
