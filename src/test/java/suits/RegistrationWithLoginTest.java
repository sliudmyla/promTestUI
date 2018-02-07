package suits;


import loginTest.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import registrationTest.RegistrationTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                RegistrationTest.class,
                LoginTest.class

         }
)
public class RegistrationWithLoginTest {
}
