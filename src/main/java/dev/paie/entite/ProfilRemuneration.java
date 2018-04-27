package dev.paie.entite;

import java.util.List;
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

// TODO: Auto-generated Javadoc
/**
 * The Class ProfilRemuneration.
 */
@Entity
@Table(name = "PROFILREMUNERATION")

public class ProfilRemuneration {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The code. */
	@Column(name = "code", nullable = false, unique = true)
	private String code;

	/** The cotisations non imposables. */
	@ManyToMany
	@JoinTable(name = "PR_NONIMP", joinColumns = @JoinColumn(name = "PR_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "COT_ID", referencedColumnName = "ID"))
	private Set<Cotisation> cotisationsNonImposables;

	/** The cotisations imposables. */
	@ManyToMany
	@JoinTable(name = "PR_IMP", joinColumns = @JoinColumn(name = "PR_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "COT_ID", referencedColumnName = "ID"))
	private Set<Cotisation> cotisationsImposables;

	/** The avantages. */
	@ManyToMany
	@JoinTable(name = "PR_AV", joinColumns = @JoinColumn(name = "PR_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "AV_ID", referencedColumnName = "ID"))
	private List<Avantage> avantages;

	/**
	 * Instantiates a new profil remuneration.
	 */
	public ProfilRemuneration() {
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
	 * Gets the cotisations non imposables.
	 *
	 * @return the cotisations non imposables
	 */
	public Set<Cotisation> getCotisationsNonImposables() {
		return cotisationsNonImposables;
	}

	/**
	 * Sets the cotisations non imposables.
	 *
	 * @param cotisationsNonImposables
	 *            the new cotisations non imposables
	 */
	public void setCotisationsNonImposables(Set<Cotisation> cotisationsNonImposables) {
		this.cotisationsNonImposables = cotisationsNonImposables;
	}

	/**
	 * Gets the cotisations imposables.
	 *
	 * @return the cotisations imposables
	 */
	public Set<Cotisation> getCotisationsImposables() {
		return cotisationsImposables;
	}

	/**
	 * Sets the cotisations imposables.
	 *
	 * @param cotisationsImposables
	 *            the new cotisations imposables
	 */
	public void setCotisationsImposables(Set<Cotisation> cotisationsImposables) {
		this.cotisationsImposables = cotisationsImposables;
	}

	/**
	 * Gets the avantages.
	 *
	 * @return the avantages
	 */
	public List<Avantage> getAvantages() {
		return avantages;
	}

	/**
	 * Sets the avantages.
	 *
	 * @param avantages
	 *            the new avantages
	 */
	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

}
