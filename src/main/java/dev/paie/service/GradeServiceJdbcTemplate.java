package dev.paie.service;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.mapper.GradeMapper;

// TODO: Auto-generated Javadoc
/**
 * The Class GradeServiceJdbcTemplate.
 */
@Service
public class GradeServiceJdbcTemplate implements GradeService {

	/** The jdbc template. */
	private JdbcTemplate jdbcTemplate;

	/**
	 * Instantiates a new grade service jdbc template.
	 *
	 * @param dataSource
	 *            the data source
	 */
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/*
	 * Permet de sauvegarder un grade
	 */
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		// TODO Auto-generated method stub
		String sqlInsert = "INSERT INTO grade (code,nbHeuresBase,tauxBase) VALUES (?,?,?)";
		jdbcTemplate.update(sqlInsert, nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(),
				nouveauGrade.getTauxBase());
	}

	/*
	 * Permet de mettre a jour les grades
	 */
	@Override
	public void mettreAJour(Grade grade) {
		// TODO Auto-generated method stub
		String sqlUpdate = "UPDATE grade SET  code = ? , nbHeuresBase = ? , tauxBase = ? WHERE id= ?";
		jdbcTemplate.update(sqlUpdate, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());
	}

	/*
	 * Permet de lister les grades
	 */
	@Override
	public List<Grade> lister() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM grade";
		List<Grade> listeGrade = jdbcTemplate.query(sql, new GradeMapper());
		return listeGrade;
	}

}