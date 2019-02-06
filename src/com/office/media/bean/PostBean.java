package com.office.media.bean;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import com.office.media.entity.Comment;
import com.office.media.entity.Post;
import com.office.media.entity.Staff;
import com.office.media.entity.StaffGroup;
import com.office.media.service.PostService;
import com.office.media.util.Debarg;
import com.office.media.util.ImageUtil;

@ManagedBean
@RequestScoped
public class PostBean {
	// Post
	private String content;
	private Part image;
	private String imageUrl;
	// Comment
	private String comment;
	@ManagedProperty("#{postService}")
	private PostService postService;
	@ManagedProperty("#{applicationUserSession}")
	private ApplicationUserSession applicationUserSession;
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	@PostConstruct
	public void init() {
		Debarg.trace("Post Bean", "Constructed");
	}

	public List<Post> getAll() {
		return postService.getLatestPost(sessionBean.getPagePaginationPoint(), 10);
	}

	public List<Post> getPostByStaff(Staff staff) {
		return postService.getPostByStaff(staff, sessionBean.getProfilePaginationPoint(), 10);
	}

	public List<Post> getPostByGroup(StaffGroup staffGroup) {
		return postService.getPostByGroup(staffGroup, sessionBean.getStaffGroupPostPaginationPoint(), 10);
	}

	public void addPost() {
		if (content.isEmpty() && null == image)
			return;
		String fileUrl = uploadFile(image);
		Post post = new Post(fileUrl, content, new Date(), applicationUserSession.getLoginStaff());
		postService.create(post);
		clearForm();
	}

	public void addGroupPost(StaffGroup staffGroup) {
		if (content.isEmpty() && null == image)
			return;
		String fileUrl = uploadFile(image);
		Post post = new Post(fileUrl, content, new Date(), applicationUserSession.getLoginStaff());
		post.setStaffGroup(staffGroup);
		postService.create(post);
		clearForm();
	}

	private void clearForm() {
		content = null;
		image = null;
		imageUrl = null;
	}

	private String uploadFile(Part image) {
		if (null == image)
			return null;
		String fileUrl = ImageUtil.generateImageName(image.getSubmittedFileName());
		String fullFileUrl = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/images")
				+ File.separator + fileUrl;
		ImageUtil.uploadImage(image, fullFileUrl);
		return fileUrl;
	}

	public String deletePost(Post post) {
		postService.delete(post);
		return null;
	}

	public void editPost() {
		Post post = sessionBean.getPostSelectedToEdit();
		if (null == post)
			return;
		if (content.isEmpty() && null == image)
			return;
		post.setContents(content);
		String fileUrl = uploadFile(image);
		if (null != fileUrl)
			post.setPhotoUrl(fileUrl);
		postService.update(post);
		sessionBean.setPostSelectedToEdit(null);
		clearForm();
	}

	public String selectPostToEdit(Post post) {
		sessionBean.setPostSelectedToEdit(post);
		content = post.getContents();
		imageUrl = post.getPhotoUrl();
		if (post.getStaffGroup() == null)
			return "timeline";
		return null;
	}

	public String likePost(Post post) {
		postService.likePost(post, applicationUserSession.getLoginStaff());
		return null;
	}

	public boolean liked(Post post) {
		return postService.liked(post, applicationUserSession.getLoginStaff());
	}

	public void deleteComment(Comment comment) {
		postService.deleteComment(comment);
	}

	public void saveComment(Post post) {
		Debarg.trace("addComment", comment);
		postService.saveComment(new Date(), applicationUserSession.getLoginStaff(), comment, post);
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

	public void setApplicationUserSession(ApplicationUserSession applicationUserSession) {
		this.applicationUserSession = applicationUserSession;
	}

	public void setPostService(PostService postService) {
		this.postService = postService;
	}

	public String getComment() {
		return null;
	}

	public void setComment(String comment) {
		Debarg.trace("setComment", comment);
		this.comment = comment;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Part getImage() {
		return image;
	}

	public void setImage(Part image) {
		this.image = image;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
