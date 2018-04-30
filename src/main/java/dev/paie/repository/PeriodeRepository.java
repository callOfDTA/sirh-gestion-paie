/**
 * 
 */
package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Periode;

/**
 * @author ETY9
 *
 */
public interface PeriodeRepository extends JpaRepository<Periode, Integer> {

}
