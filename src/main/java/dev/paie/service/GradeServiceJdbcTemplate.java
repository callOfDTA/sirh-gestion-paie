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
	 * @param dataSource the data source
	 */
	@Autowired
	public GradeServiceJdbcTemplate(DataSource dataSource) {
		super();
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	// TODO

	/* (non-Javadoc)
	 * @see dev.paie.service.GradeService#sauvegarder(dev.paie.entite.Grade)
	 */
	@Override
	public void sauvegarder(Grade nouveauGrade) {
		String sql = "INSERT INTO grade (code, nbHeuresBase, tauxBase) VALUES(?,?,?)";;
		jdbcTemplate.update(sql,  nouveauGrade.getCode(), nouveauGrade.getNbHeuresBase(), nouveauGrade.getTauxBase());
	}

	/* (non-Javadoc)
	 * @see dev.paie.service.GradeService#mettreAJour(dev.paie.entite.Grade)
	 */
	@Override
	public void mettreAJour(Grade grade) {
		String sql = "UPDATE grade SET code = ?, nbHeuresBase = ?, tauxBase = ? WHERE id = ?";
		jdbcTemplate.update(sql, grade.getCode(), grade.getNbHeuresBase(), grade.getTauxBase(), grade.getId());
	}

	/* (non-Javadoc)
	 * @see dev.paie.service.GradeService#lister()
	 */
	@Override
	public List<Grade> lister() {
		String sql = "SELECT * FROM grade";
		List<Grade> grades = jdbcTemplate.query(sql, new GradeMapper());
		return grades;
	}
}