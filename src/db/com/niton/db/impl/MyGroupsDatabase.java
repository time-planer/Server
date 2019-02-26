package com.niton.db.impl;

import java.nio.ByteBuffer;
import java.util.ArrayList;

import org.jooq.DSLContext;

import com.googlecode.mp4parser.boxes.mp4.samplegrouping.GroupEntry;
import com.mysql.cj.xdevapi.Result;
import com.niton.db.tables.records.GroupRecord;
import com.niton.db.tables.records.GroupmemberRecord;
import com.niton.model.InitialGroup;
import com.niton.model.ReducedGroup;
import com.sun.mail.imap.protocol.UIDSet;

import static com.niton.db.tables.Group.GROUP;
import static com.niton.db.tables.Groupmember.GROUPMEMBER;

public class MyGroupsDatabase {

	private String user;
	private DSLContext sql;

	public MyGroupsDatabase(String user, DSLContext sql) {
		this.user = user;
		this.sql = sql;
	}

	public void create(InitialGroup description) {
		// TODO Auto-generated method stub
		GroupRecord gr = new GroupRecord();
		gr.setDescription(description.getDescription());
		gr.setName(description.getName());
		gr.setCreator(user);
		gr.store();
	}

	public ArrayList<ReducedGroup> list() {
		// TODO Auto-generated method stub
		ArrayList<ReducedGroup> list = new ArrayList<ReducedGroup>();
		org.jooq.Result<GroupRecord> rg = sql.selectFrom(GROUP).where(GROUP.CREATOR.eq(user)).fetch();
		for(GroupRecord f : rg){
			ReducedGroup pushing = new ReducedGroup();
			pushing.description(f.getDescription()).name(f.getName()).creationDate(f.getCreationDate().toLocalDate()).;
			
		}
		return ;
	}
	
	public ArrayList<GroupmemberRecord> getGroupMmbers(String uid){
		ArrayList<GroupmemberRecord> groupMember = new ArrayList<GroupmemberRecord>();
		org.jooq.Result<GroupmemberRecord> gr = sql.selectFrom(GROUPMEMBER).where(GROUPMEMBER.GROUP.eq(uid)).fetch();
		return ;
	}
}
