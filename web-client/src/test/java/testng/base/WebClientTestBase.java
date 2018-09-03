package testng.base;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.Commands;
import com.codeborne.selenide.testng.ScreenShooter;
import com.csdc.webclient.commands.ClickCommand;
import com.csdc.webclient.commands.ExistsCommand;
import com.csdc.webclient.commands.SafeWaitUntilCommand;
import com.csdc.webclient.commands.SetValueCommand;
import com.csdc.webclient.core.*;
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
        Configuration.browser = WebClientProperties.readString("browser");
        Configuration.baseUrl = WebClientProperties.readString("selenide.base.url");
        System.setProperty("webdriver.ie.driver", WebClientProperties.readString("ie.webdriver.path"));
        System.setProperty("webdriver.chrome.driver",WebClientProperties.readString("chrome.webdriver.path"));

        Commands.getInstance().add("safeWaitUntil", new SafeWaitUntilCommand());
        Commands.getInstance().add("click", new ClickCommand());
        Commands.getInstance().add("setValue", new SetValueCommand());
        Commands.getInstance().add("exists", new ExistsCommand());
    }

    @AfterSuite
    public void tearDown() {
        appContext.close();
    }
}
