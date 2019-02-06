package com.office.media.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.office.media.entity.Activity;
import com.office.media.repositoryInterfaces.IActivityDAO;

@Repository
public class ActivityDAO extends DAOAbstrac<Activity> implements IActivityDAO {
	public ActivityDAO() {
		super(Activity.class);
	}

	@Override
	public List<Activity> searchByDate(Date date) {
		return em.createQuery("SELECT s FROM Activity s WHERE s.activityDate = ?1 ORDER BY s.id DESC", Activity.class)
				.setParameter(1, date).getResultList();
	}

	@Override
	public List<Activity> searchByDate(Date date, int limit) {
		return em.createQuery("SELECT s FROM Activity s WHERE s.activityDate = ?1 ORDER BY s.id DESC", Activity.class)
				.setParameter(1, date).setMaxResults(limit).getResultList();
	}

	@Override
	public List<Activity> searchByContent(String content) {
		return em.createQuery("SELECT s FROM Activity s WHERE s.contents LIKE ?1 ORDER BY s.id DESC", Activity.class)
				.setParameter(1, "%" + content + "%").getResultList();
	}

	@Override
	public List<Activity> searchByContent(String content, int start, int limit) {
		return em.createQuery("SELECT s FROM Activity s WHERE s.contents LIKE ?1 ORDER BY s.id DESC", Activity.class).setFirstResult(start)
				.setMaxResults(limit).setParameter(1, "%" + content + "%").getResultList();
	}

	@Override
	public List<Activity> searchAfter(Date date) {
		return em.createQuery("SELECT s FROM Activity s WHERE s.activityDate > ?1 ORDER BY s.id DESC", Activity.class)
				.setParameter(1, date).getResultList();
	}

}
