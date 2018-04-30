package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Cotisation.
 */
@Entity
@Table(name = "COTISATION")
public class Cotisation {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The code. */
	@Column(name = "CODE", nullable = false, unique = true)
	private String code;

	/** The libelle. */
	@Column(name = "LIBELLE", nullable = false)
	private String libelle;

	/** The taux salarial. */
	@Column(name = "TX_SALARIAL")
	private BigDecimal tauxSalarial;

	/** The taux patronal. */
	@Column(name = "TX_PATRONAL")
	private BigDecimal tauxPatronal;

	/**
	 * Instantiates a new cotisation.
	 */
	public Cotisation() {
	}

	/**
	 * Instantiates a new cotisation.
	 *
	 * @param code
	 *            the code
	 * @param libelle
	 *            the libelle
	 * @param tauxSalarial
	 *            the taux salarial
	 * @param tauxPatronal
	 *            the taux patronal
	 */
	public Cotisation(String code, String libelle, BigDecimal tauxSalarial, BigDecimal tauxPatronal) {
		this.code = code;
		this.libelle = libelle;
		this.tauxSalarial = tauxSalarial;
		this.tauxPatronal = tauxPatronal;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the libelle.
	 *
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Sets the libelle.
	 *
	 * @param libelle
	 *            the new libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Gets the taux salarial.
	 *
	 * @return the taux salarial
	 */
	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}

	/**
	 * Sets the taux salarial.
	 *
	 * @param tauxSalarial
	 *            the new taux salarial
	 */
	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}

	/**
	 * Gets the taux patronal.
	 *
	 * @return the taux patronal
	 */
	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}

	/**
	 * Sets the taux patronal.
	 *
	 * @param tauxPatronal
	 *            the new taux patronal
	 */
	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
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
