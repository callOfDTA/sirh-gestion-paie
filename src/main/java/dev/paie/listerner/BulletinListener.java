package dev.paie.listerner;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.PrePersist;

import dev.paie.entite.BulletinSalaire;

public class BulletinListener {
	@PrePersist
	public void bulletinPrePersist(BulletinSalaire bulletin) {
		LocalDateTime dateCrea = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formatDateCrea = dateCrea.format(formatter);
		bulletin.setDateCreation(formatDateCrea);
	}
}