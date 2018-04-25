package dev.paie.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Grade;

public class GradeMapper implements RowMapper<Grade>{

	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		Grade newgrade = new Grade();
		newgrade.setId(rs.getInt("ID"));
		newgrade.setCode(rs.getString("CODE"));
		newgrade.setNbHeuresBase(rs.getBigDecimal("NB_HEURES_BASE"));
		newgrade.setTauxBase(rs.getBigDecimal("TAUX_DE_BASE"));
		
		return newgrade;
	}

}
