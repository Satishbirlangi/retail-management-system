package com.myapp.spring.rest.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.AdminData;
import com.myapp.spring.responseType.ResponseType;
import com.myapp.spring.service.AdminLoginService;

@RestController
@RequestMapping("/retail_store")
public class AdminLoginRestAPI {
	@Autowired
	AdminLoginService adminloginservice;

	@RequestMapping(value = "/validate-admin", method = RequestMethod.POST)
	public @ResponseBody ResponseType validateLogin(@RequestBody AdminData adminData, HttpServletRequest request) {

		ResponseType respType = new ResponseType();

		System.out.println("UserName:::" + adminData.getUsername() + " ::Password::" + adminData.getPassword());

		boolean status = adminloginservice.validateAdmin(adminData);
		System.out.println("Status::" + status);
		if (status) {
			respType.setStatus("success");
			respType.setErrcode(200);
			respType.setMessage("Valid Admin");
			request.getSession().setAttribute("isAuthenticated", true);
			return respType;
		} else {
			respType.setStatus("failure");
			respType.setErrcode(404);
			respType.setMessage("InValid Admin");
			request.getSession().setAttribute("isAuthenticated", false);

			return respType;
		}
	}
}
