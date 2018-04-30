package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Entreprise.
 */
@Entity
@Table(name = "ENTREPRISE")
public class Entreprise {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The siret. */
	@Column(name = "siret", nullable = false, unique = true)
	private String siret;

	/** The denomination. */
	@Column(name = "denomination", nullable = false)
	private String denomination;

	/** The adresse. */
	@Column(name = "adresse")
	private String adresse;

	/** The urssaf. */
	@Column(name = "urssaf")
	private String urssaf;

	/** The code naf. */
	@Column(name = "codeNaf")
	private String codeNaf;

	/**
	 * Instantiates a new entreprise.
	 */
	public Entreprise() {
	}

	/**
	 * Gets the denomination.
	 *
	 * @return the denomination
	 */
	public String getDenomination() {
		return denomination;
	}

	/**
	 * Sets the denomination.
	 *
	 * @param denomination
	 *            the new denomination
	 */
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	/**
	 * Gets the adresse.
	 *
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Sets the adresse.
	 *
	 * @param adresse
	 *            the new adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Gets the siret.
	 *
	 * @return the siret
	 */
	public String getSiret() {
		return siret;
	}

	/**
	 * Sets the siret.
	 *
	 * @param siret
	 *            the new siret
	 */
	public void setSiret(String siret) {
		this.siret = siret;
	}

	/**
	 * Gets the urssaf.
	 *
	 * @return the urssaf
	 */
	public String getUrssaf() {
		return urssaf;
	}

	/**
	 * Sets the urssaf.
	 *
	 * @param urssaf
	 *            the new urssaf
	 */
	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}

	/**
	 * Gets the code naf.
	 *
	 * @return the code naf
	 */
	public String getCodeNaf() {
		return codeNaf;
	}

	/**
	 * Sets the code naf.
	 *
	 * @param codeNaf
	 *            the new code naf
	 */
	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
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

}
