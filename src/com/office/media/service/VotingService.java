package com.office.media.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.media.entity.Staff;
import com.office.media.entity.VoteOption;
import com.office.media.entity.Voting;
import com.office.media.repositoryInterfaces.IVoteOptionDAO;
import com.office.media.repositoryInterfaces.IVotingDAO;
import com.office.media.util.DateTimeUtil;

@Service("votingService")
public class VotingService {

	@Autowired
	private IVoteOptionDAO voteOptionDAO;
	@Autowired
	private IVotingDAO votingDAO;

	public List<Voting> getAll() {
		return votingDAO.getAll();
	}

	public List<Voting> getAll(int from, int limit) {
		return votingDAO.getAll(from, limit);
	}

	public List<Voting> getRecentVoting() {
		return votingDAO.searchAfter(DateTimeUtil.subtractDayFrom(new Date(), 7));
	}

	private void payVote(VoteOption voteOption, Staff staff) {
		voteOption.getStaffs().add(staff);
		int voteCount = 1 + voteOption.getVotingCount();
		voteOption.setVotingCount(voteCount);
		voteOptionDAO.update(voteOption);
	}

	public void vote(VoteOption voteOption, Staff staff) {
		if (voteOption.getVoting().isSingleVote())
			paySingleVote(voteOption, staff);
		else
			payMutipleVote(voteOption, staff);
	}

	private void payMutipleVote(VoteOption voteOption, Staff staff) {
		if (voteOption.getStaffs().contains(staff))
			unVote(voteOption, staff);
		else
			payVote(voteOption, staff);

	}

	private void paySingleVote(VoteOption voteOption, Staff staff) {
		List<VoteOption> voteOptionList = voteOption.getVoting().getVoteOptions();
		for (VoteOption option : voteOptionList)
			unVote(option, staff);
		payVote(voteOption, staff);

	}

	private void unVote(VoteOption voteOption, Staff staff) {
		if (!voteOption.getStaffs().contains(staff))
			return;
		voteOption.getStaffs().remove(staff);
		int voteCount = voteOption.getVotingCount() - 1;
		voteOption.setVotingCount(voteCount);
		voteOptionDAO.update(voteOption);
	}

}
