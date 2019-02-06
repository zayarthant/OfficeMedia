package com.office.media.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.office.media.exception.DAOException;
import com.office.media.repositoryInterfaces.IDAO;

public abstract class DAOAbstrac<T> implements IDAO<T> {

	@PersistenceContext
	protected EntityManager em;

	private final Class<T> type;

	public DAOAbstrac(Class<T> clazz) {
		this.type = clazz;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public T create(T object) throws DAOException {
		if (em.contains(object))
			update(object);
		else
			em.persist(object);
		em.flush();
		return object;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T object) throws DAOException {
		em.merge(object);
		em.flush();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(T object) throws DAOException {
		em.remove(em.merge(object));
		em.flush();
	}

	public T findById(long id) {
		return em.find(type, id);
	}

	public List<T> getAll() {
		return em.createQuery("SELECT s FROM " + type.getSimpleName() + " s  ORDER BY s.id DESC", type).getResultList();
	}

	public List<T> getAll(int from, int limit) {
		return em.createQuery("SELECT s FROM " + type.getSimpleName() + " s  ORDER BY s.id DESC", type)
				.setFirstResult(from).setMaxResults(limit).getResultList();
	}

}
