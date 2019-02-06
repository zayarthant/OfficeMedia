package com.office.media.repositoryInterfaces;

import java.util.List;

import com.office.media.entity.Post;
import com.office.media.entity.Staff;
import com.office.media.entity.StaffGroup;

public interface IPostDAO extends IDAO<Post>, ISearchByDate<Post>, ISearchByContent<Post> {
	public List<Post> searchByStaff(Staff staff, int start, int limit);

	public List<Post> getAllPostByStaffGroup(StaffGroup staffGroup, int from, int limit);
}
