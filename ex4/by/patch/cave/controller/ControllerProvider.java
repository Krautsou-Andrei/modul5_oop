package by.patch.cave.controller;

import by.patch.cave.controller.impl.ControllerImpl;

public class ControllerProvider {

	private static final ControllerProvider intance = new ControllerProvider();

	private final Controller controller = new ControllerImpl();

	private ControllerProvider() {

	}

	public Controller getController() {
		return controller;
	}

	public static ControllerProvider getInstance() {
		return intance;
	}

}
