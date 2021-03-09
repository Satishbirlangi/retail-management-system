
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

/**
 * 
 * @author ChennareddipalliGaya
 *
 */

@RestController
@RequestMapping("/alogin")
public class AdminLoginRestAPI {

	@Autowired(required = true)
	AdminLoginService adminloginservice;

	/**
	 * This method will be validate the logged in user, If valid user then return
	 * ResponseType, If invalid then return error page
	 * 
	 * @param requst
	 * @param resposne
	 * @return ResponseType
	 */
	@RequestMapping(value = "/validate-admin", method = RequestMethod.POST)
	public @ResponseBody ResponseType validateAdmin(@RequestBody AdminData adminData, HttpServletRequest request) {

		ResponseType respType = new ResponseType();
		// String userName = request.getParameter("userName");
		// String pwd = request.getParameter("pwd");
		System.out.println("UserName:::" + adminData.getUsername() + " ::Password::" + adminData.getPassword());
		try {
			boolean status = adminloginservice.validateAdmin(adminData);
			System.out.println("Status::" + status);
			if (status) {
				respType.setStatus("success");
				respType.setErrcode(200);
				respType.setMessage("Valid Admin");
				request.getSession().setAttribute("isAuthenticated", true);
			} else {
				respType.setStatus("failure");
				respType.setErrcode(404);
				respType.setMessage("InValid Admin");
				request.getSession().setAttribute("isAuthenticated", false);
			}
		} catch (Exception e) {
			respType.setStatus("failure");
			respType.setErrcode(500);
			respType.setMessage(e.getMessage());
			request.getSession().setAttribute("isAuthenticated", false);
		}
		return respType;
	}

}
