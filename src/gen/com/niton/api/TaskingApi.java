/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (3.3.4).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.niton.api;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import com.niton.model.EditTask;
import com.niton.model.InitialTask;

@Validated
public interface TaskingApi {

	@RequestMapping(value = "/user/{username}/group/{group_UUID}/tasks", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<?> addGroupTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@PathVariable("group_UUID") Integer groupUUID,
			@Valid @RequestBody InitialTask initialTask) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"process\" : 8,  \"importance\" : 4,  \"name\" : \"name\",  \"description\" : \"description\",  \"entererAt\" : \"2000-01-23\",  \"deadline\" : \"2000-01-23\",  \"planedDate\" : \"2000-01-23\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@RequestMapping(value = "/user/{username}/tasks", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	default ResponseEntity<?> addTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Valid @RequestBody InitialTask initialTask) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"process\" : 8,  \"importance\" : 4,  \"name\" : \"name\",  \"description\" : \"description\",  \"entererAt\" : \"2000-01-23\",  \"deadline\" : \"2000-01-23\",  \"planedDate\" : \"2000-01-23\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@RequestMapping(value = "/user/{username}/group/{group_UUID}/task/{task}", produces = {
			"application/json" }, method = RequestMethod.DELETE)
	default ResponseEntity<?> deleteGroupTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task,
			@PathVariable("group_UUID") Integer groupUUID) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"process\" : 8,  \"importance\" : 4,  \"name\" : \"name\",  \"description\" : \"description\",  \"entererAt\" : \"2000-01-23\",  \"deadline\" : \"2000-01-23\",  \"planedDate\" : \"2000-01-23\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@RequestMapping(value = "/user/{username}/task/{task}", produces = {
			"application/json" }, method = RequestMethod.DELETE)
	default ResponseEntity<?> deleteTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"process\" : 8,  \"importance\" : 4,  \"name\" : \"name\",  \"description\" : \"description\",  \"entererAt\" : \"2000-01-23\",  \"deadline\" : \"2000-01-23\",  \"planedDate\" : \"2000-01-23\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@RequestMapping(value = "/user/{username}/group/{group_UUID}/task/{task}", produces = {
			"application/json" }, consumes = { "application/json" }, method = RequestMethod.PATCH)
	default ResponseEntity<?> editGroupTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task,
			@PathVariable("group_UUID") Integer groupUUID,
			@Valid @RequestBody EditTask editTask) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"process\" : 8,  \"importance\" : 4,  \"name\" : \"name\",  \"description\" : \"description\",  \"entererAt\" : \"2000-01-23\",  \"deadline\" : \"2000-01-23\",  \"planedDate\" : \"2000-01-23\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@RequestMapping(value = "/user/{username}/task/{task}", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.PATCH)
	default ResponseEntity<?> editTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task, @Valid @RequestBody EditTask editTask) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"process\" : 8,  \"importance\" : 4,  \"name\" : \"name\",  \"description\" : \"description\",  \"entererAt\" : \"2000-01-23\",  \"deadline\" : \"2000-01-23\",  \"planedDate\" : \"2000-01-23\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@RequestMapping(value = "/user/{username}/group/{group_UUID}/tasks", produces = {
			"application/json" }, method = RequestMethod.GET)
	default ResponseEntity<?> getAllGroupTasks(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@PathVariable("group_UUID") Integer groupUUID) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"process\" : 8,  \"importance\" : 4,  \"name\" : \"name\",  \"description\" : \"description\",  \"entererAt\" : \"2000-01-23\",  \"deadline\" : \"2000-01-23\",  \"planedDate\" : \"2000-01-23\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@RequestMapping(value = "/user/{username}/tasks", produces = { "application/json" }, method = RequestMethod.GET)
	default ResponseEntity<?> getAllTasks(@Size(min = 7, max = 320) @PathVariable("username") String username) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"process\" : 8,  \"importance\" : 4,  \"name\" : \"name\",  \"description\" : \"description\",  \"entererAt\" : \"2000-01-23\",  \"deadline\" : \"2000-01-23\",  \"planedDate\" : \"2000-01-23\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@RequestMapping(value = "/user/{username}/group/{group_UUID}/task/{task}", produces = {
			"application/json" }, method = RequestMethod.GET)
	default ResponseEntity<?> getGroupTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task,
			@PathVariable("group_UUID") Integer groupUUID) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"process\" : 8,  \"importance\" : 4,  \"name\" : \"name\",  \"description\" : \"description\",  \"entererAt\" : \"2000-01-23\",  \"deadline\" : \"2000-01-23\",  \"planedDate\" : \"2000-01-23\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	default Optional<NativeWebRequest> getRequest() {
		return Optional.empty();
	}

	@RequestMapping(value = "/user/{username}/task/{task}", produces = {
			"application/json" }, method = RequestMethod.GET)
	default ResponseEntity<?> getTask(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@Size(min = 1, max = 50) @PathVariable("task") String task) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"process\" : 8,  \"importance\" : 4,  \"name\" : \"name\",  \"description\" : \"description\",  \"entererAt\" : \"2000-01-23\",  \"deadline\" : \"2000-01-23\",  \"planedDate\" : \"2000-01-23\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@RequestMapping(value = "/user/{username}/group/{group_UUID}/tasks", produces = {
			"application/json" }, method = RequestMethod.DELETE)
	default ResponseEntity<?> removeAllGroupTasks(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@PathVariable("group_UUID") Integer groupUUID) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"message\" : \"registration worked\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

	}

	@RequestMapping(value = "/user/{username}/tasks", produces = { "application/json" }, method = RequestMethod.DELETE)
	default ResponseEntity<?> removeAllTasks(@Size(min = 7, max = 320) @PathVariable("username") String username) {
		getRequest().ifPresent(request -> {
			for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
				if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
					ApiUtil.setExampleResponse(request, "application/json",
							"{  \"message\" : \"registration worked\"}");
					break;
				}
			}
		});
		return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
	}
}
