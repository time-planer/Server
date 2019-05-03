package com.niton.db.impl;

import static com.niton.db.tables.Task.TASK;

import java.sql.Date;
import java.util.ArrayList;

import org.jooq.DSLContext;
import org.jooq.types.UByte;

import com.niton.db.routines.Addtask;
import com.niton.db.tables.records.TaskRecord;
import com.niton.model.InitialTask;
import com.niton.model.Task;
/**
 * This class contains methods which are used for adding a task 
 * @author Tobias Schrottwieser
 * 27.02.2019
 * 17:11:08
 */
public class GroupTasksDatabase {
	private String user;
	private DSLContext sql;
	private Integer uid;
	/**
	 * Default Constructor
	 * @param user
	 * @param sql
	 */
	public GroupTasksDatabase(String user, DSLContext sql) {
		this.user = user;
		this.sql = sql;
	}
	/**
	 * The methode used to add a new task to a group
	 * @param initialTask contains the variables needed to create the task
	 */
	public void add(InitialTask initialTask) {
		Addtask a = new Addtask();
//		TaskRecord tr = TASK.newRecord();
		a.attach(sql.configuration());
		a.setName_(initialTask.getName());
		a.setDeadline(Date.valueOf(initialTask.getDeadline()));
		a.setPlaneddate(Date.valueOf(initialTask.getPlanedDate()));
		a.setDescription(initialTask.getDescription());
		a.setImportance(initialTask.getImportance().byteValue());
		a.setGroupuid(String.valueOf(uid));
		a.execute();
	}
	/**
	 * @return a list of all tasks contained in the current group
	 */
	public ArrayList<Task> list() {
		// TODO Auto-generated method stub
		ArrayList<TaskRecord> groupTaskList = new ArrayList<>();
		org.jooq.Result<TaskRecord> gt = sql.selectFrom(TASK).where(TASK.GROUP_UID.eq(uid)).fetch();
		groupTaskList.addAll(gt);
		ArrayList<Task> taskList = new ArrayList<>();
		for(TaskRecord tR : groupTaskList) {
			Task task = new Task();
			task.name(tR.getName())
			.entererAt(tR.getEntererat().toLocalDate())
			.deadline(tR.getDeadline().toLocalDate())
			.planedDate(tR.getPlaneddate().toLocalDate())
			.description(tR.getDescription())
			.importance(tR.getImportance().intValue());
			taskList.add(task);
		}
		return taskList;
	}
	/**
	 * @param uid is used to set the unique uid for the task
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public void setUser(String user) {
		this.user = user;
	}
}
