package by.patch.cave.main;

import by.patch.cave.controller.Controller;
import by.patch.cave.controller.ControllerException;
import by.patch.cave.controller.ControllerProvider;

public class Menu {

	ControllerProvider provider = ControllerProvider.getInstance();
	Controller controller = provider.getController();

	public Menu() {

	}

//От Switch можно избавиться, для более удобного расширения кода в дальнейшем, но по условию консольное меню должно 
//	быть минимальным и дальнейшее его расширение не планируется. Меню нужно только для демонстрации работы кода,
//	поэтому ввод критерий с клавиатуры или иным способом не реализован 
	
	public void menu(int itemMenu) {

		switch (itemMenu) {
		case 1 -> {
			try {
				String response = controller.show("ShowAll");
				System.out.println(response);

			} catch (ControllerException e) {
				e.printStackTrace();
			}
		}
		case 2 -> {
			try {
				String response = controller.show("ShowMax");
				System.out.println(response);
			} catch (ControllerException e) {
				e.printStackTrace();
			}
		}
		case 3 -> {
			try

			{
				String response = controller.show("ShowTreasureSumNoMore SUM=1000.0");
				System.out.println(response);
			} catch (ControllerException e) {
				e.printStackTrace();
			}

		}

		case 4 -> {
			try {
				String response = controller.show("ShowFind Ring TITLE=gold PRICE=100.0");
				System.out.println(response);
			} catch (ControllerException e) {
				e.printStackTrace();
			}
		}
		case 5 -> System.out.println("End programm");

		}
	}
}
