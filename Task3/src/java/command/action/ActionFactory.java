/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.action;

import command.ICommand;
import constant.Attribute;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public class ActionFactory {

    public ICommand defineCommand(HttpServletRequest req) {
	String action = req.getParameter(Attribute.ATTRIBUTE_NAME_COMMAND);
	try {
	    return ActionEnum.valueOf(action.toUpperCase()).command;
	} catch (IllegalArgumentException e) {
	    req.getSession().setAttribute(Attribute.ATTRIBUTE_NAME_WRONG_ACTION, action + ": error has occurred");
	    //TODO добавить логгер
	    return ActionEnum.ERROR.command;
	}
    }

    public ICommand defineCommand(SessionRequestContent atribute) {
	String action = (String) atribute.getRequestAttributes().get(Attribute.ATTRIBUTE_NAME_COMMAND);
	if (null != action) {
	    return ActionEnum.valueOf(action.toUpperCase()).command;
	}
	//TODO добавить логгер
	return ActionEnum.ERROR.command;
    }
}
