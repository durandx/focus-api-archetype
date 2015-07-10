#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.domain.search;

import io.vertigo.core.Home;
import io.vertigo.dynamo.collections.metamodel.FacetedQueryDefinition;
import ${package}.domain.CodeEnum;

/**
 * Enum of the various searches. With or Without facets.
 *
 * @author jmforhan
 */
public enum FacetedSearchConst implements CodeEnum {
	;

	private final FacetConst[] facetConstTab;
	private final Class indexClassname;

	private FacetedSearchConst(final Class indexClassname, final FacetConst... facetConstTab) {
		this.facetConstTab = facetConstTab;
		this.indexClassname = indexClassname;
	}

	private FacetedSearchConst() {
		facetConstTab = null;
		indexClassname = null;
	}

	/**
	 * Give the value of facetConstTab.
	 *
	 * @return the value of facetConstTab.
	 */
	public FacetConst[] getFacetConstTab() {
		return facetConstTab;
	}

	/**
	 * Give the value of indexClassname.
	 *
	 * @return the value of indexClassname.
	 */
	public Class getIndexClassname() {
		return indexClassname;
	}

	/**
	 * Get the vertigo definition associated with the search.
	 *
	 * @return definition
	 */
	public FacetedQueryDefinition getQuery() {
		return Home.getDefinitionSpace().resolve(name(), FacetedQueryDefinition.class);
	}
}
