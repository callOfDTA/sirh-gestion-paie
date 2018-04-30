package dev.paie.service;

import java.util.List;

import dev.paie.entite.Grade;

// TODO: Auto-generated Javadoc
/**
 * The Interface GradeService.
 */
public interface GradeService {
	
	/**
	 * Sauvegarder.
	 *
	 * @param nouveauGrade the nouveau grade
	 */
	void sauvegarder(Grade nouveauGrade);

	/**
	 * Mettre A jour.
	 *
	 * @param grade the grade
	 */
	void mettreAJour(Grade grade);

	/**
	 * Lister.
	 *
	 * @return the list
	 */
	List<Grade> lister();
}