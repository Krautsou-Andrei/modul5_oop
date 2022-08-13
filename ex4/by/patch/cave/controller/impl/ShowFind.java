package by.patch.cave.controller.impl;

import java.util.List;

import by.patch.cave.bean.Treasure;
import by.patch.cave.bean.criteria.Criteria;
import by.patch.cave.controller.Command;
import by.patch.cave.main.Print;
import by.patch.cave.service.CaveService;
import by.patch.cave.service.ServiceException;
import by.patch.cave.service.ServiceProvider;

public class ShowFind implements Command {

	public ShowFind() {

	}

	@Override
	public String execute(String request) {
		List<Treasure> listTreasure;
		Print print = new Print();

		ServiceProvider provider = ServiceProvider.getInstance();
		CaveService service = provider.getCaveService();

		// Find Ring TITLE=gold PRICE=100

		String[] temp = request.split(" ");

		String criteriaName = temp[1];
		Criteria criteriaTreasure = new Criteria(criteriaName);

		String param = request.split(criteriaName + " ", 2)[1];
		String[] criteriaParam = param.split(" ");

		for (String index : criteriaParam) {

			String key = index.split("=", 2)[0];

			String value = index.split("=", 2)[1];

			criteriaTreasure.add(key, value);

		}

		try {// Поиск по критерию
			listTreasure = service.find(criteriaTreasure);
			print.treasure(listTreasure);
			return "Ok";
		} catch (ServiceException e) {
			e.printStackTrace();
		}

		return "False";
	}

}
