package dev.paie.entite;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.PrePersist;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class BulletinSalaire. L'utilisation de l'entity graph permet d'empecher
 * de mettre l'etat de entité en lazy
 */
@Entity
@Table(name = "bulletinSalaire")
@NamedEntityGraph(name = "BulletinSalaire.AvecCotisations", attributeNodes = {
		@NamedAttributeNode(value = "remunerationEmploye", subgraph = "RemunerationEmploye.AvecCotisations") }, subgraphs = {
				@NamedSubgraph(name = "RemunerationEmploye.AvecCotisations", attributeNodes = {
						@NamedAttributeNode(value = "profilRemuneration", subgraph = "ProfilRemuneration.AvecCotisations") }),
				@NamedSubgraph(name = "ProfilRemuneration.AvecCotisations", attributeNodes = {
						@NamedAttributeNode(value = "cotisationsNonImposables"),
						@NamedAttributeNode(value = "cotisationsImposables") }) })
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

	/** The date creation. */
	@Column(name = "dateCreation")
	private ZonedDateTime dateCreation;

	/**
	 * Instantiates a new bulletin salaire.
	 */
	public BulletinSalaire() {
	}

	/**
	 * Sets the date time creation.
	 */
	@PrePersist
	private void setDateTimeCreation() {
		this.dateCreation = ZonedDateTime.now();
	}

	/**
	 * Gets the date creation libelle.
	 *
	 * @return the date creation libelle
	 */
	public String getDateCreationLibelle() {
		return this.dateCreation.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	/**
	 * Gets the date creation.
	 *
	 * @return the dateCreation
	 */
	public ZonedDateTime getDateCreation() {

		return dateCreation;
	}

	/**
	 * Sets the date creation.
	 *
	 * @param dateCreation
	 *            the dateCreation to set
	 */
	public void setDateCreation(ZonedDateTime dateCreation) {
		this.dateCreation = dateCreation;
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
