package com.office.media.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

import com.office.media.util.ImageUtil;

@FacesValidator("imageValidator")
public class ImageValidator implements Validator {

	@Override
	public void validate(FacesContext arg0, UIComponent arg1, Object value) throws ValidatorException {
		if (value == null)
			return;
		if (!ImageUtil.isValidImage((Part) value))
			throw new ValidatorException(new FacesMessage("* Invalid File Type."));
	}

}
