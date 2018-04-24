package dev.paie.entite;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Cotisation")
public class Cotisation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "CODE", length = 10, nullable = false)
	private String code;
	@Column(name = "LIBELLE", length = 10, nullable = false)
	private String libelle;
	@Column(name = "TAUX_SALARIAL", precision = 6, scale=3, nullable = false)
	private BigDecimal tauxSalarial;
	@Column(name = "TAUX_PATRONAL", precision = 6, scale=3, nullable = false)
	private BigDecimal tauxPatronal;
	@Transient
	List<ProfilRemuneration>listeProfil;
	
	public Cotisation(){
		
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
	

}
