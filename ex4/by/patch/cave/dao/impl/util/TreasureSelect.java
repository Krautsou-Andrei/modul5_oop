package by.patch.cave.dao.impl.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import by.patch.cave.bean.criteria.Criteria;

public class TreasureSelect {

	private Criteria criteria;

	public TreasureSelect() {

	}

	public TreasureSelect(Criteria criteria) {
		this.criteria = criteria;
	}

	public List<String> parser(List<String> treasureData) {

		List<String> result = new ArrayList<>();

		List<String> regExprFromCriteria = regExprFromCriteria();

		for (String data : treasureData) {
			if (isMatch(data, regExprFromCriteria)) {
				result.add(data);
			}
		}

		return result;

	}

	private List<String> regExprFromCriteria() {

		List<String> regExprFromCriteria = new ArrayList<>();

		Map<String, String> mapCriteria = criteria.getCriteria();

		Set<String> setKey = mapCriteria.keySet();

		setKey.forEach(key -> {
			String value = mapCriteria.get(key);
			String regExpr = key + "=" + value;
			regExprFromCriteria.add(regExpr);

		});

		return regExprFromCriteria;
	}

	private boolean isMatch(String data, List<String> regExprFromCriteria) {

		for (String regExpr : regExprFromCriteria) {
			Pattern pattern = Pattern.compile(regExpr);
			Matcher matcher = pattern.matcher(data);

			if (!matcher.find()) {
				return false;
			}
		}

		return true;

	}
}
