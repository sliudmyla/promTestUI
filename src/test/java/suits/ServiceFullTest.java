package suits;

import ServiceTest.AddServiceTest;
import ServiceTest.DeleteServiceTest;
import ServiceTest.EditServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                AddServiceTest.class,
                EditServiceTest.class,
                DeleteServiceTest.class
        }
)
public class ServiceFullTest {
}