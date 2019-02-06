package com.office.media.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Voting implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(columnDefinition = "TEXT")
	private String contents;
	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;
	private boolean singleVote;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "voting")
	private List<VoteOption> voteOptions;
	@OneToMany
	private List<Staff> staffs;
	@OneToOne
	private Staff admin;

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public List<VoteOption> getVoteOptions() {
		return voteOptions;
	}

	public void setVoteOptions(List<VoteOption> voteOptions) {
		this.voteOptions = voteOptions;
	}

	public Staff getAdmin() {
		return admin;
	}

	public void setAdmin(Staff admin) {
		this.admin = admin;
	}

	public List<Staff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<Staff> staffs) {
		this.staffs = staffs;
	}

	public boolean isSingleVote() {
		return singleVote;
	}

	public void setSingleVote(boolean singleVote) {
		this.singleVote = singleVote;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
