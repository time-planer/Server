package com.niton.test;

import java.time.LocalDate;
import java.util.ArrayList;

import com.niton.db.Database;
import com.niton.model.EditGroup;
import com.niton.model.InitialGroup;
import com.niton.model.InitialTask;
import com.niton.model.ReducedGroup;

public class GroupTest {
	public static void main(String[] args) {
		Database db = Database.getInstance();
		db.setUser("javatest@gmail.com");
		if(db.user().exists()) {
			System.out.println("Existed!");
			db.user().delete();
		}

		db.user().register("JAVA API Tester", "IchBin2JavaApis");
		System.out.println("Register Worked!");
		db.groups().create(new InitialGroup().name("Test Group1").description("Desc"));
		db.groups().create(new InitialGroup().name("Test Group2").description("Desc"));
		db.groups().create(new InitialGroup().name("Test Group3").description("Desc"));
		System.out.println("Group Created");
		System.out.println("I created:");
		System.out.println("[");
		for (ReducedGroup string : db.groups().created()) {
			System.out.println(string);
		}
		System.out.println("]");
		Integer uid = db.groups().created().get(0).getUid();
		System.out.println("Test UID = "+uid);
		System.out.println("Detailed :");
		System.out.println(db.group(uid).detailed());
		System.out.println("Minimal :");
		System.out.println(db.group(uid).information());
		System.out.println("Members : "+db.group(uid).members());
		db.group(uid).edit(new EditGroup().members(new ArrayList<>()));
		System.out.println("Removed all users");
		db.tasks().add(new InitialTask().deadline(LocalDate.now().plusDays(10)).description("Desc").importance(4).name("Some taisk").planedDate(LocalDate.now().plusDays(1)));
		System.out.println("Created Task");
		System.out.println("Group Tasks : "+db.group(uid).tasks().list());
		System.out.println("\nGroups I am in : ");
		System.out.println(db.groups().list());
		for (ReducedGroup string : db.groups().created()) {
			db.group(string.getUid()).delete();
			System.out.println("Group Deleted");
		}
		db.user().delete();
		System.out.println("User Deleted");
	}
}
