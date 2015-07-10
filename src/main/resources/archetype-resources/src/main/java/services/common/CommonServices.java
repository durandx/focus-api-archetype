#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.services.common;

import io.vertigo.dynamo.collections.model.FacetedQueryResult;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.search.model.SearchQuery;
import io.vertigo.lang.Component;
import io.vertigo.vega.rest.model.UiListState;
import ${package}.domain.common.SearchCriteria;
import ${package}.domain.common.SelectedFacet;

/**
 * Contains commons services.
 *
 * @author JDALMEIDA
 */
public interface CommonServices extends Component {

	/**
	 * Search by scope.
	 *
	 * @param searchCriteria criteria
	 * @param selection facets.
	 * @param uiListState uiListState
	 * @param clusteringFacetName clusteringFacetName
	 * @return Object
	 */
	FacetedQueryResult<? extends DtObject, SearchQuery> search(SearchCriteria searchCriteria, final DtList<SelectedFacet> selection, final UiListState uiListState,
					String clusteringFacetName);

	/**
	 * Remove all indexes.
	 */
	void removeAllIndex();

}
