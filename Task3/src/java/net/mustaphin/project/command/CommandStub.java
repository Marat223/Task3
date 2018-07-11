/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mustaphin.project.command;

import net.mustaphin.project.constant.PagePath;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public class CommandStub implements ICommand {

    @Override
    public String execute(HttpServletRequest request) {
	return PagePath.PATH_ERROR;
    }

}
