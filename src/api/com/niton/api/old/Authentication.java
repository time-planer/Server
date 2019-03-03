package com.niton.api.old;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.niton.db.Database;
import com.niton.db.impl.Validator;
import com.niton.model.ErrorResponse;
import com.niton.model.ErrorResponse.MessageEnum;
import com.niton.model.InlineResponse200;
import com.niton.model.RegistrationRequest;
import com.niton.model.SuccessResponse;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaInflectorServerCodegen", date = "2019-01-06T10:48:32.684838100+01:00[Europe/Berlin]")
public class Authentication  {
	private static Database db = Database.getInstance();
	private static Validator v = Validator.getInstance();

	public static ResponseEntity<?> login(String email, String password) {
		db.setUser(email);
		if(password == null || password.equals(""))
			return sendError(203,MessageEnum.NO_PASSWORD);
		if(email == null || email.equals(""))
			return sendError(204, MessageEnum.NO_EMAIL_ADDRESS);
		if(!v.checkEmail(email))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if(!db.user().exists())
			return sendError(404, MessageEnum.USER_NOT_FOUND);
		if(db.user().login(password))
			return responde(new InlineResponse200().userKey(db.user().apikey()));
		else
			return sendError(401, MessageEnum.WRONG_PASSWORD);
	}

	public static ResponseEntity<?> registrate(RegistrationRequest registrationRequest) {
		if(registrationRequest == null)
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		db.setUser(registrationRequest.getEmail());
		if(registrationRequest.getEmail() == null || registrationRequest.getName() == null)
			return sendError(404, MessageEnum.NO_EMAIL_ADDRESS);
		if(registrationRequest.getPassword() == null)
			return sendError(404, MessageEnum.NO_PASSWORD);
		if(!v.checkRegistration(registrationRequest))
			return sendError(400, MessageEnum.PARAMS_NOT_MATCHING_PATTERN);
		if(db.user().exists())
			return sendError(409, MessageEnum.USER_ALLREADY_EXISTS);
		db.user().register(registrationRequest.getName(),registrationRequest.getPassword());
		return responde(new SuccessResponse().message(SuccessResponse.MessageEnum.REGISTRATION_WORKED));
	}

	private static <T> ResponseEntity<T> responde(T ent) {
		return new ResponseEntity<>(ent, HttpStatus.OK);
	}

	private static ResponseEntity<ErrorResponse> sendError(int status ,MessageEnum error) {
		return new ResponseEntity<>(new ErrorResponse().message(error), HttpStatus.resolve(status));
	}


}

