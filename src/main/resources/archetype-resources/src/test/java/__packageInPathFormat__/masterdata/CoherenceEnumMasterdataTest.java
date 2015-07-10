#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.masterdata;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.junit.Assert;

import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.domain.util.DtObjectUtil;
import ${package}.domain.CodeEnumWithDto;
import ${package}.util.MdlUtil;
import ${package}.tools.Abstract${className}TestCase;

/**
 * @author JDALMEIDA
 */
public class CoherenceEnumMasterdataTest extends Abstract${className}TestCase {

	private static final String DEBUT_MSG = "Checking code ";

	private <D extends DtObject, E extends CodeEnumWithDto<D>> void coherenceEnumeration(final Class<E> enumClass) {
		coherenceEnumeration(enumClass, true);
	}

	private <D extends DtObject, E extends CodeEnumWithDto<D>> void coherenceEnumeration(final Class<E> enumClass,
			final boolean checkMissingDbItems) {
		// Chargement valeurs de l'énumération.
		final E[] enumValues = enumClass.getEnumConstants();
		final Class<D> dtoClass = enumValues[0].getDtoClass();
		// Chargement valeurs de la liste en base.
		final DtList<D> dtc = MdlUtil.getReferenceListAllData(dtoClass);
		// Liste des codes de l'énumération.
		final Set<String> codeSet = new HashSet<>();
		for (final E code : enumValues) {
			codeSet.add(code.name());
		}
		// On vérifie que tous les éléments en base sont bien dans l'énumération.
		if (checkMissingDbItems) {
			for (final D dto : dtc) {
				final String code = DtObjectUtil.getId(dto).toString();
				Assert.assertTrue(DEBUT_MSG + code, codeSet.contains(code.toUpperCase(Locale.FRENCH)));
			}
		}
		// On vérifie que tous les éléments de l'énumération sont bien en base, en vérifiant nottament le getter
		// défini par l'interface. Si l'élément n'est pas en base, une assertion Kasper lors de l'utilisation du getter
		// sera levée.
		for (final E code : enumValues) {
			Assert.assertNotNull(DEBUT_MSG + code.name(), code.getDto());
		}
		if (checkMissingDbItems) {
			// Vérification des tailles de liste.
			Assert.assertEquals(codeSet.size(), dtc.size());
		}
		// Appel de la méthode statique valueOf de l'énumération pour chaque valeur.
		try {
			final Method method = enumClass.getDeclaredMethod("valueOf", new Class[] { String.class });
			for (final E code : enumValues) {
				method.invoke(null, new Object[] { code.name() });
			}
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}
}
