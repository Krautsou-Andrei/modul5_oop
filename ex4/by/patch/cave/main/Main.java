package by.patch.cave.main;

public class Main {

	public static void main(String[] args) {

		int itemMenu;

		Print print = new Print();
		Menu menu = new Menu();

		do {
			print.menu();

			itemMenu = print.enter("Select item menu");

			menu.menu(itemMenu);

		} while (itemMenu > 0 && itemMenu < 5);

	}

}
