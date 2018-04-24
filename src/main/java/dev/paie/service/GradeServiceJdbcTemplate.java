package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.service.mapper.GradeMapper;
@Service
public class GradeServiceJdbcTemplate implements GradeService {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO GRADE (CODE,NB_HEURES_BASE,TAUX_BASE) VALUES(?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
		
	}

	@Override
	public void mettreAJour(Grade grade) {
		String sqlUpdate = "UPDATE GRADE SET CODE = ? WHERE ID = ? ";
		jdbcTemplate.update(sqlUpdate,grade.getCode(), grade.getId());
		
	}

	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM GRADE";
		List<Grade> grades = jdbcTemplate.query(sql, new GradeMapper());
		return grades;
	}
}
