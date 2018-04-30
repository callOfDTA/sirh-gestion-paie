/**
 * 
 */
package dev.paie.listener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.PrePersist;

import dev.paie.entite.BulletinSalaire;

/**
 * @author ETY9
 *
 */
public class BulletinListener {
	@PrePersist
	public void employePrePersist(BulletinSalaire bulletin) {
		LocalDateTime dateCrea = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formatDateCrea = dateCrea.format(formatter);
		bulletin.setDateCreation(formatDateCrea);
	}
}
