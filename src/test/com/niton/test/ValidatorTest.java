package com.niton.test;

import com.niton.db.impl.Validator;

public class ValidatorTest {
	public static void main(String[] args) {
		boolean skip = true;
		String[] rightEmails = {
			"a@student.tgm.ac.at",
			"a@tgm.ac.at",
			"a@gmail.com",
			"a@gmx.at",
			"areinbimmel@gmx.com"
		};
		String[] wrongEmails = {
			"@student.tgm.ac.at",
			"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@tgm.ac.at",
			"a@gmail.",
			"a@gmail.c",
			"areinbimmel@.student.tgm.ac.at",
			"areinbimmel@student.tgm.ac.at.",
			"areinbimmel@.student.tgm.ac.at",
			"areinbimmel.student.tgm.ac.at",
			"areinbimmel@yahoo.com",
			"plainaddress.gmail.com",
			"#@%^%#$@#$@gmail.com",
			"@example.com",
			"Joe Smith <email@gmail.com>",
			"email.gmail.com",
			"email@example@gmail.com",
			".email@gmail.com",
			"email.@gmail.com",
			"email..email@gmail.com",
			"あいうえお@gmail.com",
			"email@gmail.com (Joe Smith)",
			"email@example",
			"email@-gmail.com",
			"email@gmail.web",
			"email@example..com",
			"Abc..123@example.com"
		};
		for (String string : rightEmails)
			if(Validator.getInstance().checkEmail(string))
				System.out.println("Checked "+string+" : RIGHT");
			else {
				System.err.println(string+" Should be right but was false!");
				if(!skip)
				return;
			}
		for (String string : wrongEmails) {
			if(Validator.getInstance().checkEmail(string))
				System.out.println("Checked "+string+" : RIGHT");
			else {
				System.err.println(string+" Should be false but was true!");
				if(!skip)
				return;
			}
		}
	}
}
