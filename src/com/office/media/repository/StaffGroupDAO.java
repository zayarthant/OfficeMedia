package com.office.media.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.office.media.entity.Staff;
import com.office.media.entity.StaffGroup;
import com.office.media.repositoryInterfaces.IStaffGroupDAO;

@Repository
public class StaffGroupDAO extends DAOAbstrac<StaffGroup> implements IStaffGroupDAO {

	public StaffGroupDAO() {
		super(StaffGroup.class);
	}

	@Override
	public List<StaffGroup> searchByName(String name) {
		return em.createQuery("SELECT s FROM StaffGroup s WHERE s.groupName LIKE ?1", StaffGroup.class)
				.setParameter(1, "%" + name + "%").getResultList();
	}

	@Override
	public List<StaffGroup> suggestedStaffGroup(Staff staff) {
		return em.createQuery("SELECT s FROM StaffGroup s WHERE s.staffs <> ?1", StaffGroup.class)
				.setParameter(1, staff).getResultList();
	}

}
