/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.BulletinSalaire;

/**
 * @author ETY9
 *
 */
public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire, Integer> {
	@EntityGraph(value = "BulletinSalaire.AvecCotisations", type = EntityGraphType.LOAD)
	BulletinSalaire findById(Integer id);
}
