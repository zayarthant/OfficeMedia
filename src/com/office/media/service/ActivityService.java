package com.office.media.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.media.entity.Activity;
import com.office.media.repositoryInterfaces.IActivityDAO;
import com.office.media.util.DateTimeUtil;

@Service("activityService")
public class ActivityService {
	@Autowired
	private IActivityDAO activityDAO;

	public List<Activity> getRecentActivity() {
		return activityDAO.searchAfter(DateTimeUtil.subtractDayFrom(new Date(), 7));
	}

	public List<Activity> getAll(int from, int limit) {
		return activityDAO.getAll(from, limit);
	}

	public List<Activity> searchByContent(String content) {
		return activityDAO.searchByContent(content);
	}

	public List<Activity> searchByContent(String content, int start, int limit) {
		return activityDAO.searchByContent(content, start, limit);
	}
}
