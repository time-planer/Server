package com.niton.db.impl;

import static com.niton.db.tables.Task.TASK;

import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectConditionStep;

import com.niton.db.Database;
import com.niton.db.tables.records.TaskRecord;
import com.niton.model.EditTask;
import com.niton.model.Task;
/**
 * 
 * @author Tobias Schrottwieser
 * 27.02.2019
 * 17:05:55
 */
public class TaskDatabase {

	private String user,taskname;
	private DSLContext sql;

	/**
	 * 
	 * @param sql
	 */
	public TaskDatabase(DSLContext sql) {
		this.sql = sql;
	}
	/**
	 * 
	 */
	public void delete() {
		sql.delete(TASK).where(thisPrivateTask()).execute();
	}
	/**
	 * 
	 * @param importance
	 */
	public void edit(EditTask importance) {
		TaskRecord r = sql.selectFrom(TASK).where(thisPrivateTask()).fetchOne();
		r = importance.getSQL(r);
		r.store();
	}
	/**
	 * 
	 * @return
	 */
	public boolean exists() {
		return sql.select().from(TASK).where(thisPrivateTask()).fetch().size()>0;
	}
	/**
	 * 
	 * @return
	 */
	private Condition thisPrivateTask() {
		return 
				TASK.NAME.eq(taskname)
					.and(
							TASK.USERS_EMAIL.eq(user)
					)
					.and(
							TASK.GROUP_UID.eq(Database.getInstance().user().privateUID()
					)
				);
	}
	/**
	 * 
	 * @return
	 */
	public Task information() {
		SelectConditionStep<Record> a = sql.select().from(TASK).where(thisPrivateTask()).and(TASK.NAME.eq(taskname));
		Result<Record> rs = a.fetch();
		TaskRecord r = (TaskRecord) rs.get(0);
		Task t = new Task()
				.name(r.getName())
				.deadline(r.getDeadline().toLocalDate())
				.description(r.getDescription())
				.entererAt(r.getEntererat().toLocalDate())
				.importance(r.getImportance().intValue())
				.planedDate(r.getPlaneddate().toLocalDate());
		return t;
	}
	/**
	 * 
	 * @param sql2
	 */
	public void setSQL(DSLContext sql2) {
		sql = sql2;
		
	}
	/**
	 * 
	 * @param taskname
	 */
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	/**
	 * 
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}
}
