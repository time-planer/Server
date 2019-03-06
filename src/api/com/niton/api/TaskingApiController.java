package com.niton.api;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;

import com.niton.api.old.MemberingGroups;
import com.niton.api.old.Tasking;
import com.niton.model.EditTask;
import com.niton.model.InitialTask;

import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("${openapi.Time Planer Server.base-path:/time-planer}")
public class TaskingApiController implements TaskingApi {

	private final NativeWebRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public TaskingApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public ResponseEntity<?> addGroupTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 30, max = 30) @PathVariable("group_UUID") String groupUUID,
			@Valid @RequestBody InitialTask initialTask) {
		return MemberingGroups.addGroupTask(request, username, groupUUID, initialTask);
	}

	@Override
	public ResponseEntity<?> addTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Valid @RequestBody InitialTask initialTask) {
		System.out.println("TaskingApiController.addTask(" + initialTask + ")");
		return Tasking.addTask(request, username, initialTask);
	}

	@Override
	public ResponseEntity<?> deleteGroupTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task,
			@Size(min = 30, max = 30) @PathVariable("group_UUID") String groupUUID) {
		return MemberingGroups.deleteGroupTask(request, username, task, groupUUID);
	}

	@Override
	public ResponseEntity<?> deleteTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task) {
		return Tasking.deleteTask(request, username, task);
	}

	@Override
	public ResponseEntity<?> editGroupTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task,
			@Size(min = 30, max = 30) @PathVariable("group_UUID") String groupUUID,
			@Valid @RequestBody EditTask editTask) {
		return MemberingGroups.editGroupTask(request, username, task, groupUUID, editTask);
	}

	@Override
	public ResponseEntity<?> editTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task, @Valid @RequestBody EditTask editTask) {
		return Tasking.editTask(request, username, task, editTask);
	}

	@Override
	public ResponseEntity<?> getAllGroupTasks(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 30, max = 30) @PathVariable("group_UUID") String groupUUID) {
		return MemberingGroups.getAllGroupTasks(request, username, groupUUID);
	}

	@Override
	public ResponseEntity<?> getAllTasks(
			@Size(min = 7, max = 320) @PathVariable("username") String username) {
		return Tasking.getAllTasks(request, username);
	}

	@Override
	public ResponseEntity<?> getGroupTask(
			@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task,
			@Size(min = 30, max = 30) @PathVariable("group_UUID") String groupUUID) {
		return MemberingGroups.getGroupTask(request, username, task, groupUUID);
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<?> getTask(
			@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task) {
		return Tasking.getTask(request, username, task);
	}

	@Override
	public ResponseEntity<?> removeAllGroupTasks(
			@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 30, max = 30) @PathVariable("group_UUID") String groupUUID) {
		return MemberingGroups.removeAllGroupTasks(request, username, groupUUID);
	}

	@Override
	public ResponseEntity<?> removeAllTasks(
			@Size(min = 7, max = 320) @PathVariable("username") String username) {
		return Tasking.removeAllTasks(request, username);
	}

}
