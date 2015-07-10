#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package};

import io.vertigo.vega.plugins.rest.routesregister.sparkjava.VegaSparkApplication;

import org.junit.Test;

import ${package}.tools.Abstract${className}TestCase;

/**
 * Classe testant le démarrage de l'application.
 *
 * @author jmforhan
 */
public class ApplicationStartTest extends Abstract${className}TestCase {

	/**
	 * Test the start of the application.
	 * The idea is to check that all vertigo components are correctly registred and the WS REST routes are correctly
	 * initialized.
	 */
	@Test
	public void testApplicationStart() {
		new VegaSparkApplication().init();
	}
}
