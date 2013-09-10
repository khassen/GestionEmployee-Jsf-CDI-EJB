package fr.treeptik.service.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import fr.treeptik.dao.EmployeDAO;
import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;

@Stateless
public class EmployeServiceImpl extends GenericServiceImpl<Employe, Integer, EmployeDAO> implements EmployeService {

//    @Inject
//    private Logger log;

    @Inject
    private EmployeDAO dao;
    


	@Override
	protected EmployeDAO getDAO() {
		
		return dao;
	}
}
