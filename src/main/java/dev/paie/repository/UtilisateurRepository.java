/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Utilisateur;

/**
 * @author ETY9
 *
 */
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

}
