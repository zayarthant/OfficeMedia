package com.office.media.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.office.media.entity.Post;
import com.office.media.entity.Staff;
import com.office.media.entity.StaffGroup;
import com.office.media.repositoryInterfaces.IPostDAO;

@Repository
public class PostDAO extends DAOAbstrac<Post> implements IPostDAO {

	public PostDAO() {
		super(Post.class);
	}

	@Override
	public List<Post> searchByDate(Date date) {
		return em.createQuery("SELECT s FROM Post s WHERE s.postDate = ?1", Post.class).setParameter(1, date)
				.getResultList();
	}

	@Override
	public List<Post> searchByDate(Date date, int limit) {
		return em.createQuery("SELECT s FROM Post s WHERE s.postDate = ?1 ORDER BY s.id DESC", Post.class)
				.setParameter(1, date).setMaxResults(limit).getResultList();
	}

	@Override
	public List<Post> searchByContent(String content) {
		return em.createQuery("SELECT s FROM Post s WHERE s.contents LIKE ?1 ORDER BY s.id DESC", Post.class)
				.setParameter(1, "%" + content + "%").getResultList();
	}

	@Override
	public List<Post> searchByContent(String content, int start, int limit) {
		return em.createQuery("SELECT s FROM Post s WHERE s.contents LIKE ?1 ORDER BY s.id DESC", Post.class)
				.setFirstResult(start).setMaxResults(limit).setParameter(1, "%" + content + "%").getResultList();
	}

	@Override
	public List<Post> searchByStaff(Staff staff, int start, int limit) {
		return em.createQuery("SELECT s FROM Post s WHERE s.staff = ?1 AND s.staffGroup = NULL ORDER BY s.id DESC",
				Post.class).setFirstResult(start).setMaxResults(limit).setParameter(1, staff).getResultList();
	}

	@Override
	public List<Post> searchAfter(Date date) {
		return em.createQuery("SELECT s FROM Post s WHERE s.postDate > ?1 ORDER BY s.id DESC", Post.class)
				.setParameter(1, date).getResultList();
	}

	@Override
	public List<Post> getAll() {
		return em.createQuery("SELECT s FROM Post s WHERE s.staffGroup = NULL ORDER BY s.id DESC", Post.class)
				.getResultList();
	}

	@Override
	public List<Post> getAll(int from, int limit) {
		return em.createQuery("SELECT s FROM Post s WHERE s.staffGroup = NULL ORDER BY s.id DESC", Post.class)
				.setFirstResult(from).setMaxResults(limit).getResultList();
	}

	@Override
	public List<Post> getAllPostByStaffGroup(StaffGroup staffGroup, int from, int limit) {
		return em.createQuery("SELECT s FROM Post s WHERE s.staffGroup = ?1 ORDER BY s.id DESC", Post.class)
				.setParameter(1, staffGroup).setFirstResult(from).setMaxResults(limit).getResultList();
	}

}
