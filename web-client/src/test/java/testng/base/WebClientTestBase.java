package testng.base;

import com.codeborne.selenide.testng.ScreenShooter;
import com.csdc.webclient.core.SelenideConfiguration;
import com.csdc.webclient.core.WebClientSpringBeanConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ScreenShooter.class})
public class WebClientTestBase {
    private static final Logger log = LoggerFactory.getLogger(WebClientTestBase.class);
    protected static final AnnotationConfigApplicationContext appContext;

    static {
        appContext = new AnnotationConfigApplicationContext(WebClientSpringBeanConfiguration.class);
    }

    @BeforeSuite
    public void setUp() {
        SelenideConfiguration.initWebDriver();
        SelenideConfiguration.initCommands();
    }

    @AfterSuite
    public void tearDown() {
        appContext.close();
    }
}
