package com.niton.api.old;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import com.niton.db.Database;
import com.niton.db.impl.Validator;
import com.niton.model.EditTask;
import com.niton.model.ErrorResponse;
import com.niton.model.ErrorResponse.MessageEnum;
import com.niton.model.GroupMember;
import com.niton.model.InitialTask;
import com.niton.model.ReducedGroup;
import com.niton.model.Task;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaInflectorServerCodegen", date = "2019-01-06T10:48:32.684838100+01:00[Europe/Berlin]")
public class MemberingGroups {

	private static Database db = Database.getInstance();
	private static Validator v = Validator.getInstance();

	public static ResponseEntity<?> addGroupTask(NativeWebRequest nativeWebRequest, String username, Integer groupUUID,
			InitialTask initialTask) {
		ResponseEntity<ErrorResponse> context = authentificate(nativeWebRequest, username);
		if (context != null)
			return context;
		if (!v.checkUID(groupUUID) || !v.checkInitTask(initialTask))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);

		GroupMember member = db.group(groupUUID).member(username);
		if (member == null || !member.isCreate())
			return sendError(400, MessageEnum.NO_PERMISSION);

		db.group(groupUUID).tasks().add(initialTask);
		return responde(db.group(groupUUID).task(initialTask.getName()).information());
	}

	private static ResponseEntity<ErrorResponse> authentificate(NativeWebRequest request, String email) {
		String key = request.getHeader("user_key");
		if (key == null)
			return sendError(203, MessageEnum.API_KEY_MISSING);
		if (!v.checkEmail(email))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		db.setUser(email);
		if (!db.user().exists())
			return sendError(404, MessageEnum.USER_NOT_FOUND);
		if (!db.user().apikey().equals(key))
			return sendError(401, MessageEnum.API_KEY_WRONG);
		return null;
	}

	public static ResponseEntity<?> deleteGroupTask(NativeWebRequest request, String username, String task, Integer groupUUID) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if (!v.checkTaskName(task) || !v.checkUID(groupUUID))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if (!db.group(groupUUID).exists())
			return sendError(404, MessageEnum.GROUP_NOT_FOUND);
		if (!db.group(groupUUID).task(task).exists())
			return sendError(404, MessageEnum.TASK_NOT_FOUND);
		if (db.group(groupUUID).member(username) == null || !db.group(groupUUID).member(username).isDelete())
			return sendError(403, MessageEnum.NO_PERMISSION);
		Task t = db.group(groupUUID).task(task).information();
		db.group(groupUUID).delete();
		return responde(t);
	}

	public static ResponseEntity<?> editGroupTask(NativeWebRequest request, String username, String task, Integer groupUUID,
			EditTask editTask) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if (!v.checkTaskName(task) || !v.checkUID(groupUUID))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if (!db.group(groupUUID).exists())
			return sendError(404, MessageEnum.GROUP_NOT_FOUND);
		if (!db.group(groupUUID).task(task).exists())
			return sendError(404, MessageEnum.TASK_NOT_FOUND);
		if (db.group(groupUUID).member(username) == null || !db.group(groupUUID).member(username).isEdit())
			return sendError(403, MessageEnum.NO_PERMISSION);
		db.group(groupUUID).task(task).edit(editTask);
		return responde(db.group(groupUUID).task(task).information());
	}

	public static ResponseEntity<?> getAllGroupTasks(NativeWebRequest request, String username, Integer groupUUID) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if (!v.checkUID(groupUUID))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if (!db.group(groupUUID).exists())
			return sendError(404, MessageEnum.GROUP_NOT_FOUND);
		if (db.group(groupUUID).member(username) == null)
			return sendError(403, MessageEnum.NO_PERMISSION);
		return responde(db.group(groupUUID).tasks().list());
	}

	public static ResponseEntity<?> getGroup(NativeWebRequest request, String username, Integer groupUUID) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;

		if (!v.checkUID(groupUUID))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		ReducedGroup g = db.group(groupUUID).information();
		if (g == null)
			return sendError(404, MessageEnum.GROUP_NOT_FOUND);
		if (db.group(groupUUID).member(username) == null)
			return sendError(403, MessageEnum.NO_PERMISSION);
		return responde(g);
	}

	public static ResponseEntity<?> getGroups(NativeWebRequest request, String username) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		return responde(db.groups().list());
	}

	public static ResponseEntity<?> getGroupTask(NativeWebRequest request, String username, String task, Integer groupUUID) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if (!v.checkUID(groupUUID) || !v.checkTaskName(task))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if (!db.group(groupUUID).exists())
			return sendError(404, MessageEnum.GROUP_NOT_FOUND);
		if (!db.group(groupUUID).task(task).exists())
			return sendError(404, MessageEnum.TASK_NOT_FOUND);
		if (db.group(groupUUID).member(username) == null)
			return sendError(403, MessageEnum.NO_PERMISSION);
		return responde(db.group(groupUUID).task(task).information());
	}

	public static ResponseEntity<?> removeAllGroupTasks(NativeWebRequest request, String username, Integer groupUUID) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if (!v.checkUID(groupUUID))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if (!db.group(groupUUID).exists())
			return sendError(404, MessageEnum.GROUP_NOT_FOUND);
		if (db.group(groupUUID).member(username) == null || !db.group(groupUUID).member(username).isDelete())
			return sendError(403, MessageEnum.NO_PERMISSION);
		for (String t : db.group(groupUUID).detailed().getTasks())
			db.group(groupUUID).task(t).delete();
		return responde(db.group(groupUUID).detailed());
	}

	private static <T> ResponseEntity<T> responde(T ent) {
		return new ResponseEntity<>(ent, HttpStatus.OK);
	}

	private static ResponseEntity<ErrorResponse> sendError(int status ,MessageEnum error) {
		return new ResponseEntity<>(new ErrorResponse().message(error), HttpStatus.resolve(status));
	}

}
