package steps;

import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.MenuPage;

public class MenuPageSteps {
    private static final Logger log = LogManager.getLogger(MenuPageSteps.class);
    private MenuPage menuPage;

    @When("^I open the menu to select (.*)$")
    public void iOpenTheMenuToSelectOption(String menuOption) throws Throwable {
        menuPage = new MenuPage(Context.driver);
        menuPage.clickOpenMenu();
        switch (menuOption) {
            case "Area":
                menuPage.clickArea();
                break;
            case "Speed":
                menuPage.scrollOnMenu();
                menuPage.clickSpeed();
                break;
        }
    }
}
