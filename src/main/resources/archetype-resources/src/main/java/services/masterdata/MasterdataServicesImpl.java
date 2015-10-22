#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services.masterdata;

import java.util.ArrayList;
import java.util.List;

import ${package}.domain.masterdata.CodeScope;
import ${package}.util.ReferenceObject;

/**
 * Implementations of masterdata services.
 *
 * @author JDALMEIDA
 */
public class MasterdataServicesImpl implements MasterdataServices {

	@Override
	public List<ReferenceObject> getScopes() {
		final List<ReferenceObject> ret = new ArrayList<>();
        final CodeScope[] codeScopes = CodeScope.values();
        for (final CodeScope code : codeScopes) {
            ret.add(new ReferenceObject(code.name(), code.name(), true));
        }
		return ret;
	}
}
