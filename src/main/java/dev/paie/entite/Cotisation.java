package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COTISATION")
public class Cotisation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "CODE", nullable = false, unique = true)
	private String code;
	@Column(name = "LIBELLE", nullable = false)
	private String libelle;

	@Column(name = "TX_SALARIAL")
	private BigDecimal tauxSalarial = BigDecimal.valueOf(0.00);

	@Column(name = "TX_PATRONAL")
	private BigDecimal tauxPatronal = BigDecimal.valueOf(0.00);

	/**
	 * 
	 */
	public Cotisation() {
	}

	/**
	 * @param code
	 * @param libelle
	 * @param tauxSalarial
	 * @param tauxPatronal
	 * @param employes
	 */
	public Cotisation(String code, String libelle, BigDecimal tauxSalarial, BigDecimal tauxPatronal) {
		this.code = code;
		this.libelle = libelle;
		this.tauxSalarial = tauxSalarial;
		this.tauxPatronal = tauxPatronal;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cotisation [id=" + id + ", code=" + code + ", libelle=" + libelle + ", tauxSalarial=" + tauxSalarial
				+ ", tauxPatronal=" + tauxPatronal;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Cotisation c = (Cotisation) obj;

		if (this.code.equals(c.getCode()) && this.getLibelle().equals(c.getLibelle())
				&& this.tauxPatronal.doubleValue() == c.getTauxPatronal().doubleValue()
				&& this.tauxSalarial.doubleValue() == c.getTauxSalarial().doubleValue())
			return true;
		return false;
	}

}
