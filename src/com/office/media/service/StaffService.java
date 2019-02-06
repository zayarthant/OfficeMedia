package com.office.media.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.media.entity.Birthday;
import com.office.media.entity.Role;
import com.office.media.entity.Staff;
import com.office.media.repositoryInterfaces.IRoleDAO;
import com.office.media.repositoryInterfaces.IStaffDAO;
import com.office.media.util.DateTimeUtil;

@Service("staffService")
public class StaffService {

	@Autowired
	private IStaffDAO staffDAO;

	@Autowired
	private IRoleDAO roleDAO;

	public List<Role> getRoleList() {
		return roleDAO.getAll();
	}

	public List<Staff> getNewStaffList() {
		return staffDAO.searchByDateBefore(DateTimeUtil.subtractDayFrom(new Date(), 30));
	}

	public List<Staff> searchByName(String name) {
		return staffDAO.searchByName(name);
	}

	public List<Staff> getAll() {
		return staffDAO.getAll();
	}

	public List<Staff> getAll(int from, int limit) {
		return staffDAO.getAll(from, limit);
	}

	public Staff getUserByInfo(String staffId, String password) {
		return staffDAO.getUserByInfo(staffId, password);
	}

	public void update(Staff staff) {
		staffDAO.update(staff);
	}

	public void delete(Staff staff) {
		staffDAO.delete(staff);
	}

	public void create(Staff staff, Birthday birthday, Role role) {
		staff.setBirthday(birthday);
		staff.setRole(role);
		staffDAO.create(staff);
	}

	public Staff findById(long id) {
		return staffDAO.findById(id);
	}

	public Role findRoleById(long id) {
		return roleDAO.findById(id);
	}

}
