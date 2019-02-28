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
	 * 
	 * @return
	 */
	public static Validator getInstance() {
		if(instance == null)
			instance = new Validator();
		return instance;
	}
	/**
	 * 
	 */
	private Validator() {
	}
	/**
	 * 
	 * @param editGroup
	 * @return
	 */
	public boolean checkEditGroup(EditGroup editGroup) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 
	 * @param editTask
	 * @return
	 */
	public boolean checkEditTask(EditTask editTask) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 
	 * @param email
	 * @return
	 */
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 
	 * @param initialGroup
	 * @return
	 */
	public boolean checkInitGroup(InitialGroup initialGroup) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 
	 * @param initialTask
	 * @return
	 */
	public boolean checkInitTask(InitialTask initialTask) {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 
	 * @param registrationRequest
	 * @return
	 */
	public boolean checkRegistration(RegistrationRequest registrationRequest) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 
	 * @param task
	 * @return
	 */
	public boolean checkTaskName(String task) {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * 
	 * @param groupUUID
	 * @return
	 */
	public boolean checkUID(String groupUUID) {
		// TODO Auto-generated method stub
		return true;
	}

}
