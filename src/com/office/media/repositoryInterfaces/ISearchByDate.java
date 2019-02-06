package com.office.media.repositoryInterfaces;


import java.util.Date;
import java.util.List;


public interface ISearchByDate<T> {

	public List<T> searchByDate(Date date);

	public List<T> searchByDate(Date date, int limit);
	
	public List<T> searchAfter(Date date);

}
