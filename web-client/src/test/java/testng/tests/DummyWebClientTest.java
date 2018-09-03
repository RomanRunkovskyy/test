package testng.tests;

import com.csdc.webclient.pageobjects.LoginPage;
import org.testng.annotations.Test;
import testng.base.WebClientTestBase;

public class DummyWebClientTest extends WebClientTestBase {

    private final static String DB_NAME = "TESTDATA (MS-vm)";
    private final static String USERNAME = "TEST_USER";
    private final static String PASSWORD = "TEST_USER";

    private LoginPage loginPage = appContext.getBean(LoginPage.class);

    @Test
    public void userLoginTest() {
        loginPage.open()
                .selectDB(DB_NAME)
                .signIn(USERNAME, PASSWORD);
    }
}
