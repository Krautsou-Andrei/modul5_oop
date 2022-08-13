package by.patch.cave.service.validator.util;

import by.patch.cave.service.validator.ValidatorValueDouble;

public class ValidatorKeyValue {
	// Проверяем можно ли в данный ключ передать данное значение
	private ValidatorKeyValueString[] validatorValueString = ValidatorKeyValueString.values();
	private ValidatorKeyValueDouble[] validatorValueDouble = ValidatorKeyValueDouble.values();

	public ValidatorKeyValue() {

	}

	public boolean validator(String key, String value) {

		for (ValidatorKeyValueString searchKey : validatorValueString) {

			if (key.equals(searchKey.toString())) {

				if (value.matches("[a-zA-Z]*")) {
					return true;
				}
			}

		}

		for (ValidatorKeyValueDouble searchKey : validatorValueDouble) {

			if (key.equals(searchKey.toString())) {
				return ValidatorValueDouble.doubleValidator(value);
			}

		}

		return false;

	}

}
