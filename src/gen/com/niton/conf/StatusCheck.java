package com.niton.conf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatusCheck {
	@RequestMapping(produces="text/html",path="/staus")
	public String check() {
		return "<h1>Working</h1>";
	}

}
