package co.edu.uco.nose.business.business.validator.idType;

import co.edu.uco.nose.business.business.rule.idType.IdTypeExistsByIdRule;
import co.edu.uco.nose.business.business.validator.Validator;

public class ValidateIdTypeExistsById implements Validator {
	
	private static final Validator INSTANCE = new ValidateIdTypeExistsById();
	
	private ValidateIdTypeExistsById() {
	}
	
	public static void executeValidation(final Object... data) {
		INSTANCE.validate(data);
	}

	@Override
	public void validate(final Object... data) {
		IdTypeExistsByIdRule.executeRule(data);
	}

}
