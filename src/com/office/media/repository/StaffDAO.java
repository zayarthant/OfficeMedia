package com.office.media.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.NonUniqueResultException;

import org.springframework.stereotype.Repository;

import com.office.media.entity.Staff;
import com.office.media.repositoryInterfaces.IStaffDAO;

@Repository
public class StaffDAO extends DAOAbstrac<Staff> implements IStaffDAO {

	public StaffDAO() {
		super(Staff.class);
	}

	@Override
	public List<Staff> searchByName(String name) {
		return em.createQuery("SELECT s FROM Staff s WHERE s.name LIKE ?1", Staff.class)
				.setParameter(1, "%" + name + "%").getResultList();
	}

	@Override
	public Staff searchByStaffID(String staffId) {
		List<Staff> staffList = em.createQuery("SELECT s FROM Staff s WHERE s.staffId = ?1", Staff.class)
				.setParameter(1, "%" + staffId).getResultList();
		return getSingleResult(staffList);
	}

	private Staff getSingleResult(List<Staff> staffList) {
		if (staffList.isEmpty())
			return null;
		if (staffList.size() == 1)
			return staffList.get(0);
		throw new NonUniqueResultException();
	}

	@Override
	public List<Staff> searchByDateBefore(Date date) {
		return em.createQuery("SELECT s FROM Staff s WHERE s.startEmployDate > ?1", Staff.class).setParameter(1, date)
				.getResultList();
	}

	@Override
	public List<Staff> getStaffOfThisMonthBirthday() {
		return em.createQuery("SELECT s FROM Staff s WHERE FUNCTION('MONTH', s.dateOfBirth)  = FUNCTION('MONTH', ?1)",
				Staff.class).setParameter(1, new Date()).getResultList();
	}

	@Override
	public Staff getUserByInfo(String staffId, String password) {
		List<Staff> staffList = em
				.createQuery("SELECT s FROM Staff s WHERE s.staffId = ?1 AND s.password = ?2", Staff.class)
				.setParameter(1, staffId).setParameter(2, password).getResultList();
		return getSingleResult(staffList);
	}

}
