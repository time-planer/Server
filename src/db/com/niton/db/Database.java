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
	private static final boolean local = System.getProperty("user.home").toUpperCase().startsWith("C:");

	public static Database getInstance() {
		if (instance == null)
			instance = new Database();
		return instance;
	}

	private TimerTask reconector = new TimerTask() {

		@Override
		public void run() {
			try {
				if (connection != null)
					if (!connection.isClosed())
						connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
			String password;
			String user;
			if (!local) {
				user = "nils";
				password = "ofEGfy79Xr0bl3ZuWT5S9NAG";
			} else {
				user = "eds_server";
				password = "admin";
			}
			String url = "jdbc:mysql://localhost:3306/eds?serverTimezone=CET";
			String driver = "com.mysql.jdbc.Driver";
			try {
				Class.forName(driver).newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				System.out.println("Error connecting to database!");
				e1.printStackTrace();
			}
			try {
				connection = DriverManager.getConnection(url, user, password);
				Settings s = new Settings();
				if (OpenAPI2SpringBoot.logDB)
					s = s.withDebugInfoOnStackTrace(true).withExecuteLogging(true);
				sql = DSL.using(connection, SQLDialect.MYSQL, s);
				if(group == null) {
					Database.this.user = new UserDatabase(sql);
					group = new GroupDatabase(sql);
					groups = new GroupsDatabase(sql);
					task = new TaskDatabase(sql);
					tasks = new TasksDatabase(sql);
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
		t.scheduleAtFixedRate(reconector, 0, 60 * 60);
		
		try {
			if (connection != null)
				if (!connection.isClosed())
					connection.close();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		String password;
		String user;
		if (!local) {
			user = "nils";
			password = "ofEGfy79Xr0bl3ZuWT5S9NAG";
		} else {
			user = "eds_server";
			password = "admin";
		}
		String url = "jdbc:mysql://localhost:3306/eds?serverTimezone=CET";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			System.out.println("Error connecting to database!");
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, user, password);
			Settings s = new Settings();
			if (OpenAPI2SpringBoot.logDB)
				s = s.withDebugInfoOnStackTrace(true).withExecuteLogging(true);
			sql = DSL.using(connection, SQLDialect.MYSQL, s);
			if(group == null) {
				Database.this.user = new UserDatabase(sql);
				group = new GroupDatabase(sql);
				groups = new GroupsDatabase(sql);
				task = new TaskDatabase(sql);
				tasks = new TasksDatabase(sql);
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

	public GroupDatabase group(String uid) {
		group.setUid(uid);
		return group;
	}

	public GroupsDatabase groups() {
		return groups;
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
