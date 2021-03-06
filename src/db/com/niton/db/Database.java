package com.niton.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

import com.niton.OpenAPI2SpringBoot;
import com.niton.db.impl.GroupDatabase;
import com.niton.db.impl.GroupsDatabase;
import com.niton.db.impl.TaskDatabase;
import com.niton.db.impl.TasksDatabase;
import com.niton.db.impl.UserDatabase;

public class Database {
	private static Database instance = null;
	private static final String host     = "jdbc:mysql://projekte.tgm.ac.at:3306/proj_eds?serverTimezone=CET&noAccessToProcedureBodies=true&autoReconnect=true&useUnicode=yes";
	private static final String db_user  = "proj_eds";
	private static final String password = "EbohLii7";
	private static final String driver   = "com.mysql.jdbc.Driver";

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();
		return instance;
	}

	private TimerTask reconector = new TimerTask() {

		@Override
		public void run() {
			if(!isConnected())
				connect();
		}
	};

	private UserDatabase user;

	private DSLContext sql;
	
	private Connection connection;

	private com.niton.db.impl.GroupDatabase group;

	private com.niton.db.impl.GroupsDatabase groups;

	private TaskDatabase task;

	private TasksDatabase tasks;

	private Database() {
		Timer t = new Timer();
		t.scheduleAtFixedRate(reconector, 10*1000, 1000);
		connect();
	}

	public void connect() {
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			System.out.println("Error connecting to database!");
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(host, db_user, password);
			Settings s = new Settings();
			if (OpenAPI2SpringBoot.logDB)
				s = s.withDebugInfoOnStackTrace(true).withExecuteLogging(true);
			sql = DSL.using(connection, SQLDialect.MYSQL, s);
			if(group == null) {
				Database.this.user = new UserDatabase(sql);
				group              = new GroupDatabase(sql);
				groups             = new GroupsDatabase(sql);
				task               = new TaskDatabase(sql);
				tasks              = new TasksDatabase(sql);
			}else {
				group.setSql(sql);
				groups.setSQL(sql);
				task.setSQL(sql);
				tasks.setSQL(sql);
				Database.this.user.setSql(sql);
			}
		} catch (Exception e) {
			System.out.println("Error connecting to database!");
			e.printStackTrace();
		}
	}
	public GroupDatabase group(Integer groupUUID) {
		group.setUid(groupUUID);
		return group;
	}

	public GroupsDatabase groups() {
		return groups;
	}

	public boolean isConnected() {
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			return false;
		}
	}

	public void setUser(String string) {
		user.setEmail(string);
		group.setUser(string);
		groups.setUser(string);
		task.setUser(string);
		tasks.setUser(string);
	}

	public TaskDatabase task(String name) {
		task.setTaskname(name);
		return task;
	}

	public TasksDatabase tasks() {
		return tasks;
	}
	public UserDatabase user() {
		return user;
	}
}
