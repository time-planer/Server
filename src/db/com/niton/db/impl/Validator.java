package com.niton.db.impl;

import com.niton.model.EditGroup;
import com.niton.model.EditTask;
import com.niton.model.InitialGroup;
import com.niton.model.InitialTask;
import com.niton.model.RegistrationRequest;

public class Validator {
	private static Validator instance;
	public static Validator getInstance() {
		if(instance == null)
			instance = new Validator();
		return instance;
	}
	private Validator() {
	}
	public boolean checkEditGroup(EditGroup editGroup) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean checkEditTask(EditTask editTask) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean checkInitGroup(InitialGroup initialGroup) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean checkInitTask(InitialTask initialTask) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean checkPassword(String password) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean checkRegistration(RegistrationRequest registrationRequest) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean checkTaskName(String task) {
		// TODO Auto-generated method stub
		return true;
	}
	public boolean checkUID(String groupUUID) {
		// TODO Auto-generated method stub
		return true;
	}

}
