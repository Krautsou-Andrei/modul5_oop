package by.patch.cave.controller;

public interface Command {
	
	String execute(String request) throws ControllerException;

}
