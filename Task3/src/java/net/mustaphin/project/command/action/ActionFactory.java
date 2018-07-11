/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mustaphin.project.command.action;

import net.mustaphin.project.command.ActionEnum;
import net.mustaphin.project.command.ICommand;
import net.mustaphin.project.constant.Attribute;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public class ActionFactory {

    public ICommand defineCommand(HttpServletRequest req) {
	String action = req.getParameter(Attribute.ATTRIBUTE_COMMAND);
	try {
	    return ActionEnum.valueOf(action.toUpperCase()).getCommand();
	} catch (IllegalArgumentException e) {
	    req.getSession().setAttribute(Attribute.ATTRIBUTE_WRONG_ACTION, action);
	    //TODO добавить логгер
	    return ActionEnum.STUB.getCommand();
	}
    }

    public ICommand defineCommand(SessionRequestContent atribute) {
	String action = (String) atribute.getRequestAttributes().get(Attribute.ATTRIBUTE_COMMAND);
	if (null != action) {
	    return ActionEnum.valueOf(action.toUpperCase()).getCommand();
	}
	//TODO добавить логгер
	return ActionEnum.STUB.getCommand();
    }
}
