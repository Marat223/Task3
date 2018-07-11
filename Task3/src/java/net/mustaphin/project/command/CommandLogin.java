/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mustaphin.project.command;

import net.mustaphin.project.constant.AdmissibleRequest;
import net.mustaphin.project.constant.Attribute;
import net.mustaphin.project.constant.PagePath;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public class CommandLogin implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
	String page = null;
	String login = request.getParameter(AdmissibleRequest.PARAM_LOGIN);
	String pass = request.getParameter(AdmissibleRequest.PARAM_PASSWORD);
	if (LoginLogic.checkLogin(login, pass)) {
	    request.setAttribute(Attribute.ATTRIBUTE_USER, login);
	    page = PagePath.PATH_MAIN;
	} else {
	    request.setAttribute(Attribute.ATTRIBUTE_INCORRECT_AUTHORIZATION, "Login or passwod is incorrect");
	    page = PagePath.PATH_LOGIN;
	}
	return page;
    }

}
