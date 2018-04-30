package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import dev.paie.entite.Grade;

public class GradeServiceJdbcTemplate implements GradeService {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO GRADE (ID, CODE, NBHEURESBASE, TAUXBASE) VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());

	}

	@Override
	public void mettreAJour(Grade grade) {
		String sqlUpdate = "UPDATE GRADE SET CODE = ?,NBHEURESBASE =?, TAUXBASE =?  WHERE ID = ? ";
		jdbcTemplate.update(sqlUpdate,grade.getCode(),grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());

	}

	@Override
	public List<Grade> lister() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM GRADE";
		return this.jdbcTemplate.query(sql, new GradeMapper());
	}

}
