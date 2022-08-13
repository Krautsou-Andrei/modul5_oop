package by.patch.cave.service.impl.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {

	private List<Integer> randomArray;
	private int counter = 0;

	public RandomNumber() {
		
		randomArray = new ArrayList<>();
	}

	public RandomNumber(int value) {
		
		randomArray = new ArrayList<>();

		for (int i = 0; i < value; i++) {
			randomArray.add(i);
		}

		Collections.shuffle(randomArray);
	}

	public int getNumber() {

		counter++;

		return randomArray.get(counter);
	}

}
