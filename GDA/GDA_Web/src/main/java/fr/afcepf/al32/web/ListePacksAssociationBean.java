package fr.afcepf.al32.web;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.dom4j.bean.BeanAttribute;
import org.springframework.context.annotation.Bean;

import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Pack;
import fr.afcepf.al32.entity.PackAssociation;
import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServiceAssociation;
import fr.afcepf.al32.service.IServicePack;
import fr.afcepf.al32.service.IServicePersonne;


@ManagedBean 
@RequestScoped 
public class ListePacksAssociationBean {
	
	@ManagedProperty(value ="#{servicePackImpl}") //#{nomComposantJsfOuSpring} //nomClasseJava avec minuscule au debut
	private IServicePack servicePack;
	private List<PackAssociation> packs;
	/****/
	
	private String idAssociation;
	
	
	//private List<PackAssociation> packs;
	//la personne connectée
	private ConnexionBean personne;
	
	
	
//	@PostConstruct
//	public void Init()
//	{
//		
//	}
	
//	@PostConstruct
//	public void init() {
//	
//		packs = servicePack.rechercherPackAssociationParAssociation(id);
//		System.out.println("taille packs: " + packs.size());
//		System.out.println("contenue: " + packs.toString() );
//
//	}
	@PostConstruct
	public void init()
	{
		
		packs = servicePack.rechercherPackAssociationParAssociation(10L);
		
		System.out.println("taille packs: " + packs.size());
		System.out.println("contenue: " + packs.toString() );

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



	


	public String getIdAssociation() {
		return idAssociation;
	}



	public void setIdAssociation(String idAssociation) {
		this.idAssociation = idAssociation;
	}



	public ConnexionBean getPersonne() {
		return personne;
	}



	public void setPersonne(ConnexionBean personne) {
		this.personne = personne;
	}



}

	
	
	

