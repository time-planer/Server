package com.niton.db.impl;

import java.util.ArrayList;

import org.jooq.DSLContext;

import com.niton.model.InitialTask;
import com.niton.model.Task;

public class GroupTasksDatabase {
	private String user;
	private DSLContext sql;
	private String uid;

	public GroupTasksDatabase(String user, DSLContext sql) {
		this.user = user;
		this.sql = sql;
	}

	public void add(InitialTask initialTask) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Task> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

}
