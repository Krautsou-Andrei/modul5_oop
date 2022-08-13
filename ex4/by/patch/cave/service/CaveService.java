package by.patch.cave.service;

import java.util.List;

import by.patch.cave.bean.Treasure;
import by.patch.cave.bean.criteria.Criteria;

public interface CaveService {
	
	List<Treasure> find(Criteria criteria) throws ServiceException;
	
	List<Treasure> showAll() throws ServiceException;
	
	List<Treasure> showMax() throws ServiceException;
	
	List<Treasure> showTreasureSumNoMore(String sum) throws ServiceException;

}
