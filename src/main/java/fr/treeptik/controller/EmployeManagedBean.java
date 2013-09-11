package fr.treeptik.controller;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import fr.treeptik.model.Employe;
import fr.treeptik.service.EmployeService;

@ManagedBean(name="employeMB")
public class EmployeManagedBean {

    @Inject
    private FacesContext facesContext;

    @Inject
    private EmployeService employeService;


    
    private Employe employe;
    
    private ListDataModel<Employe> listDataModel;

//    comme un constructeur permet d'initialiser
    @PostConstruct
    public void init() {
        setEmploye(new Employe());
    }


    
    
	// j'ai ma liste qui s'affiche
	public ListDataModel<Employe> getEmployeList() throws Exception {
		listDataModel = new ListDataModel<Employe>(employeService.findAll());
		return listDataModel;
	}
    
	public String deleteEmploye() throws Exception {
		employe = listDataModel.getRowData();
		employeService.remove(employe.getId());
		return "listEmploye";

	}
	
	public String selectUpdate() throws Exception {

		employe = listDataModel.getRowData();
		return "updateEmploye";

	}
	
	
	
	public String updateEmploye() throws Exception{

		
		getEmployeService().update(employe);
		listDataModel = new ListDataModel<>();
		listDataModel.setWrappedData(employeService.findAll());

		return "listEmploye";

	}
	
	
    
    public String register() throws Exception {
        try {
            employeService.save(getEmploye());
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
            facesContext.addMessage(null, m);
            init();
        } catch (Exception e) {
            FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getLocalizedMessage(), "Registration unsuccessful");
            facesContext.addMessage(null, m);
        }
        return "listDepartment";
    }
    
    public String findAll() throws Exception{
    	listDataModel.setWrappedData(employeService.findAll());
    	return "listEmployes";
    }
    
 

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}


	public EmployeService getEmployeService() {
		return employeService;
	}


	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}


	public ListDataModel<Employe> getListDataModel() {
		return listDataModel;
	}


	public void setListDataModel(ListDataModel<Employe> listDataModel) {
		this.listDataModel = listDataModel;
	}

	
}
