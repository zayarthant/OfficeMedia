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
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String photoUrl;
	@Column(columnDefinition = "TEXT")
	private String contents;
	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;
	@OneToOne
	private Staff staff;
	@OneToMany
	private List<Staff> postLove;
	private int loveCount;
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "post")
	private List<Comment> comments;
	@OneToOne
	private StaffGroup staffGroup;

	public Post() {
		super();
	}

	public Post(String photoUrl, String contents, Date postDate, Staff staff) {
		super();
		this.photoUrl = photoUrl;
		this.contents = contents;
		this.postDate = postDate;
		this.staff = staff;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

	public List<Staff> getPostLove() {
		return postLove;
	}

	public void setPostLove(List<Staff> postLove) {
		this.postLove = postLove;
	}

	public int getLoveCount() {
		return loveCount;
	}

	public void setLoveCount(int loveCount) {
		this.loveCount = loveCount;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public StaffGroup getStaffGroup() {
		return staffGroup;
	}

	public void setStaffGroup(StaffGroup staffGroup) {
		this.staffGroup = staffGroup;
	}

}
