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
 * The Class BulletinSalaire.
 */
@Entity
@Table(name = "BULLETIN_SALAIRE")
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
	@Column(name = "PRIME_EXCEPTIONNELLE")
	private BigDecimal primeExceptionnelle;

	/** The date creation. */
	@Column(name = "DATE_CREATION", nullable = false)
	private ZonedDateTime dateCreation;

	/**
	 * Gets the date creation libelle.
	 *
	 * @return the date creation libelle
	 */
	public String getDateCreationLibelle() {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy  hh:mm:ss");
		return this.dateCreation.format(format);
	}

	/**
	 * Gets the date creation.
	 *
	 * @return the date creation
	 */
	public ZonedDateTime getDateCreation() {
		return this.dateCreation;
	}

	/**
	 * Sets the date creation.
	 */
	@PrePersist
	private void setDateCreation() {
		this.dateCreation = ZonedDateTime.now();

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
