package com.niton.db.impl;

import java.util.ArrayList;

import org.jooq.DSLContext;

import com.niton.model.EditGroup;
import com.niton.model.Group;
import com.niton.model.GroupMember;
import com.niton.model.ReducedGroup;
/**
 * 
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
	 * 
	 * @param sql
	 */
	public GroupDatabase(DSLContext sql) {
		this.sql = sql;
		tasks = new GroupTasksDatabase(user, sql);
		task = new GroupTaskDatabase(user,sql);
	}
	/**
	 * 
	 */
	public void delete() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * @return
	 */
	public Group detailed() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @param name
	 */
	public void edit(EditGroup name) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * @return
	 */
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 
	 * @return
	 */
	public ReducedGroup information() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @param string
	 * @return
	 */
	public GroupMember member(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<GroupMember> members() {
		return null;
	}
	/**
	 * 
	 * @param sql
	 */
	public void setSql(DSLContext sql) {
		this.sql = sql;
	}
	/**
	 * 
	 * @param uid
	 */
	public void setUid(String uid) {
		this.uid = uid;
		tasks.setUid(uid);
		task.setUid(uid);
	}
	/**
	 * 
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
	public GroupTaskDatabase task(String name) {
		task.setTaskName(name);
		return task;
	}
	/**
	 * 
	 * @return
	 */
	public GroupTasksDatabase tasks() {
		return tasks;
	}

}
