package by.patch.cave.controller.impl;

import by.patch.cave.controller.Command;
import by.patch.cave.controller.CommandProvider;
import by.patch.cave.controller.Controller;
import by.patch.cave.controller.ControllerException;

public class ControllerImpl implements Controller {

	CommandProvider commandProvider = CommandProvider.getInstance();

	@Override
	public String show(String request) throws ControllerException {

		String commandName = request.split(" ")[0];

		Command command = commandProvider.getCommand(commandName);

		String response;

		response = command.execute(request);

		return response;
	}

}
