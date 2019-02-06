/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.office.media.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author Zayar Thant
 * @author Kyaw Lin Htun
 * @author Soe Soe Than
 */
@Entity
public class WishComment extends AComent {

	private static final long serialVersionUID = 1L;
	@OneToOne
	private Birthday birthday;

	public WishComment() {

	}

	public WishComment(Date commentDate, Staff staff, String contents, Birthday birthday) {
		super(commentDate, staff, contents);
		this.birthday = birthday;
	}

	public Birthday getBirthday() {
		return birthday;
	}

	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}

}
