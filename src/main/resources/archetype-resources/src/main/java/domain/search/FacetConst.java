#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.domain.search;

import io.vertigo.dynamo.domain.metamodel.DtFieldName;
import io.vertigo.util.StringUtil;
import ${package}.domain.CodeEnum;

/**
 * Enum of the various available facets.
 *
 * @author jmforhan
 */
public enum FacetConst implements CodeEnum {
	//
	;

	private final DtFieldName field;
	private final String facetName;

	private FacetConst(final DtFieldName field, final String facetName) {
		this.field = field;
		this.facetName = facetName;
	}

	/**
	 * Get the associated field.
	 *
	 * @return the field
	 */
	public DtFieldName getField() {
		return field;
	}

	/**
	 * Get the associated facet label.
	 *
	 * @return the facetName
	 */
	public String getFacetName() {
		return facetName;
	}

	/**
	 * Get facetCost by facet Name.
	 *
	 * @param facetName facet Name
	 * @return Facet Const
	 */
	public static FacetConst getFacetByName(final String facetName) {
		if (!StringUtil.isEmpty(facetName)) {

		}
		return null;
	}
}
