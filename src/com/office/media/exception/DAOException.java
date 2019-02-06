package com.office.media.exception;

import javax.persistence.PersistenceException;

public class DAOException extends PersistenceException {

	private static final long serialVersionUID = 1L;

	public DAOException(String message) {
		super(message);
	}

}
