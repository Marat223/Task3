/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import constant.PagePath;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public class CommandLogout implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
	request.getSession().invalidate();
	return PagePath.PATH_LOGIN;
    }

}
