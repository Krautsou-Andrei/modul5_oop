package by.patch.cave.main;

import java.util.List;
import java.util.Scanner;

import by.patch.cave.bean.Treasure;

public class Print {

	public void treasure(List<Treasure> listTreasure) {

		listTreasure.forEach(treasure -> System.out.println(treasure));
		System.out.println("---------------");

	}

	public void menu() {

		System.out.println("\n" + "Item menu" +"\n" + "1 - All treasure" + "\n" + "2 - Treasures with the maximum price"
				+ "\n" + "3 - Pick up treasures worth no more than" + "\n" + "4 - Find treasure" + "\n" + "5 - Exit");
	}

	public int enter(String str) {
		int n;

		do {
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			System.out.println(str);

			while (!sc.hasNextInt()) {
				System.out.println(str);
				sc.next();
			}
			n = sc.nextInt();
		} while (n < 1 || n > 5);

		return n;
	}
}
