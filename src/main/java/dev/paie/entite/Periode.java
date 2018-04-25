package dev.paie.entite;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Periode.
 */
@Entity
@Table(name = "PERIODE")
public class Periode {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The date debut. */
	@Column(name = "dateDebut", nullable = false)
	private LocalDate dateDebut;

	/** The date fin. */
	@Column(name = "dateFin", nullable = false)
	private LocalDate dateFin;

	/**
	 * @param dateDebut
	 * @param dateFin
	 */
	public Periode(LocalDate dateDebut, LocalDate dateFin) {
		super();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}

	/**
	 * Instantiates a new periode.
	 */
	public Periode() {
	}

	/**
	 * Gets the date debut.
	 *
	 * @return the date debut
	 */
	public LocalDate getDateDebut() {
		return dateDebut;
	}

	/**
	 * Sets the date debut.
	 *
	 * @param dateDebut
	 *            the new date debut
	 */
	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	/**
	 * Gets the date fin.
	 *
	 * @return the date fin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}

	/**
	 * Sets the date fin.
	 *
	 * @param dateFin
	 *            the new date fin
	 */
	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
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
