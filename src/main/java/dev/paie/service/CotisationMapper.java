package dev.paie.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Cotisation;

public class CotisationMapper implements RowMapper<Cotisation> {
	public Cotisation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cotisation cot = new Cotisation();
		cot.setId(rs.getInt("ID"));
		cot.setCode(rs.getString("CODE"));
		cot.setLibelle(rs.getString("LIBELLE"));
		cot.setTauxPatronal(rs.getBigDecimal("TAUX_PATRONAL"));
		cot.setTauxSalarial(rs.getBigDecimal("TAUX_SALARIAL"));
		return cot;
	}
}
