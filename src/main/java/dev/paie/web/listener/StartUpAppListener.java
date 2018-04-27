package dev.paie.web.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.paie.service.InitialiserDonneesService;

// TODO: Auto-generated Javadoc
/**
 * The listener interface for receiving startUpApp events.
 * The class that is interested in processing a startUpApp
 * event implements this interface, and the object created
 * with that class is registered with a component using the
 * component's <code>addStartUpAppListener<code> method. When
 * the startUpApp event occurs, that object's appropriate
 * method is invoked.
 *
 * @see StartUpAppEvent
 */
@Component
public class StartUpAppListener {

	/** The init service. */
	@Autowired
	private InitialiserDonneesService initService;

	/**
	 * Context refreshed event.
	 */
	@EventListener(ContextRefreshedEvent.class)
	public void contextRefreshedEvent() {
		// capture du démarrage de l'application
		// à un moment où le contexte Spring est complètement créé
		// initService.initialiser();
	}
}