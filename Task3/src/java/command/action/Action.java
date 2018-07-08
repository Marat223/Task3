/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command.action;

import command.CommandError;
import command.CommandLogin;
import command.ICommand;

/**
 *
 * @author me
 */
public enum Action {

    LOGIN {
	{
	    this.command = new CommandLogin();
	}

    },
    ERROR {
	{
	    this.command = new CommandError();
	}
    };

    ICommand command;

}
