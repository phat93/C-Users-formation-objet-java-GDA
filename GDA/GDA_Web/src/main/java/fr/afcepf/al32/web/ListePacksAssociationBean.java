package fr.afcepf.al32.web;

import java.util.List;

import javax.annotation.PostConstruct;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

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
	private List<Pack> packs;
	/****/
	
	private Long idAssociation= 8L;
	
	
	//private List<PackAssociation> packs;
	//la personne connectée
	private ConnexionBean personne;
	
	
	
//	@PostConstruct
//	public void Init()
//	{
//		
//	}
	
	@PostConstruct
	public void init() {
		
		packs = servicePack.rechercherPackAssociation();
		System.out.println("taille packs: " + packs.size());
		System.out.println("contenue: " + packs.toString() );

	}
//	public String AfficherListePack()
//	{
//		String suite=null;
//		//List<PackAssociation> packs = servicePack.rechercherPackAssociationParAssociation(8L);
//		//List<PackAssociation> packs = servicePack.rechercherPackAssociation();	
//		List<Personne> packs = servicePersonne.rechercheAssociationNouvelle();
//		suite="ListePacksAssociation";
//		System.out.println("taille : " + packs.size());
//		System.out.println("contenue: " + packs.toString() );
//		// pour naviguer vers comptes.jsf (.xhtml ou .jsp)
//		return suite; 
//		
//	}



	public IServicePack getServicePack() {
		return servicePack;
	}



	public void setServicePack(IServicePack servicePack) {
		this.servicePack = servicePack;
	}



	public List<Pack> getPacks() {
		return packs;
	}



	public void setPacks(List<Pack> packs) {
		this.packs = packs;
	}



	public Long getIdAssociation() {
		return idAssociation;
	}



	public void setIdAssociation(Long idAssociation) {
		this.idAssociation = idAssociation;
	}



	public ConnexionBean getPersonne() {
		return personne;
	}



	public void setPersonne(ConnexionBean personne) {
		this.personne = personne;
	}



}

	
	
	

