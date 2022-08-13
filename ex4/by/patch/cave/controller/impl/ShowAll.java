package by.patch.cave.controller.impl;

import java.util.List;

import by.patch.cave.bean.Treasure;
import by.patch.cave.controller.Command;
import by.patch.cave.controller.ControllerException;
import by.patch.cave.main.Print;
import by.patch.cave.service.CaveService;
import by.patch.cave.service.ServiceException;
import by.patch.cave.service.ServiceProvider;

public class ShowAll implements Command {

	public ShowAll() {

	}

	@Override
	public String execute(String request) throws ControllerException {

		List<Treasure> listTreasure;
		Print print = new Print();

		ServiceProvider provider = ServiceProvider.getInstance();
		CaveService service = provider.getCaveService();
		
		try { // Выводим список всех сокровищ
			listTreasure = service.showAll();
			print.treasure(listTreasure);
			return "OK";
		} catch (ServiceException e) {
			throw new ControllerException(e);
		}
	}
}
