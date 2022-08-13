package by.patch.cave.dao;

import java.util.List;

import by.patch.cave.bean.Treasure;
import by.patch.cave.bean.criteria.Criteria;

public interface CaveDAO {

	List<Treasure> showAll() throws DAOException;

	List<Treasure> find(Criteria criteria) throws DAOException;
}
