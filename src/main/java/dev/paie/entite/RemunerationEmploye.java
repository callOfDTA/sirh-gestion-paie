package dev.paie.entite;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYE")
public class RemunerationEmploye {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	public ZonedDateTime getDatecreation() {
		return datecreation;
	}

	public void setDatecreation(ZonedDateTime datecreation) {
		this.datecreation = datecreation;
	}

	@Column(name = "MATRICULE", nullable = false, unique = true)
	private String matricule;

	@ManyToOne
	@JoinColumn(name = "ENTREPRISE_ID", nullable = false)
	private Entreprise entreprise;

	@ManyToOne
	@JoinColumn(name = "PROFIL_ID", nullable = false)
	private ProfilRemuneration profilRemuneration;

	@Column(name = "DATE_CREATION", nullable = false)
	private ZonedDateTime datecreation;

	@PrePersist
	private void heuredecreation() {
		datecreation = ZonedDateTime.now();
	}

	@ManyToOne
	@JoinColumn(name = "GRADE_ID", nullable = false)
	private Grade grade;

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
