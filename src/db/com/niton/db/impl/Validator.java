package com.niton.db.impl;

import com.niton.model.EditGroup;
import com.niton.model.EditTask;
import com.niton.model.InitialGroup;
import com.niton.model.InitialTask;
import com.niton.model.RegistrationRequest;
/**
 * 
 * @author Tobias Schrottwieser
 * 27.02.2019
 * 17:14:07
 */
public class Validator {
	private static Validator instance;
	/**
	 * @returninstance
	 */
	public static Validator getInstance() {
		if(instance == null)
			instance = new Validator();
		return instance;
	}
	/** 
	 * Default Constructor
	 */
	private Validator() {
	}
	/**
	 * Checks if a group change is legit
	 * @param editGroup the edited group
	 * @return if its legit
	 */
public boolean checkEditGroup(EditGroup editGroup) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * Checks if a task change is legit
	 * @param editTask the edited task
	 * @return if its legit
	 */
	public boolean checkEditTask(EditTask editTask) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * Checks if a email change is legit
	 * @param email the edited email
	 * @return if its legit
	 */
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * Checks if a initial group is legit
	 * @param initialGroup the initial group
	 * @return if its legit
	 */
	public boolean checkInitGroup(InitialGroup initialGroup) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * Checks if a initial task is legit
	 * @param initialTask the initial task
	 * @return if its legit
	 */
	public boolean checkInitTask(InitialTask initialTask) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Checks if a registration is legit
	 * @param registrationRequest the registration request
	 * @return if its legit
	 */
	public boolean checkRegistration(RegistrationRequest registrationRequest) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * Checks if a task name is legit
	 * @param task the task name
	 * @return if its legit
	 */
	public boolean checkTaskName(String task) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * Checks if a UID is legit
	 * @param groupUUID the group UID
	 * @return if its legit
	 */
	public boolean checkUID(String groupUUID) {
		// TODO Auto-generated method stub
		return true;
	}
}
