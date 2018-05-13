package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;

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
		String sql = "INSERT INTO grade (ID, CODE, NB_HEURES_BASE, TAUX_BASE) " + "VALUES(?,?,?,?)";
		jdbcTemplate.update(sql, nouveauGrade.getId(), nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(),
				nouveauGrade.getTauxBase());
	}

	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE grade SET CODE = ?, " + "NB_HEURES_BASE = ?, " + "TAUX_BASE = ? " + "WHERE ID = ?";
		jdbcTemplate.update(sql, grade.getId(), grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase());
	}

	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM grade";
		List<Grade> grade = jdbcTemplate.query(sql, new GradeMapper());
		return grade;
	}

}
