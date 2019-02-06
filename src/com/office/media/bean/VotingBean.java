package com.office.media.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.office.media.entity.VoteOption;
import com.office.media.entity.Voting;
import com.office.media.service.VotingService;

@ManagedBean
@RequestScoped
public class VotingBean {

	@ManagedProperty("#{votingService}")
	private VotingService votingService;
	@ManagedProperty("#{applicationUserSession}")
	private ApplicationUserSession applicationUserSession;
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	public void setVotingService(VotingService votingService) {
		this.votingService = votingService;
	}

	public void vote(VoteOption voteOption) {
		votingService.vote(voteOption, applicationUserSession.getLoginStaff());
	}

	public boolean isVoted(VoteOption voteOption) {
		return voteOption.getStaffs().contains(applicationUserSession.getLoginStaff());
	}

	public List<Voting> getAll() {
		return votingService.getAll(sessionBean.getVotingPaginationPoint(), 10);
	}

	public List<Voting> getRecentVoting() {
		return votingService.getRecentVoting();
	}

	public void setApplicationUserSession(ApplicationUserSession applicationUserSession) {
		this.applicationUserSession = applicationUserSession;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

}
