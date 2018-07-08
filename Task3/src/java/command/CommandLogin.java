/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import constant.AdmissibleRequest;
import constant.Attribute;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public class CommandLogin implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
	String page = null;
	String login = request.getParameter(AdmissibleRequest.PARAM_NAME_LOGIN);
	String pass = request.getParameter(AdmissibleRequest.PARAM_NAME_PASSWORD);
	if (LoginLogic.checkLogin(login, pass)) {
	    request.setAttribute(Attribute.ATTRIBUTE_NAME_USER, login);
	    page = "/jsp/main.jspx";
	} else {
	    request.setAttribute(Attribute.ATTRIBUTE_NAME_INCORRECT_AUTHORIZATION, "Login or passwod is incorrect");
	    page = "/jsp/login.jspx";
	}
	return page;
    }

}
