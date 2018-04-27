package dev.paie.util;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// TODO: Auto-generated Javadoc
/**
 * The Class PaieUtilsTest.
 */
@Generated(value = "org.junit-tools-1.0.6")
public class PaieUtilsTest {

	/** The paie utils. */
	private PaieUtils paieUtils;
	
	/** The context. */
	private ClassPathXmlApplicationContext context;

	/**
	 * On setup.
	 */
	@Before
	public void onSetup() {
		context = new ClassPathXmlApplicationContext("app-config.xml");
		paieUtils = context.getBean(PaieUtils.class);
	}

	/**
	 * Test formater big decimal entier positif.
	 */
	@Test
	public void test_formaterBigDecimal_entier_positif() {
		String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2"));
		assertThat(resultat, equalTo("2.00"));
	}

	/**
	 * Test formater big decimal trois chiffres apres la virgule.
	 */
	@Test
	public void test_formaterBigDecimal_trois_chiffres_apres_la_virgule() {
		String resultat = paieUtils.formaterBigDecimal(new BigDecimal("2.199"));
		assertThat(resultat, equalTo("2.20"));
	}

	/**
	 * Test formater big decimal entier negatif.
	 */
	@Test
	public void test_formaterBigDecimal_entier_negatif() {
		String resultat = paieUtils.formaterBigDecimal(new BigDecimal("-3"));
		assertThat(resultat, equalTo("-3.00"));
	}
	
	/**
	 * On exit.
	 */
	@After
	public void onExit() {
		context.close();	}
}