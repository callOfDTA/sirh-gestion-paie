package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import dev.paie.listener.EmployeListener;

@Entity
@EntityListeners(EmployeListener.class)

@Table(name = "remuneration_employe")
public class RemunerationEmploye {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "matricule", nullable = false, unique = true)
	private String matricule;

	@ManyToOne
	@JoinColumn(name = "ID_ENTREPRISE", nullable = false)
	private Entreprise entreprise;

	@ManyToOne
	@JoinColumn(name = "ID_PROFIL_REMUNERATION", nullable = false)
	private ProfilRemuneration profilRemuneration;

	@ManyToOne
	@JoinColumn(name = "ID_GRADE", nullable = false)
	private Grade grade;

	@Column(name = "date_creation", nullable = false)
	String dateCreation;

	public RemunerationEmploye() {

	}

	/**
	 * @return the dateCreation
	 */
	public String getDateCreation() {
		return dateCreation;
	}

	/**
	 * @param dateCreation
	 *            the dateCreation to set
	 */
	public void setDateCreation(String dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public ProfilRemuneration getProfilRemuneration() {
		return profilRemuneration;
	}

	public void setProfilRemuneration(ProfilRemuneration profilRemuneration) {
		this.profilRemuneration = profilRemuneration;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
