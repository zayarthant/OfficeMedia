package com.office.media.repositoryInterfaces;

import java.util.List;

import com.office.media.entity.Staff;
import com.office.media.entity.StaffGroup;

public interface IStaffGroupDAO extends IDAO<StaffGroup> {
	public List<StaffGroup> searchByName(String name);
	public List<StaffGroup> suggestedStaffGroup(Staff staff);
}
