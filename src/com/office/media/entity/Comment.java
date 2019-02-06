package com.office.media.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Comment extends AComent {

	private static final long serialVersionUID = 1L;
	@OneToOne
	private Post post;

	public Comment() {
		super();
	}

	public Comment(Date commentDate, Staff staff, String contents, Post post) {
		super(commentDate, staff, contents);
		this.post = post;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

}
