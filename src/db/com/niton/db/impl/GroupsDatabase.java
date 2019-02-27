package com.niton.db.impl;

import java.util.ArrayList;

import org.jooq.DSLContext;

import com.niton.model.InitialGroup;
import com.niton.model.ReducedGroup;
/**
 * 
 * @author Tobias Schrottwieser
 * 27.02.2019
 * 17:11:30
 */
public class GroupsDatabase {

	private String user;
	private DSLContext sql;
	private final MyGroupsDatabase my;
	/**
	 * 
	 * @param sql
	 */
	public GroupsDatabase(DSLContext sql) {
		this.sql = sql;
		my = new MyGroupsDatabase(user, sql);
	}
	/**
	 * 
	 * @param initialGroup
	 */
	public void add(InitialGroup initialGroup) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * @param description
	 */
	public void create(InitialGroup description) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<ReducedGroup> created() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<ReducedGroup> list() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public MyGroupsDatabase my() {
		// TODO Auto-generated method stub
		return my;
	}
	/**
	 * 
	 * @param sql2
	 */
	public void setSQL(DSLContext sql2) {
		sql = sql2;
		
	}
	/**
	 * 
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

}
