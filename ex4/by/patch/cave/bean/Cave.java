package by.patch.cave.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Cave implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Treasure> listTreasure;

	public Cave() {

	}

	public Cave(List<Treasure> listTreasure) {
		this.listTreasure = listTreasure;
	}

	public List<Treasure> getListTreasure() {
		return listTreasure;
	}

	public void setListTreasure(List<Treasure> listTreasure) {
		this.listTreasure = listTreasure;
	}

	@Override
	public int hashCode() {
		return Objects.hash(listTreasure);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Cave other = (Cave) obj;
		return Objects.equals(listTreasure, other.listTreasure);
	}

	@Override
	public String toString() {
		return "Cave [listTreasure=" + listTreasure + "]";
	}

}
