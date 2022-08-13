package by.patch.cave.service;

import by.patch.cave.service.impl.CaveServiceImpl;

public final class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();

	private final CaveService caveService = new CaveServiceImpl();

	private ServiceProvider() {

	}
	
	public CaveService getCaveService () {
		return caveService;
	}
	
	public static ServiceProvider getInstance() {
		return instance;
	}

}
