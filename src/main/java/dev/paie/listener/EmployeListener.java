/**
 * 
 */
package dev.paie.listener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.PrePersist;

import dev.paie.entite.RemunerationEmploye;

/**
 * @author ETY9
 *
 */
public class EmployeListener {
	@PrePersist
	public void employePrePersist(RemunerationEmploye employe) {
		LocalDateTime dateCrea = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formatDateCrea = dateCrea.format(formatter);
		employe.setDateCreation(formatDateCrea);
	}
}
