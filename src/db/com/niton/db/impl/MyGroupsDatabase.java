package com.niton.db.impl;

import java.util.ArrayList;

import org.jooq.DSLContext;

import com.niton.model.InitialGroup;
import com.niton.model.ReducedGroup;

public class MyGroupsDatabase {

	private String user;
	private DSLContext sql;

	public MyGroupsDatabase(String user, DSLContext sql) {
		this.user = user;
		this.sql = sql;
	}

	public void create(InitialGroup description) {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<ReducedGroup> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
