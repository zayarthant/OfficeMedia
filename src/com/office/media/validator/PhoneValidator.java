package com.office.media.validator;

import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("phoneValidator")
public class PhoneValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		Pattern pattern = Pattern.compile("\\+?[0-9]{8,12}");
		if (!pattern.matcher((String) value).matches()) {
			throw new ValidatorException(new FacesMessage("Unvalid Phone Number!"));
		}
	}

}
