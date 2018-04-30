package dev.paie.service;

import java.util.List;

import dev.paie.entite.Entreprise;

public interface EntrepriseService {
	void sauvegarder(Entreprise nouvelleEntreprise);

	void mettreAJour(Entreprise Entreprise);

	List<Entreprise> lister();

}
