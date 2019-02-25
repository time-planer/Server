package com.niton.api.old;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import com.niton.db.Database;
import com.niton.db.impl.Validator;
import com.niton.model.EditTask;
import com.niton.model.ErrorResponse;
import com.niton.model.ErrorResponse.MessageEnum;
import com.niton.model.InitialTask;
import com.niton.model.SuccessResponse;
import com.niton.model.Task;


@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaInflectorServerCodegen", date = "2019-01-06T10:48:32.684838100+01:00[Europe/Berlin]")
public class Tasking  {

	private static Database db = Database.getInstance();

	private static Validator v = Validator.getInstance();

	public static  ResponseEntity<?> addTask(NativeWebRequest request , String username, InitialTask initialTask) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if(!v.checkInitTask(initialTask))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		db.tasks().add(initialTask);
		return responde(db.task(initialTask.getName()).information());
	}

	private static ResponseEntity<ErrorResponse> authentificate(NativeWebRequest request, String email) {
		String key = request.getHeader("user_key");
		if (key == null)
			return sendError(403, MessageEnum.API_KEY_MISSING);
		if (!v.checkEmail(email))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		db.setUser(email);
		if (!db.user().exists())
			return sendError(404, MessageEnum.USER_NOT_FOUND);
		if (!db.user().apikey().equals(key))
			return sendError(401, MessageEnum.API_KEY_WRONG);
		return null;
	}

	public static  ResponseEntity<?> deleteTask(NativeWebRequest request , String username, String task) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if(!v.checkTaskName(task))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if(!db.task(task).exists())
			return sendError(404, MessageEnum.TASK_NOT_FOUND);
		Task t = db.task(task).information();
		db.task(task).delete();
		return responde(t);
	}

	public static  ResponseEntity<?> editTask(NativeWebRequest request , String username, String task, EditTask editTask) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if (!v.checkTaskName(task))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		
		if(!db.task(task).exists())
			return sendError(404, MessageEnum.TASK_NOT_FOUND);
		db.task(task).edit(editTask);
		return responde(db.task(task).information());
	}

	public static  ResponseEntity<?> getAllTasks(NativeWebRequest request , String username) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		return responde(db.tasks().list());
	}
	public static  ResponseEntity<?> getTask(NativeWebRequest request , String username, String task) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if (!v.checkTaskName(task))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		
		if(!db.task(task).exists())
			return sendError(404, MessageEnum.TASK_NOT_FOUND);
		return responde(db.task(task).information());
	}

	public static  ResponseEntity<?> removeAllTasks(NativeWebRequest request , String username) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		ArrayList<Task> l = db.tasks().list();
		for (Task task : l) {
			db.task(task.getName()).delete();
		}
		return responde(SuccessResponse.MessageEnum.ALL_TASKS_DELETED);
	}

	private static <T> ResponseEntity<T> responde(T ent) {
		return new ResponseEntity<>(ent, HttpStatus.OK);
	}

	private static ResponseEntity<ErrorResponse> sendError(int status ,MessageEnum error) {
		return new ResponseEntity<>(new ErrorResponse().message(error), HttpStatus.resolve(status));
	}


}

