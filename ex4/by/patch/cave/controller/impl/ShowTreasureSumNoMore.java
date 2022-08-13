package by.patch.cave.controller.impl;

import java.util.List;

import by.patch.cave.bean.Treasure;
import by.patch.cave.controller.Command;
import by.patch.cave.controller.ControllerException;
import by.patch.cave.main.Print;
import by.patch.cave.service.CaveService;
import by.patch.cave.service.ServiceException;
import by.patch.cave.service.ServiceProvider;

public class ShowTreasureSumNoMore implements Command {

	public ShowTreasureSumNoMore() {

	}

	@Override
	public String execute(String request) throws ControllerException {

		ServiceProvider provider = ServiceProvider.getInstance();
		CaveService service = provider.getCaveService();

		List<Treasure> listTreasure;
		Print print = new Print();
		String sum;
		

		sum = request.split("SUM=", 2)[1];
		

		// ShowTreasureSumNoMore SUM=1000.00

		try { // Выводим список всех сокровищ
			listTreasure = service.showTreasureSumNoMore(sum);
			print.treasure(listTreasure);
			return "OK";
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}

}
