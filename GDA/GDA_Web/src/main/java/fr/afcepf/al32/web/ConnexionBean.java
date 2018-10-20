package fr.afcepf.al32.web;

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

@ManagedBean
@SessionScoped 
public class ConnexionBean 
{
	private String login;
	private String password;
	private String msg;
	
	private Personne utilisateur;

	@ManagedProperty("#{serviceAdministrateur}")
	private IServiceAdministrateur serviceAdministrateur;
	
	@ManagedProperty("#{serviceDonateur}") //#{nomComposantJsfOuSpring} //nomClasseJava avec minuscule au debut
	private IServiceDonateur serviceDonateur;//avec get?/set
	
	@ManagedProperty("#{serviceAssociation}") //#{nomComposantJsfOuSpring} //nomClasseJava avec minuscule au debut
	private IServiceAssociation serviceAssociation;//avec get?/set

	
	public String login()
	{
		Personne p = serviceAdministrateur.rechercherParConnexion(login, password);
		String suite = null;
		 
		if(p != null)
		{
			if(p instanceof Donateur)
			{
				
				utilisateur = (Donateur) p;
				suite="accueilDonateur";
				
			}
			else if(p instanceof Association)
			{
				utilisateur = (Association) p;
				suite="accueilAssociation";
			}
			else
			{
				utilisateur = (Administrateur) p;
				suite="accueilAdmin";
			}
			
		}
		else
		{
			msg = "Identifiant et/ou Mot de Passe incorrecte";
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

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Personne getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Personne utilisateur) {
		this.utilisateur = utilisateur;
	}

}
