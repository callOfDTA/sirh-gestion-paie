/**
 * 
 */
package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

/**
 * @author ETY9
 *
 */
@Service
public interface GradeService {
	void sauvegarder(Grade nouveauGrade);

	void mettreAJour(Grade grade);

	List<Grade> lister();
}
