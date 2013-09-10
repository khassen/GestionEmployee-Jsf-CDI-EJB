package fr.treeptik.dao;

import java.util.List;

import fr.treeptik.Exception.DAOException;



	public interface GenericDAO<T, PK> {

		T save(T entite) throws DAOException;
		T findById(PK id)throws DAOException;
		List<T> findAll() throws DAOException;
		void remove(PK id) throws DAOException;
		T update(T entite) throws DAOException;
	}

