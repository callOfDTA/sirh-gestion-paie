package dev.paie.entite;

import java.util.ArrayList;
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
@Table(name = "ProfilRemuneration")
public class ProfilRemuneration {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "CODE", nullable = false, unique = true)
	private String code;
	@ManyToMany
	@JoinTable(name = "compoNonImposable", joinColumns = @JoinColumn(name = "ID_PROF_REM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COT", referencedColumnName = "ID"))
	private List<Cotisation> cotisationsNonImposables;
	@ManyToMany
	@JoinTable(name = "compoImposable", joinColumns = @JoinColumn(name = "ID_PROF_REM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_COT", referencedColumnName = "ID"))
	private List<Cotisation> cotisationsImposables;
	@ManyToMany
	@JoinTable(name = "compoAvantage", joinColumns = @JoinColumn(name = "ID_PROF_REM", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "ID_AVAN", referencedColumnName = "ID"))
	private List<Avantage> avantages;

	public ProfilRemuneration() {
		cotisationsNonImposables = new ArrayList<Cotisation>();
		cotisationsImposables = new ArrayList<Cotisation>();
		avantages = new ArrayList<Avantage>();
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
