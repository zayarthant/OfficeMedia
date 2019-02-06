package com.office.media.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.office.media.entity.Voting;
import com.office.media.repositoryInterfaces.IVotingDAO;

@Repository
public class VotingDAO extends DAOAbstrac<Voting> implements IVotingDAO {

	public VotingDAO() {
		super(Voting.class);
	}

	@Override
	public List<Voting> searchByDate(Date date) {
		return em.createQuery("SELECT s FROM Voting s WHERE s.postDate = ?1", Voting.class).setParameter(1, date)
				.getResultList();
	}

	@Override
	public List<Voting> searchByDate(Date date, int limit) {
		return em.createQuery("SELECT s FROM Voting s WHERE s.postDate = ?1", Voting.class).setParameter(1, date)
				.setMaxResults(limit).getResultList();
	}

	@Override
	public List<Voting> searchAfter(Date date) {
		return em.createQuery("SELECT s FROM Voting s WHERE s.postDate > ?1", Voting.class).setParameter(1, date)
				.getResultList();
	}

}
