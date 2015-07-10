#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.services.common;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.vertigo.core.Home;
import io.vertigo.dynamo.collections.ListFilter;
import io.vertigo.dynamo.collections.metamodel.FacetDefinition;
import io.vertigo.dynamo.collections.model.FacetValue;
import io.vertigo.dynamo.collections.model.FacetedQueryResult;
import io.vertigo.dynamo.domain.model.DtList;
import io.vertigo.dynamo.domain.model.DtObject;
import io.vertigo.dynamo.search.SearchManager;
import io.vertigo.dynamo.search.model.SearchQuery;
import io.vertigo.dynamo.transaction.Transactional;
import io.vertigo.vega.rest.model.UiListState;
import ${package}.domain.common.SearchCriteria;
import ${package}.domain.common.SelectedFacet;

/**
 * Implementation of common ws.
 *
 * @author JDALMEIDA
 */
@Transactional
public class CommonServicesImpl implements CommonServices {

	@Inject
	private SearchManager searchManager;

	/** {@inheritDoc} */
	@Override
	public FacetedQueryResult<? extends DtObject, SearchQuery> search(final SearchCriteria searchCriteria, final DtList<SelectedFacet> selection,
			final UiListState uiListState, final String clusteringFacetName) {
		return null;
	}

	private List<ListFilter> toListFilters(final DtList<SelectedFacet> selectedFacets) {
		final List<ListFilter> listFilters = new ArrayList<>(selectedFacets.size());
		// facet selection list.
		for (int i = 0; i < selectedFacets.size(); i++) {
			final SelectedFacet selectedFacet = selectedFacets.get(i);
			final FacetDefinition facetDefinition = Home.getDefinitionSpace().resolve(selectedFacet.getKey(), FacetDefinition.class);
			if (facetDefinition.isRangeFacet()) {
				for (final FacetValue facet : facetDefinition.getFacetRanges()) {
					if (facet.getLabel().getDisplay().equals(selectedFacet.getValue())) {
						listFilters.add(facet.getListFilter());
						break;
					}
				}
			} else {
				final ListFilter filter = new ListFilter(facetDefinition.getDtField().getName() + ":${symbol_escape}"" + selectedFacet.getValue() + "${symbol_escape}"");
				listFilters.add(filter);
			}
		}
		return listFilters;
	}

	/** {@inheritDoc} */
	@Override
	public void removeAllIndex() {

	}
}
