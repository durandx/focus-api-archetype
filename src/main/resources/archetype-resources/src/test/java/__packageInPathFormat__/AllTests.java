#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 *
 */
package ${package};

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ${package}.common.AllTestCommon;
import ${package}.masterdata.MasterdataAllTest;

/**
 * Launch all NRT.
 *
 * @author jmforhan
 */
@RunWith(Suite.class)
@SuiteClasses(value = { //
        ApplicationStartTest.class, //
                DtoTest.class, //
                MasterdataAllTest.class, //
                AllTestCommon.class, //
        })
public class AllTests {
    // Les annotations sont suffisantes.
}
