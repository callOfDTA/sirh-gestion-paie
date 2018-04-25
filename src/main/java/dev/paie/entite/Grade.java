package dev.paie.entite;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Grade.
 */
@Entity
@Table(name="GRADE")
public class Grade {

	/** The id. */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	/** The code. */
	@Column(name="code", nullable=false)
	private String code;

	/** The nb heures base. */
	@Column(name="nbHeuresBase" , nullable=false)
	private BigDecimal nbHeuresBase;

	/** The taux base. */
	@Column(name="tauxBase", nullable=false)
	private BigDecimal tauxBase;

	public Grade() {
	}

	/**
	 * Instantiates a new grade.
	 *
	 * @param id
	 *            the id
	 * @param code
	 *            the code
	 * @param nbHeuresBase
	 *            the nb heures base
	 * @param tauxBase
	 *            the taux base
	 */
	public Grade(Integer id, String code, BigDecimal nbHeuresBase, BigDecimal tauxBase) {
		super();
		this.id = id;
		this.code = code;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
	}

	/**
	 * Instantiates a new grade.
	 *
	 * @param code
	 *            the code
	 * @param nbHeuresBase
	 *            the nb heures base
	 * @param tauxBase
	 *            the taux base
	 */
	public Grade(String code, BigDecimal nbHeuresBase, BigDecimal tauxBase) {
		super();
		this.code = code;
		this.nbHeuresBase = nbHeuresBase;
		this.tauxBase = tauxBase;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code
	 *            the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * Gets the nb heures base.
	 *
	 * @return the nb heures base
	 */
	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}

	/**
	 * Sets the nb heures base.
	 *
	 * @param nbHeuresBase
	 *            the new nb heures base
	 */
	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}

	/**
	 * Gets the taux base.
	 *
	 * @return the taux base
	 */
	public BigDecimal getTauxBase() {
		return tauxBase;
	}

	/**
	 * Sets the taux base.
	 *
	 * @param tauxBase
	 *            the new taux base
	 */
	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Grade [id=" + id + ", code=" + code + ", nbHeuresBase=" + nbHeuresBase + ", tauxBase=" + tauxBase + "]";
	}

	@Override
	public boolean equals(Object o) {
		Grade g = (Grade) o;

		if (this.getCode().equals(g.getCode()) && this.nbHeuresBase.doubleValue()==g.getNbHeuresBase().doubleValue()
				&& this.tauxBase.doubleValue()==g.getTauxBase().doubleValue())
			return true;
		
		return false;

	}

}
