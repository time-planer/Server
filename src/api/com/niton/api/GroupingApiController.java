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
import com.niton.api.old.MyGroups;
import com.niton.model.EditGroup;
import com.niton.model.InitialGroup;

import io.swagger.annotations.ApiParam;

@Controller
@RequestMapping("${openapi.Time Planer Server.base-path:/time-planer}")
public class GroupingApiController implements GroupingApi {

	private final NativeWebRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public GroupingApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public ResponseEntity<?> createGroup(@Size(min = 7, max = 320) @PathVariable("username") String username,
			@ApiParam(value = "") @Valid @RequestBody InitialGroup initialGroup) {
		return MyGroups.createGroup(request, username, initialGroup);
	}

	@Override
	public ResponseEntity<?> deleteGroup(@Size(min=7,max=320) @ApiParam(value = "The users name",required=true) @PathVariable("username") String username,@Size(min=30,max=30) @ApiParam(value = "The UUID of the group to operate with",required=true) @PathVariable("group_UUID") String groupUUID) {
        return MyGroups.deleteGroup(request, username, groupUUID);
	}

	@Override
	public ResponseEntity<?> editGroup(@Size(min=7,max=320) @ApiParam(value = "The users name",required=true) @PathVariable("username") String username,@Size(min=30,max=30) @ApiParam(value = "The UUID of the group to operate with",required=true) @PathVariable("group_UUID") String groupUUID,@ApiParam(value = "The edit information  You also can only edit a few values or none, all parameters are optional"  )  @Valid @RequestBody EditGroup editGroup) {
        return MyGroups.editGroup(request, username, groupUUID, editGroup);
	}

	@Override
	public ResponseEntity<?> getGroup(@Size(min=7,max=320) @PathVariable("username") String username,@Size(min=30,max=30) @ApiParam(value = "The UUID of the group to operate with",required=true) @PathVariable("group_UUID") String groupUUID) {
        return MemberingGroups.getGroup(request, username, groupUUID);
	}

	@Override
	public ResponseEntity<?> getGroups(@Size(min=7,max=320) @ApiParam(value = "The users name",required=true) @PathVariable("username") String username) {
        return MemberingGroups.getGroups(request, username);
	}

	@Override
	public ResponseEntity<?> getOwnedGroup(@Size(min=7,max=320) @ApiParam(value = "The users name",required=true) @PathVariable("username") String username,@Size(min=30,max=30) @ApiParam(value = "The UUID of the group to operate with",required=true) @PathVariable("group_UUID") String groupUUID) {
        return MyGroups.getOwnedGroup(request, username, groupUUID);
	}

	@Override
	public ResponseEntity<?> getOwnedGroups(@Size(min=7,max=320) @ApiParam(value = "The users name",required=true) @PathVariable("username") String username) {
        return MyGroups.getOwnedGroups(request, username);
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

}
