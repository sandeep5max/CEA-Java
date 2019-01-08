package com.CloudServices.CEAJava;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class servicesRoutes {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String root() {
		return "index";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		return "listDirectory";
	}
	
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download() {
		return "downloadFile";
	}
}
