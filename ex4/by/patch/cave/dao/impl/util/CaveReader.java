package by.patch.cave.dao.impl.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.patch.cave.dao.DAOException;

public class CaveReader {

	private String CAVE;

	public CaveReader() {

	}

	public CaveReader(String CAVE) {
		this.CAVE = CAVE;
	}

	public List<String> read() throws DAOException {

		List<String> treasureData = new ArrayList<>();

		try (FileReader file = new FileReader(CAVE)) {

			BufferedReader buffer = new BufferedReader(file);

			String line;

			while ((line = buffer.readLine()) != null) {
				if (line.isEmpty()) {
					continue;
				}

				treasureData.add(line);

			}

		} catch (FileNotFoundException e) {
			throw new DAOException(e);
		} catch (IOException e1) {
			throw new DAOException(e1);
		}

		return treasureData;
	}

	public List<String> read(String criteriaType) throws DAOException {

		List<String> treasureCriteria = new ArrayList<>();

		List<String> treasureData = read();

		for (String treasure : treasureData) {

			TreasureData data = new TreasureData(treasure);

			String treasureType = data.treasureType();

			if (criteriaType.equals(treasureType)) {
				treasureCriteria.add(treasure);
			}
		}

		return treasureCriteria;
	}
}
