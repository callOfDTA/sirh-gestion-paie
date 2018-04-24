package dev.paie.service;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dev.paie.entite.Grade;

public class GradeMapper implements RowMapper<Grade> {

	@Override
	public Grade mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Grade g= new Grade();
		g.setId(rs.getInt("ID"));
		g.setCode(rs.getString("CODE"));
		g.setNbHeuresBase(BigDecimal.valueOf(rs.getFloat("nbHeuresBase")));
		g.setTauxBase(BigDecimal.valueOf(rs.getFloat("tauxBase")));
		return g;
	}

}
