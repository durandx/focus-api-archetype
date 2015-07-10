#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.masterdata;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author JDALMEIDA
 */
@RunWith(Suite.class)
@SuiteClasses(value = { //
        EnumSimpleTest.class, //
                CoherenceEnumMasterdataTest.class, //
        })
public class MasterdataAllTest {
    // Just annotations
}
