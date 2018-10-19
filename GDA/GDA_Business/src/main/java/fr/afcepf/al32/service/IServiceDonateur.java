package fr.afcepf.al32.service;

import java.util.List;

import fr.afcepf.al32.entity.Don;
import fr.afcepf.al32.entity.Personne;

public interface IServiceDonateur {
	void ajouterModifierDonateur(Personne p);
	void supprimerDonateur(Long  num);
	Personne rechercheDonateur(Long num);
	Personne rechercherParConnexion(String login, String password);
	
}
