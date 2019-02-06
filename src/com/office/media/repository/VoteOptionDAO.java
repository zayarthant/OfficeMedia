package com.office.media.repository;

import org.springframework.stereotype.Repository;

import com.office.media.entity.VoteOption;
import com.office.media.repositoryInterfaces.IVoteOptionDAO;

@Repository
public class VoteOptionDAO extends DAOAbstrac<VoteOption> implements IVoteOptionDAO{

	public VoteOptionDAO() {
		super(VoteOption.class);
	}

}
