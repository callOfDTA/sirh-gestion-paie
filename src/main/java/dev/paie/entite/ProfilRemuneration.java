package dev.paie.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "profil_remuneration")
public class ProfilRemuneration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "code", nullable = false, unique = true)
	private String code;

	@ManyToMany
	@JoinTable(name = "cotisation_non_imposable", joinColumns = @JoinColumn(name = "ID_PROFIL_REMUNERATION", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COTISATION", referencedColumnName = "ID"))
	private List<Cotisation> cotisationsNonImposables;

	@ManyToMany
	@JoinTable(name = "cotisation_imposable", joinColumns = @JoinColumn(name = "ID_PROFIL_REMUNERATION", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COTISATION", referencedColumnName = "ID"))
	private List<Cotisation> cotisationsImposables;

	@ManyToMany
	@JoinTable(name = "avantage_appartenance", joinColumns = @JoinColumn(name = "ID_PROFIL_REMUNERATION", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_AVANTAGE", referencedColumnName = "ID"))
	private List<Avantage> avantages;

	public ProfilRemuneration() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(List<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public List<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(List<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
