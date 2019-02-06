package com.office.media.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.media.entity.Comment;
import com.office.media.entity.Post;
import com.office.media.entity.Staff;
import com.office.media.entity.StaffGroup;
import com.office.media.repositoryInterfaces.ICommentDAO;
import com.office.media.repositoryInterfaces.IPostDAO;

@Service("postService")
public class PostService {

	@Autowired
	private IPostDAO postDAO;
	@Autowired
	private ICommentDAO commentDAO;

	public List<Post> getLatestPost(int form, int limit) {
		return postDAO.getAll(form, limit);
	}

	public List<Post> getPostByStaff(Staff staff, int form, int limit) {
		return postDAO.searchByStaff(staff, form, limit);
	}

	public List<Post> getPostByGroup(StaffGroup staffGroup, int from, int limit) {
		return postDAO.getAllPostByStaffGroup(staffGroup, from, limit);
	}

	public void create(Post post) {
		postDAO.create(post);
	}

	public void delete(Post post) {
		postDAO.delete(post);
	}

	public void update(Post post) {
		postDAO.update(post);
	}

	public void saveComment(Date commentDate, Staff staff, String contents, Post post) {
		Comment comment = new Comment(commentDate, staff, contents, post);
		commentDAO.create(comment);
		post.getComments().add(comment);
		postDAO.update(post);
	}

	public void likePost(Post post, Staff staff) {
		if (liked(post, staff))
			unlike(post, staff);
		else
			like(post, staff);
	}

	public boolean liked(Post post, Staff staff) {
		return post.getPostLove().contains(staff);
	}

	private void like(Post post, Staff staff) {
		post.getPostLove().add(staff);
		int count = post.getLoveCount() + 1;
		post.setLoveCount(count);
		postDAO.update(post);
	}

	private void unlike(Post post, Staff staff) {
		post.getPostLove().remove(staff);
		int count = post.getLoveCount() - 1;
		post.setLoveCount(count);
		postDAO.update(post);
	}

	public void deleteComment(Comment comment) {
		comment.getPost().getComments().remove(comment);
		postDAO.update(comment.getPost());
		commentDAO.delete(comment);
	}

	public List<Post> searchByContent(String content) {
		return postDAO.searchByContent(content);
	}

}
