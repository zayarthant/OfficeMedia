package com.office.media.repositoryInterfaces;

import java.util.Date;
import java.util.List;

import com.office.media.entity.Staff;

public interface IStaffDAO extends IDAO<Staff> {
	public List<Staff> searchByName(String name);

	public Staff searchByStaffID(String staffId);

	public List<Staff> searchByDateBefore(Date date);

	public List<Staff> getStaffOfThisMonthBirthday();

	public Staff getUserByInfo(String staffId, String password);
}
