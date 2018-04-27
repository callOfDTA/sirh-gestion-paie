package dev.paie.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.BulletinSalaire;

// TODO: Auto-generated Javadoc
/**
 * The Interface BulletinSalaireRepository.
 */
public interface BulletinSalaireRepository extends JpaRepository<BulletinSalaire, Integer> {

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the bulletin salaire
	 */
	@EntityGraph(value = "BulletinSalaire.AvecCotisations", type = EntityGraphType.LOAD)
	BulletinSalaire findById(Integer id);

}
