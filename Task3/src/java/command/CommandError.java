/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public class CommandError implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
	return "/jsp/error.jspx";
    }

}
