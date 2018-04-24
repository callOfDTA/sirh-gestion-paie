package dev.paie.entite;

import java.math.BigDecimal;

public class Grade {

	private Integer id;
	private String code;
	private BigDecimal nbHeuresBase;
	private BigDecimal tauxBase;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getNbHeuresBase() {
		return nbHeuresBase;
	}

	public void setNbHeuresBase(BigDecimal nbHeuresBase) {
		this.nbHeuresBase = nbHeuresBase;
	}

	public BigDecimal getTauxBase() {
		return tauxBase;
	}

	public void setTauxBase(BigDecimal tauxBase) {
		this.tauxBase = tauxBase;
	}

	public Integer getId() {
		return id;
	}

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
		if (this.code.equals(g.getCode()) && this.nbHeuresBase.doubleValue() == g.getNbHeuresBase().doubleValue() && this.tauxBase.doubleValue() == g.getTauxBase().doubleValue())
			return true;
		return false;
	}

}
