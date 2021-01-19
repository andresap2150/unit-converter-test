package steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.MainPage;

public class MainPageSteps {

    private static final Logger log = LogManager.getLogger(MainPageSteps.class);
    private MainPage mainPage;

    public MainPageSteps(){
        mainPage = new MainPage(Context.driver);
    }

    @When("^I set (\\d+) hectareas to squaredkilometers$")
    public void i_set_hectareas_to_squaredkilometers(int initialValue) throws Throwable {
        mainPage.clickToUnits();
        mainPage.setKilometers();
        mainPage.setInitialValue(initialValue);
    }

    @When("^I set (\\d+) kilometers/hours$")
    public void i_set_values_after_switch(int initialValue) throws Throwable {
        mainPage.clickSwitch();
        mainPage.setInitialValue(initialValue);
    }

    @Then("^I see the (.+) converted units$")
    public void i_see_the_converted_units(double converted) throws Throwable {
        double actualValue = Double.valueOf(mainPage.readTargetValue());
        Context.softAssertions.assertThat(actualValue).isEqualTo(converted).withFailMessage("The converted value is not the same as expected");
    }
}
