package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class BulletinSalaire.
 */
@Entity
@Table(name = "bulletinSalaire")
public class BulletinSalaire {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The remuneration employe. */
	@ManyToOne
	@JoinColumn(name = "EMPLOYE_ID", nullable = false)
	private RemunerationEmploye remunerationEmploye;

	/** The periode. */
	@ManyToOne
	@JoinColumn(name = "PERIODE_ID", nullable = false)
	private Periode periode;

	/** The prime exceptionnelle. */
	@Column(name = "primeExceptionnelle")
	private BigDecimal primeExceptionnelle;

	/**
	 * Instantiates a new bulletin salaire.
	 */
	public BulletinSalaire() {
	}

	/**
	 * Gets the remuneration employe.
	 *
	 * @return the remuneration employe
	 */
	public RemunerationEmploye getRemunerationEmploye() {
		return remunerationEmploye;
	}

	/**
	 * Sets the remuneration employe.
	 *
	 * @param remunerationEmploye
	 *            the new remuneration employe
	 */
	public void setRemunerationEmploye(RemunerationEmploye remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

	/**
	 * Gets the periode.
	 *
	 * @return the periode
	 */
	public Periode getPeriode() {
		return periode;
	}

	/**
	 * Sets the periode.
	 *
	 * @param periode
	 *            the new periode
	 */
	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	/**
	 * Gets the prime exceptionnelle.
	 *
	 * @return the prime exceptionnelle
	 */
	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	/**
	 * Sets the prime exceptionnelle.
	 *
	 * @param primeExceptionnelle
	 *            the new prime exceptionnelle
	 */
	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
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
