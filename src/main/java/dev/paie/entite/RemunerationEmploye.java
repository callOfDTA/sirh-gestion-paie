package dev.paie.entite;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class RemunerationEmploye.
 */
@Entity
@Table(name = "EMPLOYE")
public class RemunerationEmploye {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	/** The matricule. */
	@Column(name = "MATRICULE", nullable = false, unique = true)
	private String matricule;

	/** The entreprise. */
	@ManyToOne
	@JoinColumn(name = "ENTREPRISE_ID", nullable = false)
	private Entreprise entreprise;

	/** The profil remuneration. */
	@ManyToOne
	@JoinColumn(name = "PROFIL_ID", nullable = false)
	private ProfilRemuneration profilRemuneration;

	/** The grade. */
	@ManyToOne
	@JoinColumn(name = "GRADE_ID", nullable = false)
	private Grade grade;

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
	 * Gets the matricule.
	 *
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Sets the matricule.
	 *
	 * @param matricule
	 *            the new matricule
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * Gets the entreprise.
	 *
	 * @return the entreprise
	 */
	public Entreprise getEntreprise() {
		return entreprise;
	}

	/**
	 * Sets the entreprise.
	 *
	 * @param entreprise
	 *            the new entreprise
	 */
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	/**
	 * Gets the profil remuneration.
	 *
	 * @return the profil remuneration
	 */
	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	/**
	 * Sets the profil remuneration.
	 *
	 * @param profilRemuneration
	 *            the new profil remuneration
	 */
	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	/**
	 * Gets the grade.
	 *
	 * @return the grade
	 */
	public Grade getGrade() {
		return grade;
	}

	/**
	 * Sets the grade.
	 *
	 * @param grade
	 *            the new grade
	 */
	public void setGrade(Grade grade) {
		this.grade = grade;
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
