package by.patch.cave.bean.criteria;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Criteria implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String searchName;
	private Map<String, String> criteria = new HashMap<String, String>();

	public Criteria(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Map<String, String> getCriteria() {
		return criteria;
	}

	public void setCriteria(Map<String, String> criteria) {
		this.criteria = criteria;
	}
	
	public void add(String searchName, String value) {
		criteria.put(searchName, value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(criteria, searchName);
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
		Criteria other = (Criteria) obj;
		return Objects.equals(criteria, other.criteria) && Objects.equals(searchName, other.searchName);
	}

	@Override
	public String toString() {
		return "Criteria [searchName=" + searchName + ", criteria=" + criteria + "]";
	}

}
