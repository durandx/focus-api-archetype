#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package}.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author JDALMEIDA
 */
@RunWith(Suite.class)
@SuiteClasses(value = { //
        CommonTest.class, //
        })
public class AllTestCommon {
}
