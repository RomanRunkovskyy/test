package testng.tests;

import com.csdc.webclient.core.WebClientProperties;
import com.csdc.webclient.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import testng.base.WebClientTestBase;

public class DummyWebClientTest extends WebClientTestBase {

    private final static String DB_NAME = "TESTDATA (MS-vm)";
    private final static String USERNAME = "TEST_USER";
    private final static String PASSWORD = "TEST_USER";

    private LoginPage loginPage = appContext.getBean(LoginPage.class);

    @Test
    public void userLoginTest() {
//        loginPage.open()
//                .selectDB(DB_NAME)
//                .signIn(USERNAME, PASSWORD);

        System.setProperty("webdriver.chrome.driver", "web-client/src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");


    }
}
