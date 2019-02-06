package com.office.media.bean;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.office.media.entity.Staff;
import com.office.media.service.StaffService;

@ManagedBean(name = "applicationUserSession")
@SessionScoped
public class ApplicationUserSession {

	private Staff loginStaff;

	private String staffId;
	private String password;

	@ManagedProperty("#{staffService}")
	private StaffService staffService;

	public Staff getLoginStaff() {
		return loginStaff;
	}

	public String login() {
		loginStaff = staffService.getUserByInfo(staffId, password);
		if (null == loginStaff) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("User ID or Password is Incorrect."));
			return null;
		}
		return "timeline";
	}

	public String logOut() {
		loginStaff = null;
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true";
	}

	public boolean isLogined() {
		if (null == loginStaff)
			return false;
		return true;
	}

	public boolean isLogined(long id) {
		if (id == loginStaff.getId())
			return true;
		return false;
	}

	public boolean isLogined(Staff staff) {
		if (null == staff)
			return false;
		if (staff.equals(loginStaff))
			return true;
		return false;
	}

	public String onPageLoad() {
		try {
			if (!isLogined())
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml?faces-redirect=true");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public String loginPageLoad() {
		try {
			if (isLogined())
				FacesContext.getCurrentInstance().getExternalContext().redirect("timeline.xhtml?faces-redirect=true");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

}
