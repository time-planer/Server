package com.niton.db.impl;

import java.time.LocalDate;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.apache.commons.validator.routines.EmailValidator;

import com.niton.model.EditGroup;
import com.niton.model.EditTask;
import com.niton.model.InitialGroup;
import com.niton.model.InitialTask;
import com.niton.model.RegistrationRequest;

/**
 * Checker
 * 
 * @author Tobias Schrottwieser 27.02.2019 17:14:07
 */
public class Validator {
	private static Validator instance;

	/**
	 * @returninstance
	 */
	public static Validator getInstance() {
		if (instance == null)
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
	 * 
	 * @param editGroup the edited group
	 * @return if its legit
	 */
	public boolean checkEditGroup(EditGroup editGroup) {
		if ((isValid(editGroup.getName()) && (editGroup.getName().length() >= 3 && editGroup.getName().length() <= 100))
				&& editGroup.getDescription().length() <= 2500 && editGroup.getDescription().length() >= 0) {
			for (int i = 0; i < editGroup.getMembers().size(); i++) {
				String s = editGroup.getMembers().get(i).getEmail();
				if (checkEmail(s)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks if a task change is legit
	 * 
	 * @param editTask the edited task
	 * @return if its legit
	 */
	public boolean checkEditTask(EditTask editTask) {
		if (editTask.getPlanedDate().isAfter(editTask.getDeadline())) {
			return false;
		}
		// TODO Deadline vor Creation Date && Planed Date vor Creation Date
		return false;
	}

	/**
	 * Checks if a email change is legit
	 * 
	 * @param email the edited email
	 * @return if its legit
	 * @regex http://emailregex.com
	 */
	public boolean checkEmail(String email) {
//		if (email == null) {
//			return false;
//		}
//		if (email.length() > 320 || email.length() < 6) {
//			return false;
//		} // (?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\])
//		try {
//			InternetAddress emailAddr = new InternetAddress(email);
//			emailAddr.validate();
//		} catch (AddressException ex) {
//			return false;
//		}
//		if (EmailValidator.getInstance().isValid(email)) {
//			String s = new String(com.niton.media.ResurceLoader.readOutOfJarFile("com/niton/resources/emailvalid.txt"));
//			for (String ts : s.split(System.lineSeparator())) {
//				if (email.contains(ts)) {
//					return true;
//				}
//			}
//			if (email.endsWith("ac.at")) {
//				return true;
//			}
//			if (email.endsWith("gv.at")) {
//				return true;
//			}
//		}
//		return false;
		return true;
	}

	/**
	 * Checks if a initial group is legit
	 * 
	 * @param initialGroup the initial group
	 * @return if its legit
	 */
	public boolean checkInitGroup(InitialGroup initialGroup) {
		if ((!isValid(initialGroup.getName())) || initialGroup.getName().length() > 100
				|| initialGroup.getName().length() < 2) {
			return false;
		}
		if (initialGroup.getDescription().length() > 2500 || initialGroup.getDescription().length() < 0) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if a initial task is legit
	 * 
	 * @param initialTask the initial task
	 * @return if its legit
	 */
	public boolean checkInitTask(InitialTask initialTask) {
		if ((isValid(initialTask.getName()) && initialTask.getName().length() < 51
				&& initialTask.getName().length() > 0) && (initialTask.getDeadline().isAfter(LocalDate.now()))
				&& (initialTask.getPlanedDate().isAfter(LocalDate.now()))
				&& (initialTask.getDescription().length() <= 2500 && initialTask.getDescription().length() >= 0)
				&& (initialTask.getImportance() <= 10 && initialTask.getImportance() >= 0)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a registration is legit
	 * 
	 * @param registrationRequest the registration request
	 * @return if its legit
	 */
	public boolean checkRegistration(RegistrationRequest registrationRequest) {
		if (registrationRequest == null) {
			return false;
		}
		if (registrationRequest.getName().length() < 3 || registrationRequest.getName().length() > 20) {
			return false;
		}

		if (registrationRequest.getPassword().matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,40}$")) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a task name is legit
	 * 
	 * @param task the task name
	 * @return if its legit
	 */
	public boolean checkTaskName(String task) {
		if (task.length() <= 50 && task.length() >= 1) {
			return true;
		}
		return false;
	}

	/**
	 * Checks if a UID is legit
	 * 
	 * @param groupUUID the group UID
	 * @return if its legit
	 */
	public boolean checkUID(String groupUUID) {
		if (groupUUID == null) {
			return false;
		}
		if (groupUUID.length() > 30 || groupUUID.length() < 1) {
			return false;
		}
		isValid(groupUUID);
		return true;
	}

	/**
	 * checks if a String is valid
	 * 
	 * @param matteoCode wuid which should get checked
	 * @return boolean if its valid or not
	 */
	private boolean isValid(String matteoCode) {
		for (int i = 0; i < matteoCode.length(); i++) {
			char c = matteoCode.charAt(i);
			if (!(Character.isLetter(c) || Character.isDigit(c))) {
				return false;
			}
		}
		return true;
	}
}
