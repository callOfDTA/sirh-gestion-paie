package dev.paie.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * The Class JeuxDeDonneesConfig.
 */
//Marque un bean de configuration Spring
@Configuration
// Import de la configuration XML dans une configuration Java
@ImportResource("classpath:jdd-config.xml")
public class JeuxDeDonneesConfig {
}