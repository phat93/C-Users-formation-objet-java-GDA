package fr.afcepf.al32.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServiceAssociation;

@ManagedBean
@RequestScoped 
public class AssociationBean 
{

	private List<Personne> associationsActives;
	private List<Personne> associationNouvelles;

	@ManagedProperty("#{serviceAssociation}") //#{nomComposantJsfOuSpring} //nomClasseJava avec minuscule au debut
	private IServiceAssociation serviceAssociation;//avec get?/set

	@PostConstruct
	public void Init()
	{
		associationsActives = serviceAssociation.rechercheAssociationValidee();
		associationNouvelles = serviceAssociation.rechercheAssociationNouvelle();
	}
	
	public void accepterAssociation()
	{
			
		
	}
	
	public void supprimerAssociation()
	{
			
		
	}

	public List<Personne> getAssociationsActives() {
		return associationsActives;
	}

	public void setAssociationsActives(List<Personne> associationsActives) {
		this.associationsActives = associationsActives;
	}

	public List<Personne> getAssociationNouvelles() {
		return associationNouvelles;
	}

	public void setAssociationNouvelles(List<Personne> associationNouvelles) {
		this.associationNouvelles = associationNouvelles;
	}

	public IServiceAssociation getServiceAssociation() {
		return serviceAssociation;
	}

	public void setServiceAssociation(IServiceAssociation serviceAssociation) {
		this.serviceAssociation = serviceAssociation;
	}

}
