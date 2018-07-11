/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mustaphin.project.command;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author me
 */
public interface ICommand {

    String execute(HttpServletRequest request);
}
