package dev.paie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.paie.entite.Grade;

/**
 * The Interface GradeRepository.
 */
public interface GradeRepository extends JpaRepository<Grade, Integer> {

}
