package com.office.media.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.office.media.entity.StaffGroup;
import com.office.media.service.GroupService;

@ManagedBean
@RequestScoped
public class GroupBean {

	@ManagedProperty("#{groupService}")
	private GroupService groupService;

	@ManagedProperty("#{applicationUserSession}")
	private ApplicationUserSession applicationUserSession;

	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	public StaffGroup getVisitingStaffGroup() {
		return groupService.findById(sessionBean.getVisitingStaffGroupId());
	}

	public List<StaffGroup> getSuggestGroup() {
		return groupService.getSuggestGroup(applicationUserSession.getLoginStaff(),
				sessionBean.getStaffGroupListPaginationPoint(), 9);
	}

	public String viewGroup(StaffGroup staffGroup) {
		sessionBean.setVisitingStaffGroupId(staffGroup.getId());
		sessionBean.setStaffGroupPostPaginationPoint(0);
		return "group";
	}

	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}

	public void joinGroup(StaffGroup staffGroup) {
		staffGroup = groupService.findById(staffGroup.getId());
		groupService.joinGroup(applicationUserSession.getLoginStaff(), staffGroup);
	}

	public String leaveGroup() {
		StaffGroup staffGroup = groupService.findById(sessionBean.getVisitingStaffGroupId());
		groupService.leaveGroup(applicationUserSession.getLoginStaff(), staffGroup);
		return "groupList";
	}

	public void setApplicationUserSession(ApplicationUserSession applicationUserSession) {
		this.applicationUserSession = applicationUserSession;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

}
