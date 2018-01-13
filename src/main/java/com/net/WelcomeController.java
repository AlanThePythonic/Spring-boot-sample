
package com.net;

import java.util.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.service.DbService;
import com.service.OtherService;

@Controller
public class WelcomeController {

	@Value("${application.message}")
	private String message;

	@Autowired
	private DbService service;

	@Autowired
	private OtherService otherService;

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(Map<String, Object> model, @RequestParam("id") String id, @RequestParam("name") String name) {
		model.put("result", otherService.updateEmployeeNameById(id, name));				
		return "result";
	}

	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}

}
