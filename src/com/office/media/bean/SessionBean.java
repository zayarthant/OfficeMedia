package com.office.media.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.office.media.entity.Activity;
import com.office.media.entity.Birthday;
import com.office.media.entity.Post;
import com.office.media.entity.Staff;
import com.office.media.entity.StaffGroup;

@ManagedBean(name = "sessionBean")
@SessionScoped
public class SessionBean {
	private int pagePaginationPoint;
	private int profilePaginationPoint;
	private int activityPaginationPoint;
	private int votingPaginationPoint;
	private int staffGroupPostPaginationPoint;
	private int staffGroupListPaginationPoint;
	private String searchKeyword;
	private Post postSelectedToEdit;
	private Staff staffInProfile;
	private long visitingStaffGroupId;

	private Staff selectedStaffToEdit;
	private Activity selectedActivityToEdit;
	private StaffGroup selectedStaffGroupToEdit;
	private Birthday selectedBirthdayToEdit;

	public int getPagePaginationPoint() {
		return pagePaginationPoint;
	}

	public void setPagePaginationPoint(int pagePaginationPoint) {
		this.pagePaginationPoint = pagePaginationPoint;
	}

	public int incresePagePaginationPoint(int count) {
		pagePaginationPoint = count + pagePaginationPoint;
		return pagePaginationPoint;
	}

	public int decresePagePaginationPoint(int count) {
		if (this.pagePaginationPoint < 10)
			return pagePaginationPoint;
		pagePaginationPoint = pagePaginationPoint - count;
		return pagePaginationPoint;
	}

	public int increseActivityPaginationPoint(int count) {
		activityPaginationPoint = count + activityPaginationPoint;
		return activityPaginationPoint;
	}

	public int decreseActivityPaginationPoint(int count) {
		if (this.activityPaginationPoint < 10)
			return activityPaginationPoint;
		activityPaginationPoint = activityPaginationPoint - count;
		return activityPaginationPoint;
	}

	public int increseVotingPaginationPoint(int count) {
		votingPaginationPoint = count + votingPaginationPoint;
		return votingPaginationPoint;
	}

	public int decreseVotingPaginationPoint(int count) {
		if (this.votingPaginationPoint < 10)
			return votingPaginationPoint;
		votingPaginationPoint = votingPaginationPoint - count;
		return votingPaginationPoint;
	}

	public Post getPostSelectedToEdit() {
		return postSelectedToEdit;
	}

	public void setPostSelectedToEdit(Post postSelectedToEdit) {
		this.postSelectedToEdit = postSelectedToEdit;
	}

	public int getActivityPaginationPoint() {
		return activityPaginationPoint;
	}

	public void setActivityPaginationPoint(int activityPaginationPoint) {
		this.activityPaginationPoint = activityPaginationPoint;
	}

	public int getVotingPaginationPoint() {
		return votingPaginationPoint;
	}

	public void setVotingPaginationPoint(int votingPaginationPoint) {
		this.votingPaginationPoint = votingPaginationPoint;
	}

	public void setProfilePaginationPoint(int profilePaginationPoint) {
		this.profilePaginationPoint = profilePaginationPoint;
	}

	public int increseProfilePaginationPoint(int count) {
		profilePaginationPoint = count + profilePaginationPoint;
		return profilePaginationPoint;
	}

	public int decreseProfilePaginationPoint(int count) {
		if (this.profilePaginationPoint < 10)
			return profilePaginationPoint;
		profilePaginationPoint = profilePaginationPoint - count;
		return profilePaginationPoint;
	}

	public int getProfilePaginationPoint() {
		return profilePaginationPoint;
	}

	public Staff getStaffInProfile() {
		return staffInProfile;
	}

	public void setStaffInProfile(Staff staffInProfile) {
		this.staffInProfile = staffInProfile;
	}

	public long getVisitingStaffGroupId() {
		return visitingStaffGroupId;
	}

	public void setVisitingStaffGroupId(long visitingStaffGroupId) {
		this.visitingStaffGroupId = visitingStaffGroupId;
	}

	public int getStaffGroupPostPaginationPoint() {
		return staffGroupPostPaginationPoint;
	}

	public void setStaffGroupPostPaginationPoint(int staffGroupPostPaginationPoint) {
		this.staffGroupPostPaginationPoint = staffGroupPostPaginationPoint;
	}

	public int increseStaffGroupPostPaginationPoint(int count) {
		staffGroupPostPaginationPoint = count + staffGroupPostPaginationPoint;
		return staffGroupPostPaginationPoint;
	}

	public int decreseStaffGroupPostPaginationPoint(int count) {
		if (this.staffGroupPostPaginationPoint < 10)
			return staffGroupPostPaginationPoint;
		staffGroupPostPaginationPoint = staffGroupPostPaginationPoint - count;
		return staffGroupPostPaginationPoint;
	}

	public int getStaffGroupListPaginationPoint() {
		return staffGroupListPaginationPoint;
	}

	public void setStaffGroupListPaginationPoint(int staffGroupListPaginationPoint) {
		this.staffGroupListPaginationPoint = staffGroupListPaginationPoint;
	}

	public int increseStaffGroupListPaginationPoint(int count) {
		staffGroupListPaginationPoint = count + staffGroupListPaginationPoint;
		return staffGroupListPaginationPoint;
	}

	public int decreseStaffGroupListPaginationPoint(int count) {
		if (this.staffGroupListPaginationPoint < 9)
			return staffGroupListPaginationPoint;
		staffGroupListPaginationPoint = staffGroupListPaginationPoint - count;
		return staffGroupListPaginationPoint;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public Staff getSelectedStaffToEdit() {
		return selectedStaffToEdit;
	}

	public void setSelectedStaffToEdit(Staff selectedStaffToEdit) {
		this.selectedStaffToEdit = selectedStaffToEdit;
	}

	public Activity getSelectedActivityToEdit() {
		return selectedActivityToEdit;
	}

	public void setSelectedActivityToEdit(Activity selectedActivityToEdit) {
		this.selectedActivityToEdit = selectedActivityToEdit;
	}

	public StaffGroup getSelectedStaffGroupToEdit() {
		return selectedStaffGroupToEdit;
	}

	public void setSelectedStaffGroupToEdit(StaffGroup selectedStaffGroupToEdit) {
		this.selectedStaffGroupToEdit = selectedStaffGroupToEdit;
	}

	public Birthday getSelectedBirthdayToEdit() {
		return selectedBirthdayToEdit;
	}

	public void setSelectedBirthdayToEdit(Birthday selectedBirthdayToEdit) {
		this.selectedBirthdayToEdit = selectedBirthdayToEdit;
	}

}
