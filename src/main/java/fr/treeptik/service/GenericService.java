package fr.treeptik.service;

import java.util.List;

import fr.treeptik.Exception.ServiceException;

public interface GenericService<T, PK> {
	
	
	T save(T entite) throws ServiceException;
	void remove(PK id) throws ServiceException;
	T findById(PK id) throws ServiceException;
	List<T> findAll() throws ServiceException;
	T update(T entite) throws ServiceException;

}
