/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.mustaphin.project.command;

/**
 *
 * @author me
 */
public enum ActionEnum {

    LOGIN {
	{
	    this.setCommand(new CommandLogin());
	}

    },
    STUB {
	{
	    this.setCommand(new CommandStub());
	}

    },
    LOGOUT {
	{
	    this.setCommand(new CommandLogout());
	}
    };

    public ICommand getCommand() {
	return command;
    }

    private ICommand command;

    void setCommand(ICommand command) {
	this.command = command;
    }

}
