package com.niton.api.old;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;

import com.niton.db.Database;
import com.niton.db.impl.Validator;
import com.niton.model.EditGroup;
import com.niton.model.ErrorResponse;
import com.niton.model.ErrorResponse.MessageEnum;
import com.niton.model.Group;
import com.niton.model.InitialGroup;
import com.niton.model.ReducedGroup;



@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaInflectorServerCodegen", date = "2019-01-06T10:48:32.684838100+01:00[Europe/Berlin]")
public  class MyGroups {

	private static Database db = Database.getInstance();
	private static Validator v = Validator.getInstance();

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

	public static ResponseEntity<?> createGroup(NativeWebRequest request, String username, InitialGroup initialGroup) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if (initialGroup == null || !v.checkInitGroup(initialGroup))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		ArrayList<ReducedGroup> owned = db.groups().created();
		db.groups().create(initialGroup);
		ArrayList<ReducedGroup> owned2 = db.groups().created();
		owned2.removeAll(owned);
		return responde(db.group(owned2.get(0).getUid()).detailed());
	}

	public static ResponseEntity<?> deleteGroup(NativeWebRequest request, String username, String groupUUID) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if (!v.checkUID(groupUUID))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if (!db.group(groupUUID).exists())
			return sendError(404, MessageEnum.GROUP_NOT_FOUND);
		if (!db.group(groupUUID).detailed().getCreator().equals(username))
			return sendError(403, MessageEnum.GROUP_NOT_OWNED);
		Group g = db.group(groupUUID).detailed();
		db.group(groupUUID).delete();
		return responde(g);
	}

	public static ResponseEntity<?> editGroup(NativeWebRequest request, String username, String groupUUID, EditGroup editGroup) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;

		if (!v.checkUID(groupUUID) || !v.checkEditGroup(editGroup))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);

		if (!v.checkUID(groupUUID))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if (!db.group(groupUUID).exists())
			return sendError(404, MessageEnum.GROUP_NOT_FOUND);
		if (!db.group(groupUUID).detailed().getCreator().equals(username))
			return sendError(403, MessageEnum.GROUP_NOT_OWNED);
		db.group(groupUUID).edit(editGroup);
		return responde(db.group(groupUUID).detailed());
	}

	public static ResponseEntity<?> getGroup(NativeWebRequest request, String username, String groupUUID) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		if (!v.checkUID(groupUUID))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if (!db.group(groupUUID).exists())
			return sendError(404, MessageEnum.GROUP_NOT_FOUND);
		if (!db.group(groupUUID).detailed().getCreator().equals(username))
			return sendError(403, MessageEnum.GROUP_NOT_OWNED);
		return responde(db.group(groupUUID).detailed());
	}

	public static ResponseEntity<?> getOwnedGroup(NativeWebRequest request, String username, String groupUUID) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;

		if (!v.checkUID(groupUUID))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);

		Group g = db.group(groupUUID).detailed();
		if (g == null)
			return sendError(404, MessageEnum.GROUP_NOT_FOUND);
		if (!g.getCreator().equals(username))
			return sendError(403, MessageEnum.GROUP_NOT_OWNED);
		return responde(g);
	}

	public static  ResponseEntity<?> getOwnedGroups(NativeWebRequest request, String username) {
		ResponseEntity<?> context = authentificate(request, username);
		if (context != null)
			return context;
		ArrayList<ReducedGroup> list = db.groups().created();
		return responde(list);
	}

	private static <T> ResponseEntity<T> responde(T ent) {
		return new ResponseEntity<>(ent, HttpStatus.OK);
	}

	private static ResponseEntity<ErrorResponse> sendError(int status ,MessageEnum error) {
		return new ResponseEntity<>(new ErrorResponse().message(error), HttpStatus.resolve(status));
	}

}
