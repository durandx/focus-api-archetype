#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services.batch;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import io.vertigo.lang.Assertion;
import io.vertigo.lang.Option;
import io.vertigo.persona.security.UserSession;
import io.vertigo.persona.security.VSecurityManager;
import ${package}.user.${className}UserSession;

/**
 * Classe parente de tous les traitements non interactifs, job ou webservices offerts.
 *
 * @author jmforhan
 */
public abstract class Abstract${className}Job implements Runnable {

	@Inject
	private VSecurityManager vSecurityManager;
	private final Logger logger = Logger.getLogger(getClass());
	private ${className}UserSession session;

	/**
	 * Effectue le traitement du batch.
	 */
	@Override
	public final void run() {
		// Creation de la session avec l'utilisateur technique. On met la session en variable pour etre sur que l'on a
		// toujours une reference sur la session
		session = getBatchUserSession();
		Assertion.checkNotNull(session, "La session ne peut etre nulle.");
		doRun();
	}

	/**
	 * Traitement specifique du job.
	 */
	protected abstract void doRun();

	private ${className}UserSession getBatchUserSession() {
		final UserSession userSession;
		final Option<UserSession> optSession = vSecurityManager.getCurrentUserSession();
		if (optSession.isEmpty()) {
			// On a besoin de definir une nouvelle session, qu'il faudra nettoyer
			userSession = vSecurityManager.createUserSession();
			vSecurityManager.startCurrentUserSession(userSession);
		} else {
			userSession = optSession.get();
		}
		// On connecte l'utilisateur batch
		// On sort
		return (${className}UserSession) userSession;
	}

	/**
	 * Donne la valeur de logger.
	 *
	 * @return la valeur de logger.
	 */
	protected final Logger getLogger() {
		return logger;
	}
}
