package fr.afcepf.al32.web;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServiceAssociation;
import fr.afcepf.al32.service.ServiceAdministrateur;
import fr.afcepf.al32.service.ServiceAssociation;

@ManagedBean  
@RequestScoped
public class AssociationListeBean {
	
	@ManagedProperty("#{serviceAssociation}")	
	private IServiceAssociation serviceAssociation; 
	
	private List <Personne> listAssociations;
	
	private List<Personne> associationNouvelles;
	
	private Personne selectedPersonne; //pour affichage liste
	
	@PostConstruct
	public void init() {
		String res = recupererTousLesAssociations();		
	}

	public String recupererTousLesAssociations() {		
		String suite=null;
		listAssociations = serviceAssociation.rechercheAssociationValidee();
		associationNouvelles = serviceAssociation.rechercheAssociationNouvelle();
	    return suite;
	}
	
	public String accepterAssociation()
	{
		String suite=null;	
		serviceAssociation.accepterAssociation(selectedPersonne.getId(), new Timestamp( System.currentTimeMillis()));
		return suite;
	}
	
	public String supprimerAssociation()
	{
		String suite=null;	
		serviceAssociation.refuserAssociation(selectedPersonne.getId(), new Timestamp( System.currentTimeMillis()));
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
	
	public List<Personne> getAssociationNouvelles() {
		return associationNouvelles;
	}

	public void setAssociationNouvelles(List<Personne> associationNouvelles) {
		this.associationNouvelles = associationNouvelles;
	}

	
}
