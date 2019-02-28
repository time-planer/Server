package com.niton.db.impl;

import java.util.ArrayList;

import org.jooq.DSLContext;

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
	private final MyGroupsDatabase my;
	/**
	 * Default Constructor
	 * @param sql the sql connection
	 */
	public GroupsDatabase(DSLContext sql) {
		this.sql = sql;
		my = new MyGroupsDatabase(user, sql);
	}
	/**
	 * Used to add a group member
	 * @param initialGroup current group
	 */
	public void add(InitialGroup initialGroup) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Used to create a group
	 * @param description new description of the group
	 */
	public void create(InitialGroup description) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @return a list of all created group
	 */
	public ArrayList<ReducedGroup> created() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return a list of all groups
	 */
	public ArrayList<ReducedGroup> list() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return a list of all groups of a user
	 */
	public MyGroupsDatabase my() {
		// TODO Auto-generated method stub
		return my;
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
}
