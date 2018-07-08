/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.action;

import command.ICommand;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public class ActionFactory {

    ICommand getCommand(HttpServletRequest req) {
	String commandName = req.getParameter("command").toUpperCase();
	try {
	    return Action.valueOf(commandName).command;
	} catch (IllegalArgumentException e) {
	    //TODO добавить логгер
	    return Action.ERROR.command;
	}
    }
}
