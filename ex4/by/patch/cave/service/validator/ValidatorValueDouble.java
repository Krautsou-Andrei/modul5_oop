package by.patch.cave.service.validator;

public class ValidatorValueDouble {
	
	public static boolean doubleValidator(String value) {
		
		if ( value.matches("\\d*+ ?\\.+\\d*")) {

			Double temp = Double.parseDouble(((String) value));

			if (temp >= 0) {
				return true;
			}

		}
		return false;
	}

}
