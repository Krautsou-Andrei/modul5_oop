package by.patch.cave.dao;

import by.patch.cave.dao.impl.CaveDAOImpl;

public final class DAOProvider {
	private static final DAOProvider instance = new DAOProvider();
	
	private final CaveDAO caveDAO = new CaveDAOImpl();
	
	private DAOProvider() {
		
	}
	
	public CaveDAO getCaveDAO() {
		return caveDAO;
	}
	
	public static DAOProvider getInstance() {
		return instance;
	}

}
