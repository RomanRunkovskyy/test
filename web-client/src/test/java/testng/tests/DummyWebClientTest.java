package testng.tests;

import com.csdc.webclient.core.WebClientProperties;
import com.csdc.webclient.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;
import testng.base.WebClientTestBase;

public class DummyWebClientTest extends WebClientTestBase {

    private static final Logger log = LoggerFactory.getLogger(WebClientTestBase.class);

    private final static String DB_NAME = "TESTDATA (MS-vm)";
    private final static String USERNAME = "TEST_USER";
    private final static String PASSWORD = "TEST_USER";

    private LoginPage loginPage = appContext.getBean(LoginPage.class);

    @Test
    public void userLoginTest() {
//        loginPage.open()
//                .selectDB(DB_NAME)
//                .signIn(USERNAME, PASSWORD);

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("window-size=1024,768");
        WebDriver driver = new ChromeDriver(ChromeOptions);
        driver.get("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("BLALA");
        driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
        log.info("-----------:" + driver.findElement(By.name("q")).getTagName());


    }
}
