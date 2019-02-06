package com.office.media.repositoryInterfaces;

import java.util.List;

import com.office.media.entity.Birthday;

public interface IBirthdayDAO extends IDAO<Birthday>, ISearchByDate<Birthday> {
	public List<Birthday> getBirthdayOfThisMonth();
	public List<Birthday> getBirthdayOnThisDay();
	
}
