#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.common;

import javax.inject.Inject;

import org.junit.Test;

import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.vega.rest.model.UiListState;
import ${package}.domain.common.SearchCriteria;
import ${package}.domain.common.SelectedFacet;
import ${package}.domain.masterdata.CodeScope;
import ${package}.services.common.CommonServices;
import ${package}.tools.Abstract${className}TestCase;

/**
 * Test for common service.
 *
 * @author JDALMEIDA
 */
public class CommonTest extends Abstract${className}TestCase {

	@Inject
	private CommonServices commonServices;

	/**
	 * Test search method.
	 */
	@Test
	public void testSearchAll() {
		// Test for all
		final SearchCriteria criteria = new SearchCriteria();
		criteria.setScope(CodeScope.ALL.name());
		criteria.setQuery("Jen");
		final UiListState uiListState = new UiListState(50, 0, null, false, null);
		final DtList<SelectedFacet> selection = new DtList<>(SelectedFacet.class);
		commonServices.search(criteria, selection, uiListState, "");
	}
}
