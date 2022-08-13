package by.patch.cave.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import by.patch.cave.bean.Treasure;
import by.patch.cave.bean.criteria.Criteria;
import by.patch.cave.dao.CaveDAO;
import by.patch.cave.dao.DAOException;
import by.patch.cave.dao.DAOProvider;
import by.patch.cave.service.CaveService;
import by.patch.cave.service.ServiceException;
import by.patch.cave.service.impl.util.RandomNumber;
import by.patch.cave.service.validator.Validator;
import by.patch.cave.service.validator.ValidatorValueDouble;

public class CaveServiceImpl implements CaveService {

	DAOProvider provider = DAOProvider.getInstance();
	CaveDAO caveDAO = provider.getCaveDAO();

	public CaveServiceImpl() {

	}

	@Override
	public List<Treasure> find(Criteria criteria) throws ServiceException {
		if (!Validator.criteriaValidator(criteria)) {
			throw new ServiceException("Criteria not");
		}

		try {
			List<Treasure> listTreasure = caveDAO.find(criteria);
			return listTreasure;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Treasure> showAll() throws ServiceException {

		try {
			List<Treasure> listTreasure = caveDAO.showAll();
			return listTreasure;
		} catch (DAOException e) {
			throw new ServiceException(e);
		}

	}

	@Override
	public List<Treasure> showMax() throws ServiceException {

		List<Treasure> listTreasure;
		List<Treasure> result;
		Treasure treasureMax;

		listTreasure = showAll();
		result = new ArrayList<>();
		listTreasure.sort(Comparator.comparing(Treasure::getPrice).reversed());

		treasureMax = listTreasure.get(0);

		listTreasure.forEach(treasure -> {
			if (treasure.getPrice() >= treasureMax.getPrice()) {
				result.add(treasure);

			}
		});

		return result;

	}

	@Override
	public List<Treasure> showTreasureSumNoMore(String sum) throws ServiceException {
		
		if (!ValidatorValueDouble.doubleValidator(sum)) {
			throw new ServiceException("Criteria not");
		}

		List<Treasure> listTreasureSelectBySum;
		List<Treasure> listTreasure;
		RandomNumber random;
		Double sumTreasure;
		Double sumValue;

		listTreasureSelectBySum = new ArrayList<>();
		listTreasure = showAll();
		random = new RandomNumber(listTreasure.size());
		sumValue = Double.parseDouble(sum);

		do {

			sumTreasure = 0d;

			for (Treasure treasure : listTreasureSelectBySum) {
				sumTreasure += treasure.getPrice();
			}

			if (sumValue < sumTreasure) {
				listTreasureSelectBySum.remove(listTreasureSelectBySum.size() - 1);
				break;
			}

			listTreasureSelectBySum.add(listTreasure.get(random.getNumber()));

		} while (sumValue >= sumTreasure);

		return listTreasureSelectBySum;
	}

}
