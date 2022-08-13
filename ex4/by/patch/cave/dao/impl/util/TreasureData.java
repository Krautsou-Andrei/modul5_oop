package by.patch.cave.dao.impl.util;

public class TreasureData {

	private String data;

	public TreasureData() {

	}

	public TreasureData(String data) {
		this.data = data;
	}

	private String[] treasureData() {
		String delimType = " : ";
		String[] treasureData = data.split(delimType, 2);
		return treasureData;
	}

	public String treasureType() {

		String[] treasureData = treasureData();
		String treasureTupe = treasureData[0];

		return treasureTupe;
	}

	public String[] trasureParam() {

		String[] treasureData = treasureData();
		String delimParam = ", ";
		String[] treasureParam = treasureData[1].split(delimParam);

		return treasureParam;
	}
}
