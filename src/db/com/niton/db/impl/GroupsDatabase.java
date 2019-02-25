package com.niton.db.impl;

import java.util.ArrayList;

import org.jooq.DSLContext;

import com.niton.model.InitialGroup;
import com.niton.model.ReducedGroup;

public class GroupsDatabase {

	private String user;
	private DSLContext sql;
	private final MyGroupsDatabase my;

	public GroupsDatabase(DSLContext sql) {
		this.sql = sql;
		my = new MyGroupsDatabase(user, sql);
	}

	public void add(InitialGroup initialGroup) {
		// TODO Auto-generated method stub
		
	}

	public void create(InitialGroup description) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ReducedGroup> created() {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<ReducedGroup> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public MyGroupsDatabase my() {
		// TODO Auto-generated method stub
		return my;
	}

	public void setSQL(DSLContext sql2) {
		sql = sql2;
		
	}

	public void setUser(String user) {
		this.user = user;
	}

}
