#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.webservices.common;

import javax.inject.Inject;

import io.vertigo.dynamo.collections.model.FacetedQueryResult;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.vega.rest.RestfulService;
import io.vertigo.vega.rest.model.UiListState;
import io.vertigo.vega.rest.stereotype.AnonymousAccessAllowed;
import io.vertigo.vega.rest.stereotype.InnerBodyParam;
import io.vertigo.vega.rest.stereotype.POST;
import io.vertigo.vega.rest.stereotype.QueryParam;
import ${package}.domain.common.SearchCriteria;
import ${package}.domain.common.SelectedFacet;
import ${package}.services.common.CommonServices;

/**
 * Commons webservices.
 *
 * @author JDALMEIDA
 */
public class CommonWebServices implements RestfulService {

	@Inject
	private CommonServices commonServices;

	/**
	 * Search by scope.
	 *
	 * @param searchCriteria Criteria
	 * @param selection selected facet
	 * @param uiListState list state
	 * @param clusteringFacetName clusteringFacetName
	 * @return results
	 */
	@POST("/searchByScope")
	@AnonymousAccessAllowed
	public FacetedQueryResult search(@InnerBodyParam("criteria") final SearchCriteria searchCriteria,
			@InnerBodyParam("facets") final DtList<SelectedFacet> selection,
			@QueryParam("") final UiListState uiListState, @InnerBodyParam("group") final String clusteringFacetName) {
		return commonServices.search(searchCriteria, selection, uiListState, clusteringFacetName);
	}

	@POST("/removeAllIndex")
	@AnonymousAccessAllowed
	public void removeAllIndex() {
		commonServices.removeAllIndex();
	}
}
