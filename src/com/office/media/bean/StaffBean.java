package com.office.media.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import com.office.media.entity.Birthday;
import com.office.media.entity.Role;
import com.office.media.entity.Staff;
import com.office.media.service.StaffService;
import com.office.media.util.ImageUtil;

@ManagedBean
@RequestScoped
public class StaffBean {

	@ManagedProperty("#{staffService}")
	private StaffService staffService;

	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	@ManagedProperty("#{applicationUserSession}")
	private ApplicationUserSession applicationUserSession;

	@ManagedProperty("#{utilityBean}")
	private UtilityBean utilityBean;

	private String oldPassword;

	private String newPassword;

	private String confirmPassword;

	private Staff staff;

	private Role role;

	private Part image;

	@PostConstruct
	public void init() {
		staff = new Staff();
	}

	public List<Staff> getNewStaffList() {
		return staffService.getNewStaffList();
	}

	public List<Staff> getSearchResult() {
		return staffService.searchByName(sessionBean.getSearchKeyword());
	}

	public List<Staff> getAllStaffList() {
		return staffService.getAll();
	}

	public void addStaff() {
		String imageUrl = utilityBean.uploadFile(image, "/resources/images");
		if (null == imageUrl)
			imageUrl = "defaultProfile.png";
		staff.setProfileimageUrl(imageUrl);
		Birthday birthday = new Birthday(staff, imageUrl, "Happy Birthday");
		staffService.create(staff, birthday, role);
	}

	public void updateStaff() {
		Staff staff = sessionBean.getSelectedStaffToEdit();
		if (null == staff)
			return;
		String fileUrl = utilityBean.uploadFile(image, "/resources/images");
		if (null != fileUrl)
			staff.setProfileimageUrl(fileUrl);
		staff.bind(this.staff);
		staff.setRole(role);
		staffService.update(staff);
		cancel();
	}

	public void cancel() {
		sessionBean.setSelectedStaffToEdit(null);
		this.staff = new Staff();
	}

	public String deleteStaff(Staff staff) {
		if (!staff.getProfileimageUrl().equals("defaultProfile.png"))
			ImageUtil.deleteImage(utilityBean.getFullFileUrl("/resources/images", staff.getProfileimageUrl()));
		staffService.delete(staff);
		return null;
	}

	public String selectStaffToEdit(Staff staff) {
		sessionBean.setSelectedStaffToEdit(staff);
		this.staff = staff;
		this.role = staff.getRole();
		return null;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public Staff getStaffInProfile() {
		return sessionBean.getStaffInProfile();
	}

	public String saveEditedProfileInformation() {
		staffService.update(applicationUserSession.getLoginStaff());
		addMessage("editInfo:successOutput", new FacesMessage("Saved Successfully!"));
		return null;
	}

	public String changedPassword() {
		Staff staff = applicationUserSession.getLoginStaff();
		if (!staff.getPassword().equals(oldPassword)) {
			addMessage("passEdit:oldpassword", new FacesMessage("* Password is Incorrect."));
			return null;
		}
		if (!newPassword.equals(confirmPassword)) {
			addMessage("passEdit:confirmpassword", new FacesMessage("* Confirm Password is not match."));
			return null;
		}
		staff.setPassword(newPassword);
		staffService.update(staff);
		addMessage("passEdit:successOutput", new FacesMessage("Changed Password Successfully!"));
		return null;
	}

	private void addMessage(String id, FacesMessage facesMessage) {
		FacesContext.getCurrentInstance().addMessage(id, facesMessage);
	}

	public String viewProfile(Staff staff) {
		sessionBean.setStaffInProfile(staff);
		sessionBean.setProfilePaginationPoint(0);
		return "profile";
	}

	public List<Role> getRoleList() {
		return staffService.getRoleList();
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public String getOldPassword() {
		return null;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return null;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return null;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setApplicationUserSession(ApplicationUserSession applicationUserSession) {
		this.applicationUserSession = applicationUserSession;
	}

	public Staff getStaff() {
		return staff;
	}

	public long getRole() {
		if (null != role)
			return role.getId();
		return 0;
	}

	public void setRole(long id) {
		this.role = staffService.findRoleById(id);
	}

	public Part getImage() {
		return null;
	}

	public void setImage(Part image) {
		this.image = image;
	}

	public void setUtilityBean(UtilityBean utilityBean) {
		this.utilityBean = utilityBean;
	}

}
