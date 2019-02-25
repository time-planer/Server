package com.niton.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.niton.model.RegistrationRequest;

@Validated
@RequestMapping("${openapi.Time Planer Server.base-path:/time-planer/test}")
@Controller
public class TestController {
	@RequestMapping(consumes = "application/json", method =RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public RegistrationRequest saveContent(
			@Valid 
			@RequestBody 
			@NotNull
			RegistrationRequest request) {
		System.out.println(request);
		return request;
	}
}
