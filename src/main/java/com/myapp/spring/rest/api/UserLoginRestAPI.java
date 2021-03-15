package com.myapp.spring.rest.api;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.spring.model.UserData;
import com.myapp.spring.responseType.ResponseType;
import com.myapp.spring.service.UserLoginService;

/**
 * 
 * @author ChennareddipalliGaya
 *
 */

@RestController
@RequestMapping("/retail_store")
public class UserLoginRestAPI {

	@Autowired
	UserLoginService userloginservice;

	/**
	 * This method will be validate the logged in user, If valid user then return
	 * ResponseType, If invalid then return error page
	 * 
	 * @param requst
	 * @param resposne
	 * @return ResponseType
	 */
	@RequestMapping(value = "/validate-user", method = RequestMethod.POST)
	public @ResponseBody ResponseType validateLogin(@RequestBody UserData userData, HttpServletRequest request) {
		String run;
		ResponseType respType = new ResponseType();
		// String userName = request.getParameter("userName");
		// String pwd = request.getParameter("pwd");
		run = userData.getUsername();
		System.out.println("UserName:::" + userData.getUsername() + " ::Password::" + userData.getPassword());
		boolean status = userloginservice.validateLogin(userData);
		System.out.println("Status::" + status);
		if (status) {

			respType.setStatus("success");
			respType.setErrcode(200);
			respType.setMessage("Valid User");
			request.getSession().setAttribute("registeredusername", run);
			request.getSession().setAttribute("isAuthenticated", true);
			return respType;
		} else {
			respType.setStatus("failure");
			respType.setErrcode(404);
			respType.setMessage("InValid User");
			request.getSession().setAttribute("isAuthenticated", false);
			return respType;
		}

	}
}