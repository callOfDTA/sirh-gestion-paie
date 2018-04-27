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
 * The Class Avantage.
 */
@Entity
@Table(name = "AVANTAGE")
public class Avantage {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The code. */
	@Column(name = "CODE", nullable = false, unique = true)
	private String code;

	/** The nom. */
	@Column(name = "NOM", nullable = false)
	private String nom;

	/** The montant. */
	@Column(name = "MONTANT", nullable = false)
	private BigDecimal montant;

	/**
	 * Instantiates a new avantage.
	 */
	public Avantage() {
	}

	/**
	 * Instantiates a new avantage.
	 *
	 * @param code
	 *            the code
	 * @param nom
	 *            the nom
	 * @param montant
	 *            the montant
	 */
	public Avantage(String code, String nom, BigDecimal montant) {
		this.code = code;
		this.nom = nom;
		this.montant = montant;
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
	 * Gets the nom.
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Sets the nom.
	 *
	 * @param nom
	 *            the new nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Gets the montant.
	 *
	 * @return the montant
	 */
	public BigDecimal getMontant() {
		return montant;
	}

	/**
	 * Sets the montant.
	 *
	 * @param montant
	 *            the new montant
	 */
	public void setMontant(BigDecimal montant) {
		this.montant = montant;
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
		return "Avantage [id=" + id + ", code=" + code + ", nom=" + nom + ", montant=" + montant + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Avantage a = (Avantage) obj;

		if (this.code.equals(a.getCode()) && this.nom.equals(a.getNom())
				&& this.montant.doubleValue() == a.getMontant().doubleValue())
			return true;
		return false;
	}
}
