package fr.afcepf.al32.web;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServiceAssociation;
import fr.afcepf.al32.service.ServiceAdministrateur;
import fr.afcepf.al32.service.ServiceAssociation;

@ManagedBean  
@SessionScoped
public class AssociationListeBean {
	
	@ManagedProperty("#{serviceAssociation}")	
	private IServiceAssociation serviceAssociation; 
	
	private List <Personne> listAssociations; //= new ArrayList<Personne>();
	
	private Personne selectedPersonne; //pour affichage liste
	
	@PostConstruct
	public void init() {
		String res = recupererTousLesAssociations();
		//serviceAssociation = new ServiceAssociation();		
	}
	
	

	public String recupererTousLesAssociations() {		
		String suite=null;
		listAssociations = serviceAssociation.rechercheAssociationValidee();
		//suite="ListeAssociations";
	    return suite;
	}

	public IServiceAssociation getServiceAssociation() {
		return serviceAssociation;
	}

	public void setServiceAssociation(IServiceAssociation serviceAssociation) {
		this.serviceAssociation = serviceAssociation;
	}

	public List<Personne> getListAssociations() {
		return listAssociations;
	}

	public void setListAssociations(List<Personne> listAssociations) {
		this.listAssociations = listAssociations;
	}

	public Personne getSelectedPersonne() {
		return selectedPersonne;
	}

	public void setSelectedPersonne(Personne selectedPersonne) {
		this.selectedPersonne = selectedPersonne;
	}
	
	
	
}
