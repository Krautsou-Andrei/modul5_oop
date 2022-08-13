package by.patch.cave.bean.impl;

import java.io.Serializable;
import java.util.Objects;

import by.patch.cave.bean.Treasure;

public class Bracelet implements Treasure, Serializable {

	private static final long serialVersionUID = 1L;

	public String title;
	public double price;
	public double weigth;
	public double length;

	public Bracelet() {

	}

	public Bracelet(String title, double price, double weigth, double length) {
		this.title = title;
		this.price = price;
		this.weigth = weigth;
		this.length = length;
	}

	@Override
	public String getTitle() {
		return title;

	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
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
		return Objects.hash(length, price, title, weigth);
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
		Bracelet other = (Bracelet) obj;
		return Double.doubleToLongBits(length) == Double.doubleToLongBits(other.length)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(title, other.title)
				&& Double.doubleToLongBits(weigth) == Double.doubleToLongBits(other.weigth);
	}

	@Override
	public String toString() {
		return "Bracelet [title=" + title + ", price=" + price + ", weigth=" + weigth + ", length=" + length + "]";
	}

}
