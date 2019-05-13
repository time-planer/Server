package com.niton.db.impl;

import static com.niton.db.tables.Task.TASK;

import java.sql.Date;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.jooq.types.UByte;

import com.niton.db.routines.Updatetask;
import com.niton.db.tables.records.TaskRecord;
import com.niton.model.EditTask;
import com.niton.model.Task;
/**
 * Got information about a group task
 * @author Tobias Schrottwieser
 * 04.03.2019
 * 14:13:38
 */
public class GroupTaskDatabase {

	private String task;
	private String user;
	private Integer group;
	private final DSLContext sql;

	/**
	 * Default Constructor
	 * @param user the user
	 * @param sql the current sql connection
	 */
	public GroupTaskDatabase(String user, DSLContext sql) {
		this.user = user;
		this.sql = sql;
	}

	/**
	 * delets a task
	 */
	public void delete() {
		// TODO Auto-generated method stub
		sql.deleteFrom(TASK).where(TASK.NAME.eq(task)).and(TASK.GROUP_UID.eq(group));
	}

	/**
	 * Edits a task
	 * @param importance edit task
	 */
	public void edit(EditTask importance) {
		TaskRecord gR = sql.selectFrom(TASK).where(TASK.GROUP_UID.eq(group)).fetchOne();
		
		
		Updatetask job = new  Updatetask();
		job.attach(sql.configuration());
		job.setGroupuid(String.valueOf(group));
		job.setName_(task);
		if (importance.getDeadline() != null) {
			job.setNdeadline(Date.valueOf(importance.getDeadline()));
		}else {
			job.setNdeadline(gR.getDeadline());
		}
		if (importance.getDescription() != null) {
			job.setNdescription(importance.getDescription());
		} else {
			job.setNdescription(gR.getDescription());
		}
//		if (importance.getImportance() != null) {
//			job.set(UByte.valueOf(importance.getImportance()));
//		}
		if (importance.getPlanedDate() != null) {
			job.setNplaneddate(Date.valueOf(importance.getPlanedDate()));
		}else {
			job.setNplaneddate(gR.getPlaneddate());
		}
		job.execute();
	}
	/**
	 * @return if a task exists
	 */
	public boolean exists() {
		// TODO Auto-generated method stub
		return sql.selectFrom(TASK).where(TASK.GROUP_UID.eq(group)).fetch().size() > 0;
	}

	/**
	 * @return the informations of a task
	 */
	public Task information() {
		// TODO Auto-generated method stub
		SelectConditionStep<TaskRecord> a = sql.selectFrom(TASK)
				.where(TASK.GROUP_UID.eq(group).and(TASK.NAME.eq(task)).and(TASK.USERS_EMAIL.eq(user)));
		Result<TaskRecord> ts = a.fetch();
		TaskRecord gT = ts.get(0);
		Task t = new Task().name(gT.getName()).deadline(gT.getDeadline().toLocalDate()).description(gT.getDescription())
				.planedDate(gT.getPlaneddate().toLocalDate()).importance(gT.getImportance().intValue())
				.entererAt(gT.getEntererat().toLocalDate()).process(gT.getProcess().intValue());
		return t;
	}
	/**
	 * Sets the task
	 * @param task the new task
	 */
	public void setTask(String task) {
		this.task = task;
	}
	/**
	 * Sets the task name
	 * @param name new name of the task
	 */
	public void setTaskName(String name) {
		task = name;
	}

	/**
	 * Sets new uid
	 * @param uid the new uid
	 */
	public void setUid(Integer uid) {
		group = uid;
	}
	public void setUser(String user) {
		this.user = user;
	}

}
