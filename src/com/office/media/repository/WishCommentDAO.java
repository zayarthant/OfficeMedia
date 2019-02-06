
package com.office.media.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.office.media.entity.WishComment;
import com.office.media.repositoryInterfaces.IWishCommentDAO;

@Repository
public class WishCommentDAO extends DAOAbstrac<WishComment> implements IWishCommentDAO {

	public WishCommentDAO() {
		super(WishComment.class);
	}

	@Override
	public List<WishComment> searchByDate(Date date) {
		return em.createQuery("SELECT s FROM  WishComment s WHERE s.commentDate = ?1", WishComment.class)
				.setParameter(1, date).getResultList();
	}

	@Override
	public List<WishComment> searchByDate(Date date, int limit) {
		return em.createQuery("SELECT s FROM  WishComment s WHERE s.commentDate = ?1", WishComment.class)
				.setParameter(1, date).setMaxResults(limit).getResultList();
	}

	@Override
	public List<WishComment> searchAfter(Date date) {
		return em.createQuery("SELECT s FROM  WishComment s WHERE s.commentDate > ?1", WishComment.class)
				.setParameter(1, date).getResultList();
	}

}
