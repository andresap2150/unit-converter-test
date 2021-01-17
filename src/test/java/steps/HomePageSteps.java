package steps;

import appium.AppiumConfig;
import appium.SimpleMobileFactory;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.aeonbits.owner.ConfigFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.BasePage;
import pages.LandingPage;

public class HomePageSteps {

    private AppiumDriver<MobileElement> wd;
    private static final Logger log = LogManager.getLogger(HomePageSteps.class);

    @When("^I open the menu$")
    public void iLaunchQuikrApp() throws Throwable {
        LandingPage landing = new LandingPage(Context.driver);
        landing.clickOpenMenu();
        log.info("in the first step!!!");
        landing.clickArea();
    }
}
