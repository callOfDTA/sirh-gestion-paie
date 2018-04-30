package dev.paie.entite;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "ProfilRemuneration")
public class ProfilRemuneration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "CODE", nullable = false, unique = true)
	private String code;
	@ManyToMany
	@JoinTable(name = "compoNonImposable", joinColumns = @JoinColumn(name = "ID_PROF_REM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COT", referencedColumnName = "ID"))
	private Set<Cotisation> cotisationsNonImposables;
	@ManyToMany
	@JoinTable(name = "compoImposable", joinColumns = @JoinColumn(name = "ID_PROF_REM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COT", referencedColumnName = "ID"))
	private Set<Cotisation> cotisationsImposables;
	@ManyToMany
	@JoinTable(name = "compoAvantage", joinColumns = @JoinColumn(name = "ID_PROF_REM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_AVAN", referencedColumnName = "ID"))
	private Set<Avantage> avantages;

	public ProfilRemuneration() {
		cotisationsNonImposables = new HashSet<Cotisation>();
		cotisationsImposables = new HashSet<Cotisation>();
		avantages = new HashSet<Avantage>();
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

	public Set<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	public void setCotisationsNonImposables(Set<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	public Set<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	public void setCotisationsImposables(Set<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	public Set<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(Set<Avantage> avantages) {
		this.avantages = avantages;
	}

}
