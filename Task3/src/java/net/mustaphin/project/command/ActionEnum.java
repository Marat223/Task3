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

    LOGIN(new CommandLogin()),
    STUB(new CommandStub()),
    LOGOUT(new CommandLogout());

    ActionEnum(ICommand iCommand) {
	this.command = iCommand;
    }

    public ICommand getCommand() {
	return command;
    }

    private ICommand command;

}
