package com.office.media.repositoryInterfaces;

import java.util.List;

public interface IDAO<T> {
	public T create(T object);

	public void update(T object);

	public void delete(T object);

	public T findById(long id);

	public List<T> getAll();

	public List<T> getAll(int from, int limit);

}
