#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.masterdata;

import java.lang.reflect.Method;

import org.junit.Test;

import ${package}.domain.CodeEnum;
import ${package}.domain.masterdata.CodeScope;
import ${package}.tools.Abstract${className}TestCase;

/**
 * @author JDALMEIDA
 */
public class EnumSimpleTest extends Abstract${className}TestCase {

	private <E extends CodeEnum> void coherenceEnum(final Class<E> enumClass) {
		getLogger().info("analyse classe " + enumClass.getSimpleName());
		// Chargement valeurs de l'énumération.
		final E[] enumValues = enumClass.getEnumConstants();
		// Pour chaque item de l'enum, appel de valueOf sur le name.
		try {
			final Method method = enumClass.getDeclaredMethod("valueOf", new Class[] { String.class });
			// Appel de la méthode statique valueOf de l'énumération pour chaque valeur.
			for (final E code : enumValues) {
				method.invoke(null, new Object[] { code.name() });
				// On vérifie que les ressources sont bien trouvé dans le localeManager
			}
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
}
