package com.niton.db.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectConditionStep;
import org.jooq.types.UByte;

import com.niton.db.Database;
import com.niton.db.Tables;
import com.niton.db.tables.records.TaskRecord;
import com.niton.model.InitialTask;
import com.niton.model.Task;
/**
 * 
 * @author Tobias Schrottwieser
 * 27.02.2019
 * 17:05:59
 */
public class TasksDatabase {

	private String user;
	private DSLContext sql;
	/**
	 * 
	 * @param sql
	 */
	public TasksDatabase(DSLContext sql) {
		this.sql = sql;
	}
	/**
	 * 
	 * @param initialTask
	 */
	public void add(InitialTask initialTask) {
		
//		sql.insertQuery(TASK).addRecord(new TaskRecord(initialTask.getName(), toDate(initialTask.getDeadline()), toDate(initialTask.getPlanedDate()), initialTask.getDescription(),UByte.valueOf(initialTask.getImportance()) , null, null, null, user, null));
		try {
			sql.insertInto(Tables.TASK).columns(Tables.TASK.NAME, Tables.TASK.DEADLINE, Tables.TASK.PLANEDDATE, Tables.TASK.DESCRIPTION, Tables.TASK.IMPORTANCE, Tables.TASK.USERS_EMAIL,Tables.TASK.GROUP_UID).values(initialTask.getName(), toDate(initialTask.getDeadline()), toDate(initialTask.getPlanedDate()), initialTask.getDescription(),UByte.valueOf(initialTask.getImportance()) ,user,Database.getInstance().user().privateUID()).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Task> list() {
		ArrayList<Task> at = new ArrayList<>();
		SelectConditionStep<Record> a = sql.select().from(Tables.TASK).where(Tables.TASK.GROUP_UID.eq(Database.getInstance().user().privateUID()));
		Result<Record> rs = a.fetch();
		for (Record re : rs) {
			TaskRecord r = (TaskRecord) re;
			Task t = new Task()
					.name(r.getName())
					.deadline(r.getDeadline().toLocalDate())
					.description(r.getDescription())
					.entererAt(r.getEntererat().toLocalDate())
					.importance(r.getImportance().intValue())
					.planedDate(r.getPlaneddate().toLocalDate());
			at.add(t);
		}
		return at;
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
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}
	/**
	 * 
	 * @param ld
	 * @return
	 */
	private Date toDate(LocalDate ld) {
		return Date.valueOf(ld);
	}

}
