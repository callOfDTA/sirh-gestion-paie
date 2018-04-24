package dev.paie.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Grade;

public class CotisationMapper implements RowMapper<Cotisation>{

	@Override
	public Cotisation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Cotisation newcotisation = new Cotisation();
		newcotisation.setId(rs.getInt("ID"));
		newcotisation.setCode(rs.getString("CODE"));
		newcotisation.setLibelle(rs.getString("Libelle"));
		newcotisation.setTauxPatronal(rs.getBigDecimal("TAUX_PATRONAL"));
		newcotisation.setTauxSalarial(rs.getBigDecimal("TAUX_SALARIAL"));
		
		return newcotisation ;
	}

}
