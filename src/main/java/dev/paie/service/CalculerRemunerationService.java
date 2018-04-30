package dev.paie.service;

import java.util.Map;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.ResultatCalculRemuneration;

public interface CalculerRemunerationService {
	ResultatCalculRemuneration calculer(BulletinSalaire bulletin);

	public Map<BulletinSalaire, ResultatCalculRemuneration> calculerTousLesBulletin();
}
