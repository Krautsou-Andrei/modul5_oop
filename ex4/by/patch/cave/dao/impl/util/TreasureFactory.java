package by.patch.cave.dao.impl.util;

import by.patch.cave.bean.Treasure;
import by.patch.cave.dao.impl.util.impl.CreatBracelet;
import by.patch.cave.dao.impl.util.impl.CreatRing;

public class TreasureFactory {
	
	public TreasureFactory() {
		
	}

	public Treasure creatTreasure(String data) {

		TreasureData treasureData = new TreasureData(data);
		String treasureType = treasureData.treasureType();
		String[] treasureParam = treasureData.trasureParam();

		Treasure treasure = null;

		switch (treasureType) {

		case "Ring":
			CreatTreasure ring = new CreatRing();
			treasure = ring.creat(treasureParam);
			break;

		case "Bracelet":
			CreatTreasure bracelet = new CreatBracelet();
			treasure = bracelet.creat(treasureParam);
			break;
		}
		return treasure;
	}

}
