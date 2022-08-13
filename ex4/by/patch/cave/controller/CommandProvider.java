package by.patch.cave.controller;

import java.util.HashMap;
import java.util.Map;

import by.patch.cave.controller.impl.*;

public class CommandProvider {

	private static final CommandProvider instance = new CommandProvider();

	private Map<String, Command> mapCommand;

	private CommandProvider() {

		mapCommand = new HashMap<String, Command>();

		mapCommand.put("ShowAll", new ShowAll());
		mapCommand.put("ShowMax", new ShowMax());
		mapCommand.put("ShowFind", new ShowFind());
		mapCommand.put("ShowTreasureSumNoMore", new ShowTreasureSumNoMore());
	}

	public Command getCommand(String commandName) {

		Command command;

		command = mapCommand.get(commandName);

		return command;
	}

	public static CommandProvider getInstance() {
		return instance;
	}

}
