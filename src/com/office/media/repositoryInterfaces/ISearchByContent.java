package com.office.media.repositoryInterfaces;

import java.util.List;


public interface ISearchByContent<T> {
	public List<T> searchByContent(String content);

	public List<T> searchByContent(String content, int start, int limit);
}
