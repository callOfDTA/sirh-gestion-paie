package dev.paie.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Utilisateur")
public class Utilisateur {
	public enum ROLES {
		ROLE_ADMINISTRATEUR, ROLE_UTILISATEUR
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "NOM_UTILISATEUR", nullable = false, unique = true)
	private String nomUtilisateur;
	@Column(name = "MOT_DE_PASSE", nullable = false)
	private String motDePasse;
	@Column(name = "EST_ACTIF")
	private Boolean estActif;
	@Enumerated(EnumType.STRING)
	@Column(name = "ROLE", nullable = false)
	private ROLES role;

	public Utilisateur() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getEstActif() {
		return estActif;
	}

	public void setEstActif(Boolean estActif) {
		this.estActif = estActif;
	}

	public ROLES getRole() {
		return role;
	}

	public void setRole(ROLES role) {
		this.role = role;
	}

}
