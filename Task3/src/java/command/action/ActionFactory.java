/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.action;

import command.ICommand;
import constant.Message;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public class ActionFactory {

    public ICommand defineCommand(HttpServletRequest req) {
	String action = req.getParameter("command");
	try {
	    return ActionEnum.valueOf(action.toUpperCase()).command;
	} catch (IllegalArgumentException e) {
	    req.getSession().setAttribute("wrongActionMessage", action + Message.WRONG_ACTION);
	    //TODO добавить логгер
	    return ActionEnum.ERROR.command;
	}
    }

    public ICommand defineCommand(SessionRequestContent atribute) {
	String action = (String) atribute.getRequestAttributes().get("command");
	if (null != action) {
	    return ActionEnum.valueOf(action.toUpperCase()).command;
	}
	//TODO добавить логгер
	return ActionEnum.ERROR.command;
    }
}
