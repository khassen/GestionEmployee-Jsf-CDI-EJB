package fr.treeptik.service.impl;

import java.util.List;

import fr.treeptik.Exception.DAOException;
import fr.treeptik.Exception.ServiceException;
import fr.treeptik.dao.GenericDAO;
import fr.treeptik.service.GenericService;

public abstract class GenericServiceImpl<T, PK, D extends GenericDAO<T, PK>> implements GenericService<T, PK>{

	protected abstract D getDAO();
	

	public T save(T entite) throws ServiceException {
		try {
			getDAO().save(entite);
			return entite;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}

	public void remove(PK id) throws ServiceException {
		try {
			getDAO().remove(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}


	public T findById(PK id) throws ServiceException {
		try {
			return getDAO().findById(id);
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}


	public List<T> findAll() throws ServiceException {
		try {
			return getDAO().findAll();
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
	

	public T update(T entite) throws ServiceException {
		try {
			getDAO().update(entite);
			return entite;
		} catch (DAOException e) {
			throw new ServiceException(e.getMessage(), e.getCause());
		}
	}
	
}
