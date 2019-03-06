package com.niton.api;

import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import com.niton.api.old.Authentication;
import com.niton.model.RegistrationRequest;

@Controller
@RequestMapping("${openapi.Time Planer Server.base-path:/time-planer}")
public class AuthenticationApiController implements AuthenticationApi {

	private final NativeWebRequest request;

	@org.springframework.beans.factory.annotation.Autowired
	public AuthenticationApiController(NativeWebRequest request) {
		this.request = request;
	}

	@Override
	public Optional<NativeWebRequest> getRequest() {
		return Optional.ofNullable(request);
	}

	@Override
	public ResponseEntity<?> login(@NotNull @Valid @RequestParam(value = "email", required = true) String email,
			@NotNull @Valid @RequestParam(value = "password", required = true) String password) {
		return Authentication.login(email, password);
	}

	@Override
	public ResponseEntity<?> registrate(@RequestBody @Valid @NotNull RegistrationRequest registrationRequest) {
		return Authentication.registrate(registrationRequest);
//		return new ResponseEntity<>(
//				new SuccessResponse().message(com.niton.model.SuccessResponse.MessageEnum.REGISTRATION_WORKED),
//				HttpStatus.OK);

	}
}
