package dev.paie.entite;

import java.time.LocalDateTime;

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
@Table(name = "employe")
public class RemunerationEmploye {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "MATRICULE", nullable = false, unique = true)
	private String matricule;

	@ManyToOne
	@JoinColumn(name = "ENTREPRISE_ID", nullable = false)
	private Entreprise entreprise;

	@ManyToOne
	@JoinColumn(name = "PROFIL_ID", nullable = false)
	private ProfilRemuneration profilRemuneration;

	@ManyToOne
	@JoinColumn(name = "GRADE_ID", nullable = false)
	private Grade grade;

	@Column(name = "HEURE_CREATION", nullable = false)
	private LocalDateTime heureCreation;

	@PrePersist
	private void heureDeCreation() {
		heureCreation = LocalDateTime.now();
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

	public LocalDateTime getHeureCreation() {
		return heureCreation;
	}

	public void setHeureCreation(LocalDateTime heureCreation) {
		this.heureCreation = heureCreation;
	}
}
