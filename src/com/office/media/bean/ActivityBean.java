package com.office.media.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import org.springframework.web.context.annotation.RequestScope;

import com.office.media.entity.Activity;
import com.office.media.service.ActivityService;

@ManagedBean
@RequestScope
public class ActivityBean {

	@ManagedProperty("#{activityService}")
	private ActivityService activityService;
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	public void setActivityService(ActivityService activityService) {
		this.activityService = activityService;
	}

	public List<Activity> getSearchResult() {
		return activityService.searchByContent(sessionBean.getSearchKeyword(), 0, 10);
	}

	public List<Activity> getRecentActivity() {
		return activityService.getRecentActivity();
	}

	public List<Activity> getActivityList() {
		return activityService.getAll(sessionBean.getActivityPaginationPoint(), 10);
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

}
