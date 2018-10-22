package fr.afcepf.al32.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServiceDonateur;

@ManagedBean  
@RequestScoped
public class DonateurListeBean {
	
	@ManagedProperty("#{serviceDonateur}")	
	private IServiceDonateur serviceDonateur; 
	
	private List <Personne> listeDonateur;
	
	
	@PostConstruct
	public void init() {
		recupererTousLesAssociations();		
	}

	public void recupererTousLesAssociations() {		
		
		setListeDonateur(serviceDonateur.rechercheAllDonateur());
	}

	public List <Personne> getListeDonateur() {
		return listeDonateur;
	}

	public void setListeDonateur(List <Personne> listeDonateur) {
		this.listeDonateur = listeDonateur;
	}

	public IServiceDonateur getServiceDonateur() {
		return serviceDonateur;
	}

	public void setServiceDonateur(IServiceDonateur serviceDonateur) {
		this.serviceDonateur = serviceDonateur;
	}
	
	
}
