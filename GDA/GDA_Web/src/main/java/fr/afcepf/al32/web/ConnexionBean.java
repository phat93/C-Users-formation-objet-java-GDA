package fr.afcepf.al32.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import fr.afcepf.al32.entity.Administrateur;
import fr.afcepf.al32.entity.Association;
import fr.afcepf.al32.entity.Donateur;
import fr.afcepf.al32.entity.Personne;
import fr.afcepf.al32.service.IServiceAdministrateur;
import fr.afcepf.al32.service.IServiceAssociation;
import fr.afcepf.al32.service.IServiceDonateur;
import fr.afcepf.al32.service.ServiceAdministrateur;

@ManagedBean
@SessionScoped 
public class ConnexionBean 
{
	private String login;
	private String password;

	@ManagedProperty("#{serviceAdministrateur}")
	private IServiceAdministrateur serviceAdministrateur;
	
	@ManagedProperty("#{serviceDonateur}") //#{nomComposantJsfOuSpring} //nomClasseJava avec minuscule au debut
	private IServiceDonateur serviceDonateur;//avec get?/set
	
	@ManagedProperty("#{serviceAssociation}") //#{nomComposantJsfOuSpring} //nomClasseJava avec minuscule au debut
	private IServiceAssociation serviceAssociation;//avec get?/set
	
	@PostConstruct
	public void Init()
	{
		
	}
	
	public String login(String page)
	{
		//Personne p =null;
		String suite = null;
		switch (page) 
		{
		case "admin":
			Personne p = serviceAdministrateur.rechercherParConnexion(login, password);
			if(p != null)
			{
				if(p != null && p instanceof Administrateur)
				{
					suite="AdminOK";
				}
			}
			break;
			
		case "association":
			Personne p2 = serviceAssociation.rechercherParConnexion(login, password);
			if(p2 != null && p2 instanceof Association)
			{
				suite="AssosOK";
			}
			break;

		default:
			Personne p3 = serviceDonateur.rechercherParConnexion(login, password);
			if(p3 != null && p3 instanceof Donateur)
			{
				suite="DonateurOK";
			}
			break;
		}
		return suite;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public IServiceAdministrateur getServiceAdministrateur() {
		return serviceAdministrateur;
	}

	public void setServiceAdministrateur(IServiceAdministrateur serviceAdministrateur) {
		this.serviceAdministrateur = serviceAdministrateur;
	}

	public IServiceDonateur getServiceDonateur() {
		return serviceDonateur;
	}

	public void setServiceDonateur(IServiceDonateur serviceDonateur) {
		this.serviceDonateur = serviceDonateur;
	}

	public IServiceAssociation getServiceAssociation() {
		return serviceAssociation;
	}

	public void setServiceAssociation(IServiceAssociation serviceAssociation) {
		this.serviceAssociation = serviceAssociation;
	}

}
