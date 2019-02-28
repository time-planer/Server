package com.niton.test;

import java.util.ArrayList;

import com.niton.db.Database;
import com.niton.model.*;
/**
 * Used for debugging
 * @author Tobias Schrottwieser
 * 27.02.2019
 * 19:04:46
 */
public class DBTest {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
		Database db = Database.getInstance();
		db.setUser("ameth@student.tgm.ac.at");

		             db.user().register("Ich Zocke","12345678");
		boolean ue = db.user().exists();
		String key = db.user().apikey();
		             db.user().delete();
  
		boolean                 ge      = db.group("arandomID").exists();
		ReducedGroup            rg      = db.group("arandomID").information();
		Group                   g       = db.group("arandomID").detailed();
		ArrayList<GroupMember>  mblst   = db.group("arandomID").members();
		GroupMember             mb      = db.group("arandomID").member("nbrugger@student.tgm.ac.at");
										  db.group("arandomID").delete();
										  db.group("arandomID").edit(new EditGroup().name("New Name"));
										  
										  
										  db.group("arandomID").tasks().add(new InitialTask()/*set values*/);
        ArrayList<Task>         grptsks = db.group("arandomID").tasks().list();
		
		boolean  gte = db.group("arandomID").task("Task 1").exists();
		Task       t = db.group("arandomID").task("Task 1").information();
		               db.group("arandomID").task("Task 1").delete();
		               db.group("arandomID").task("Task 1").edit(new EditTask().importance(10));
		               
		ArrayList<ReducedGroup>   grps = db.groups().created();
	                              db.groups().add(new InitialGroup()/*setValue*/);
		                        
	                                    
	                                     db.groups().create(new InitialGroup().name("Task 2").description("AA radoom"));
		ArrayList<ReducedGroup> mygrps = db.groups().list();
//		
//		                       db.tasks().add(new InitialTask()/*set values*/);
//		ArrayList<Task> tsks = db.tasks().list();
//		
//		boolean te = db.task("Task 1").exists();
//		Task    pt = db.task("Task 1").information();
//		             db.task("Task 1").delete();
//		             db.task("Task 1").edit(new EditTask().importance(10));
	}

}
