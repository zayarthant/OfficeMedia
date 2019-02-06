package com.office.media.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.media.entity.Birthday;
import com.office.media.entity.Staff;
import com.office.media.entity.WishComment;
import com.office.media.repositoryInterfaces.IBirthdayDAO;
import com.office.media.repositoryInterfaces.IWishCommentDAO;

@Service("birthdayService")
public class BirthdayService {

	@Autowired
	private IBirthdayDAO birthdayDAO;
	@Autowired
	private IWishCommentDAO wishCommentDAO;


	public void saveComment(Date date, String wish, Staff staff, Birthday birthday) {
		WishComment wishComment = new WishComment(date, staff, wish, birthday);
		wishCommentDAO.create(wishComment);
		birthday.getWishComments().add(wishComment);
		birthdayDAO.update(birthday);
	}

	public void deleteComment(WishComment wishComment) {
		wishComment.getBirthday().getWishComments().remove(wishComment);
		birthdayDAO.update(wishComment.getBirthday());
		wishCommentDAO.delete(wishComment);
	}
	
	public List<Birthday> getBirthdayOfThisMonth() {
		return birthdayDAO.getBirthdayOfThisMonth();
	}
	
	public List<Birthday> getBirthdayOnThisDay() {
		return birthdayDAO.getBirthdayOnThisDay();
	}

}
