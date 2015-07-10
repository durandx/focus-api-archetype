#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.webservices.masterdata;

import io.vertigo.vega.rest.RestfulService;
import io.vertigo.vega.rest.stereotype.AnonymousAccessAllowed;
import io.vertigo.vega.rest.stereotype.GET;

import java.util.List;

import javax.inject.Inject;

import ${package}.services.masterdata.MasterdataServices;
import ${package}.util.ReferenceObject;

/**
 * Webservices for master data.
 *
 * @author JDALMEIDA
 */
public final class MasterdataWebServices implements RestfulService {

    @Inject
    private MasterdataServices masterdataServices;

    /**
     * Get Scope list.
     *
     * @return scope List
     */
    @GET("/scopes")
    @AnonymousAccessAllowed
    public List<ReferenceObject> getScopes() {
        return masterdataServices.getScopes();
    }
}
