package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AVANTAGE")
public class Avantage {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="montant")
	private BigDecimal montant;

	public Avantage(){}
	/**
	 * @param code
	 * @param nom
	 * @param montant
	 */
	public Avantage(String code, String nom, BigDecimal montant) {
		super();
		this.code = code;
		this.nom = nom;
		this.montant = montant;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Avantage [code=" + code + ", nom=" + nom + ", montant=" + montant + "]";
	}
	
	
}
