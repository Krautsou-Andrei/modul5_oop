package by.patch.cave.service.validator.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.patch.cave.bean.criteria.SearchCriteria.Bracelet;
import by.patch.cave.bean.criteria.SearchCriteria.Ring;

public class ValidatorKey {

	private List<String> listRing = titleEnumInString(Ring.values());
	private List<String> listBracelet = titleEnumInString(Bracelet.values());
	private Set<String> keyValidator = new HashSet<>();

	public ValidatorKey() {

	}

	public boolean validator(Set<String> listKey) {

		keyValidator.addAll(listBracelet); // Создаем список для проверки ключей и исключаем повторения значений
		keyValidator.addAll(listRing);

		for (String key : listKey) {

			boolean temp = false;

			for (String validator : keyValidator) {// Проверяем, что данные ключи можно использовать в запросе
				if (key.equals(validator)) {
					temp = true;
					continue;
				}

			}

			if (!temp) {
				return false;// возвращаем если из списка проверяемых ключей нашли хотя бы одно несовпадение
			}

		}

		return true;// если цикл не прервался
	}

	private <T> List<String> titleEnumInString(T[] array) { // значения Enum переводим в String и записываем в массив

		List<String> list = new ArrayList<>();

		for (T value : array) {
			list.add(value.toString());
		}

		return list;
	}

}
