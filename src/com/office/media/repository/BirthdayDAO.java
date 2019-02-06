package com.office.media.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.office.media.entity.Birthday;
import com.office.media.repositoryInterfaces.IBirthdayDAO;

@Repository
public class BirthdayDAO extends DAOAbstrac<Birthday> implements IBirthdayDAO {
	public BirthdayDAO() {
		super(Birthday.class);
	}

	@Override
	public List<Birthday> searchByDate(Date date) {
		return em.createQuery("SELECT s FROM Birthday s WHERE s.staff.dateOfBirth = ?1", Birthday.class)
				.setParameter(1, date).getResultList();
	}

	@Override
	public List<Birthday> searchByDate(Date date, int limit) {
		return em.createQuery("SELECT s FROM Birthday s WHERE s.staff.dateOfBirth = ?1", Birthday.class)
				.setParameter(1, date).setMaxResults(limit).getResultList();
	}

	@Override
	public List<Birthday> getBirthdayOfThisMonth() {
		return em.createQuery(
				"SELECT s FROM Birthday s WHERE FUNCTION('MONTH', s.staff.dateOfBirth)  = FUNCTION('MONTH', ?1)",
				Birthday.class).setParameter(1, new Date()).getResultList();
	}

	@Override
	public List<Birthday> getBirthdayOnThisDay() {
		return em.createQuery(
				"SELECT s FROM Birthday s WHERE FUNCTION('MONTH', s.staff.dateOfBirth)  = FUNCTION('MONTH', ?1) AND FUNCTION('DAY', s.staff.dateOfBirth)  = FUNCTION('DAY', ?1)",
				Birthday.class).setParameter(1, new Date()).getResultList();
	}

	@Override
	public List<Birthday> searchAfter(Date date) {
		return em.createQuery("SELECT s FROM Birthday s WHERE s.staff.dateOfBirth > ?1", Birthday.class)
				.setParameter(1, date).getResultList();
	}
}
