package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import steps.Context;

public class LandingPage extends BasePage<AndroidDriver<AndroidElement>>{
    public LandingPage(AppiumDriver pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Abrir el cajon de navegacion\"]")
    private AndroidElement openMenu;

    @AndroidFindBy(id = "com.ba.universalconverter:id/drawerItem")
    private AndroidElement areaConversion;

    public void clickOpenMenu(){
        openMenu.click();
    }

    public void clickArea(){
        try {
            getWait().until(ExpectedConditions.visibilityOf(areaConversion));
            click(areaConversion);
        }catch (Exception e){

        }
    }
}
