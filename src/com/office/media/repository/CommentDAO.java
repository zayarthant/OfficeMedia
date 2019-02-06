package com.office.media.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.office.media.entity.Comment;
import com.office.media.repositoryInterfaces.ICommentDAO;

@Repository
public class CommentDAO extends DAOAbstrac<Comment> implements ICommentDAO {
	public CommentDAO() {
		super(Comment.class);
	}

	@Override
	public List<Comment> searchByDate(Date date) {
		return em.createQuery("SELECT s FROM  Comment s WHERE s.commentDate = ?1", Comment.class).setParameter(1, date)
				.getResultList();
	}

	@Override
	public List<Comment> searchByDate(Date date, int limit) {
		return em.createQuery("SELECT s FROM  Comment s WHERE s.commentDate = ?1", Comment.class).setParameter(1, date)
				.setMaxResults(limit).getResultList();
	}

	@Override
	public List<Comment> searchAfter(Date date) {
		return em.createQuery("SELECT s FROM  Comment s WHERE s.commentDate > ?1", Comment.class).setParameter(1, date)
				.getResultList();
	}
}