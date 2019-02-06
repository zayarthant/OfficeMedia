package com.office.media.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.media.entity.Staff;
import com.office.media.entity.StaffGroup;
import com.office.media.repositoryInterfaces.IStaffDAO;
import com.office.media.repositoryInterfaces.IStaffGroupDAO;

@Service
public class GroupService {

	@Autowired
	private IStaffGroupDAO staffGroupDAO;

	@Autowired
	private IStaffDAO staffDAO;

	public List<StaffGroup> getSuggestGroup(Staff staff, int from, int limit) {
		List<StaffGroup> staffGroupList = staffGroupDAO.getAll(from, limit);
		List<StaffGroup> enrolledGroupList = staff.getStaffGroups();
		staffGroupList.removeAll(enrolledGroupList);
		return staffGroupList;
	}

	public void leaveGroup(Staff staff, StaffGroup staffGroup) {
		staff.getStaffGroups().remove(staffGroup);
		staffGroup.getStaffs().remove(staff);
		staffGroupDAO.update(staffGroup);
		staffDAO.update(staff);
	}

	public void joinGroup(Staff staff, StaffGroup staffGroup) {
		staff.getStaffGroups().add(staffGroup);
		staffGroup.getStaffs().add(staff);
		staffGroupDAO.update(staffGroup);
		staffDAO.update(staff);
	}

	public StaffGroup findById(long id) {
		return staffGroupDAO.findById(id);
	}

	public List<StaffGroup> searchByName(String name) {
		return staffGroupDAO.searchByName(name);
	}

}
