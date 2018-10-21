package fr.afcepf.al32.web;

import java.sql.Timestamp;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.service.IServiceAdministrateur;
import fr.afcepf.al32.service.IServicePack;


@ManagedBean 
@RequestScoped 
public class ListePacksAssociationBean {
	
	@ManagedProperty(value ="#{servicePackImpl}") //#{nomComposantJsfOuSpring} //nomClasseJava avec minuscule au debut
	private IServicePack servicePack;
	private List<PackAssociation> packs;

	 

	//la personne connectée
	private ConnexionBean personne;
	
	
	
//	@PostConstruct
//	public void Init()
//	{
//		
//	}
	
	@PostConstruct
	public void init()
	{		
		//System.out.println("Id asso connecte :" + selectedPack.getId());
		//packs = servicePack.rechercherPackAssociationParAssociation(selectedPack.getId());
		packs = servicePack.rechercherPackAssociationParAssociation(10L);
		
		System.out.println("taille packs: " + packs.size());
		System.out.println("contenue: " + packs.toString());
	}

	public String supprimerPack()
	{
		String suite=null;	
		servicePack.desactiverPack(13L);
		return suite;
	}

	public IServicePack getServicePack() {
		return servicePack;
	}



	public void setServicePack(IServicePack servicePack) {
		this.servicePack = servicePack;
	}



	public List<PackAssociation> getPacks() {
		return packs;
	}



	public void setPacks(List<PackAssociation> packs) {
		this.packs = packs;
	}


	public ConnexionBean getPersonne() {
		return personne;
	}

	public void setPersonne(ConnexionBean personne) {
		this.personne = personne;
	}





}

	
	
	

