package com.office.media.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SearchBean {

	private String search;

	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	public String getSearch() {
		return search;
	}

	public String search() {
		sessionBean.setSearchKeyword(search);
		return "searchResult";
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}

}
