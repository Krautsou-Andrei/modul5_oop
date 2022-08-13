package by.patch.cave.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.patch.cave.bean.Treasure;
import by.patch.cave.bean.criteria.Criteria;
import by.patch.cave.dao.CaveDAO;
import by.patch.cave.dao.DAOException;
import by.patch.cave.dao.impl.util.CaveReader;
import by.patch.cave.dao.impl.util.TreasureFactory;
import by.patch.cave.dao.impl.util.TreasureSelect;

public class CaveDAOImpl implements CaveDAO {

	private static final String CAVE = "./src/resource/cave.txt";

	@Override
	public List<Treasure> find(Criteria criteria) throws DAOException {

		List<Treasure> listTreasure;
		List<String> treasureData;
		String criteriaType;
		CaveReader reader;
		TreasureSelect treasureSelect;
		TreasureFactory factory;

		listTreasure = new ArrayList<>();
		criteriaType = criteria.getSearchName();
		reader = new CaveReader(CAVE);
		treasureSelect = new TreasureSelect(criteria);
		factory = new TreasureFactory();

		if (criteriaType == null) {
			treasureData = reader.read();
		} else {
			treasureData = reader.read(criteriaType);
		}

		treasureData = treasureSelect.parser(treasureData);

		treasureData.forEach(treasure -> {
			Treasure treasureFind = factory.creatTreasure(treasure);
			listTreasure.add(treasureFind);

		});

		return listTreasure;
	}

	@Override
	public List<Treasure> showAll() throws DAOException {

		List<Treasure> listTreasure;
		CaveReader reader;
		List<String> treasureData;

		listTreasure = new ArrayList<>();

		reader = new CaveReader(CAVE);
		treasureData = reader.read();

		treasureData.forEach(treasure -> {
			TreasureFactory factory = new TreasureFactory();
			listTreasure.add(factory.creatTreasure(treasure));

		});

		return listTreasure;

	}

}
