#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain;

import io.vertigo.dynamo.domain.model.DtObject;

/**
 * Enum with DTO.
 *
 * @author jmforhan
 * @param <D> DtObject
 */
public interface CodeEnumWithDto<D extends DtObject> extends CodeEnum {

    /**
     * Récupération du dto associé.
     *
     * @return dto
     */
    D getDto();

    /**
     * Classe du dto.
     *
     * @return classe
     */
    Class<D> getDtoClass();
}
