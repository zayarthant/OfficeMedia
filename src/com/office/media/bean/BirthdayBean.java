package com.office.media.bean;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.office.media.entity.Birthday;
import com.office.media.entity.WishComment;
import com.office.media.service.BirthdayService;

@ManagedBean
@RequestScoped
public class BirthdayBean {

	private String wishComment;

	@ManagedProperty("#{birthdayService}")
	private BirthdayService birthdayService;
	@ManagedProperty("#{applicationUserSession}")
	private ApplicationUserSession applicationUserSession;

	public void saveComment(Birthday birthday) {
		birthdayService.saveComment(new Date(), wishComment, applicationUserSession.getLoginStaff(), birthday);
	}

	public void deleteComment(WishComment wishComment) {
		birthdayService.deleteComment(wishComment);
	}

	public String getWishComment() {
		return null;
	}

	public List<Birthday> getBirthdayOfThisMonth() {
		return birthdayService.getBirthdayOfThisMonth();
	}

	public List<Birthday> getBirthdayOnThisDay() {
		return birthdayService.getBirthdayOnThisDay();
	}

	public void setWishComment(String wishComment) {
		this.wishComment = wishComment;
	}

	public void setBirthdayService(BirthdayService birthdayService) {
		this.birthdayService = birthdayService;
	}

	public void setApplicationUserSession(ApplicationUserSession applicationUserSession) {
		this.applicationUserSession = applicationUserSession;
	}

}
