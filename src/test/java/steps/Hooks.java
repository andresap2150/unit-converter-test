package steps;

import appium.AppiumConfig;
import appium.SimpleMobileFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.appium.java_client.AppiumDriver;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.xalan.xsltc.dom.AdaptiveResultTreeImpl;

public class Hooks {
    private static final Logger log = LogManager.getLogger(Hooks.class);

    @Before
    public void setUp(){
        AppiumConfig config = ConfigFactory.create(AppiumConfig.class);
        SimpleMobileFactory mf = new SimpleMobileFactory();
        AppiumDriver<?> driver = mf.getDriver(config);
        Context.driver = driver;
        log.info("Driver successfully started");
    }

    @After
    public void tearDown(Scenario scenario) throws Exception {
        Context.driver.closeApp();
        log.info("In After tests.......");
    }
}
