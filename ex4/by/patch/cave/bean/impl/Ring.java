package by.patch.cave.bean.impl;

import java.io.Serializable;
import java.util.Objects;

import by.patch.cave.bean.Treasure;

public class Ring implements Treasure, Serializable {

	private static final long serialVersionUID = 1L;

	public String title;
	public double price;
	public double weigth;

	public Ring() {

	}

	public Ring(String title, double price, double weigth) {
		this.title = title;
		this.price = price;
		this.weigth = weigth;
	}

	@Override
	public String getTitle() {
		return title;

	}

	@Override
	public void setTitle(String title) {
		this.title = title;

	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;

	}

	@Override
	public double getWeigth() {
		return weigth;
	}

	@Override
	public void setWeigth(double weigth) {
		this.weigth = weigth;
	}

	@Override
	public int hashCode() {
		return Objects.hash(price, title, weigth);
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
		Ring other = (Ring) obj;
		return Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(title, other.title)
				&& Double.doubleToLongBits(weigth) == Double.doubleToLongBits(other.weigth);
	}

	@Override
	public String toString() {
		return "Ring [title=" + title + ", price=" + price + ", weigth=" + weigth + "]";
	}

}
