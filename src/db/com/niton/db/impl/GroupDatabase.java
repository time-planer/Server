package com.niton.db.impl;

import java.util.ArrayList;

import org.jooq.DSLContext;

import com.niton.model.EditGroup;
import com.niton.model.Group;
import com.niton.model.GroupMember;
import com.niton.model.ReducedGroup;
/**
 * Includes a few methodes to operate with the groups and a the data of groups
 * @author Tobias Schrottwieser
 * 27.02.2019
 * 17:12:36
 */
public class GroupDatabase {
	private String user,uid;
	private DSLContext sql;
	private final GroupTasksDatabase tasks;
	private final GroupTaskDatabase task;
	
	/**
	 * Default Constructor
	 * @param sql the default sql connection
	 */
	public GroupDatabase(DSLContext sql) {
		this.sql = sql;
		tasks = new GroupTasksDatabase(user, sql);
		task = new GroupTaskDatabase(user,sql);
	}
	/**
	 * Used to delete a group
	 */
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @return a group object with all details
	 */
	public Group detailed() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Used to edit a group
	 * @param name new for the group
	 */
	public void edit(EditGroup name) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @return returns a boolean which describes if a group exists
	 */
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * @return a object with the group informations
	 */
	public ReducedGroup information() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * returns information of a user in a group
	 * @param string user name
	 * @return informations about a user
	 */
	public GroupMember member(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * @return a list with all group members
	 */
	public ArrayList<GroupMember> members() {
		return null;
	}
	/**
	 * Sets a sql connection 
	 * @param sql the new sql connection
	 */
	public void setSql(DSLContext sql) {
		this.sql = sql;
	}
	/**
	 * Sets the UID
	 * @param uid the new UID
	 */
	public void setUid(String uid) {
		this.uid = uid;
		tasks.setUid(uid);
		task.setUid(uid);
	}
	/**
	 * Sets the uder
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
