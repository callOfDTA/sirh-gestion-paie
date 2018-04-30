package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
