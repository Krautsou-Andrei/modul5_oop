package by.patch.cave.dao.impl.util.impl;

import java.util.ArrayList;
import java.util.List;

import by.patch.cave.bean.Treasure;
import by.patch.cave.bean.impl.Ring;
import by.patch.cave.dao.impl.util.CreatTreasure;

public class CreatRing implements CreatTreasure {

	private String title;
	private double price;
	private double weight;
	private List<String> value = new ArrayList<>();

	public CreatRing() {

	}

	public Treasure creat(String[] param) {

		for (String temp : param) {
			String[] tempValue = temp.split("=");
			value.add(tempValue[1]);
		}

		title = value.get(0);
		price = Double.parseDouble(value.get(1));
		weight = Double.parseDouble(value.get(2));

		Ring ring = new Ring(title, price, weight);
		return ring;
	}
}
