package by.patch.cave.service.validator;

import java.util.Map;
import java.util.Set;

import by.patch.cave.bean.criteria.Criteria;
import by.patch.cave.service.validator.util.ValidatorKey;
import by.patch.cave.service.validator.util.ValidatorKeyValue;

public class Validator {

	public static boolean criteriaValidator(Criteria criteria) {

		Map<String, String> temp = criteria.getCriteria();
		Set<String> listKey = temp.keySet();

		ValidatorKey validatorKey = new ValidatorKey();
		ValidatorKeyValue validatorKeyValue = new ValidatorKeyValue();

		if (!validatorKey.validator(listKey)) {// Проверяем, что ключи подходят для запроса
			return false;
		}

		for (Map.Entry<String, String> entry : temp.entrySet()) {

			String key = entry.getKey();
			String value = entry.getValue();

			if (!validatorKeyValue.validator(key, value)) {// Проверяем, что значение соответствует заданному ключу
				return false;
			}

		}

		return true;

	}
	
	
}
