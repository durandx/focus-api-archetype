package ${package}.domain;

import java.util.Arrays;
import java.util.Iterator;
import io.vertigo.dynamo.domain.metamodel.DtFieldName;

/**
 * Attention cette classe est générée automatiquement !
 */
public final class DtDefinitions implements Iterable<Class<?>> {
	
	/**
	 * Enumération des DtDefinitions.
	 */
	public enum Definitions {
			/** Objet de données SearchCriteria. */
			SearchCriteria(${package}.domain.common.SearchCriteria.class),
			/** Objet de données SelectedFacet. */
			SelectedFacet(${package}.domain.common.SelectedFacet.class),
		;
		
		private final Class<?> clazz;
		private Definitions(final Class<?> clazz) {
			this.clazz = clazz;
		}
		
		/** 
		  * Classe associée.
		  * @return Class d'implémentation de l'objet 
		  */
		public Class<?> getDtClass() {
			return clazz;
		}
    }

	/**
	 * Enumération des champs de SearchCriteria.
	 */
	public enum SearchCriteriaFields implements DtFieldName {
		/** Propriété 'The Scope'. */
		SCOPE,
		/** Propriété 'query'. */
		QUERY,
	}

	/**
	 * Enumération des champs de SelectedFacet.
	 */
	public enum SelectedFacetFields implements DtFieldName {
		/** Propriété 'Facet Name'. */
		KEY,
		/** Propriété 'Facet query'. */
		FACET_QUERY,
		/** Propriété 'Facet key value'. */
		VALUE,
	}
	
    /** {@inheritDoc} */
    @Override
    public Iterator<Class<?>> iterator() {
        return new Iterator<Class<?>>() {
            private Iterator<Definitions> it = Arrays.asList(Definitions.values()).iterator();

            /** {@inheritDoc} */
            @Override
            public boolean hasNext() {
				return it.hasNext();
            }

            /** {@inheritDoc} */
            @Override
            public Class<?> next() {
            	return it.next().getDtClass();
            }

            /** {@inheritDoc} */
            @Override
            public void remove() {
            	//unsupported
            }
        };
    }

}
