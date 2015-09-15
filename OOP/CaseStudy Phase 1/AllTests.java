
/****************************************************************************************
Name            : AllTest
Revision Log    : 2015-09-14: Babalu patidar : created.
                : 
                : 
Use             : This class is used to test All test class.
                :
****************************************************************************************/

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ VehicleDetailPrinterTest.class, VehicleHelperTest.class })
public class AllTests {

}
//End of AllTest class
