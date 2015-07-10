#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services.masterdata;

import io.vertigo.lang.Component;

import java.util.List;

import ${package}.util.ReferenceObject;

/**
 * Master datas services.
 *
 * @author JDALMEIDA
 */
public interface MasterdataServices extends Component {

    /**
     * Get Scope list
     *
     * @return scope List
     */
    List<ReferenceObject> getScopes();
}
