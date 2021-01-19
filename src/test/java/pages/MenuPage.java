package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage<AppiumDriver>{
    public MenuPage(AppiumDriver<?> pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Abrir el cajon de navegacion\"]")
    private AndroidElement openMenu;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.RelativeLayout[5]")
    private AndroidElement areaConversion;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.RelativeLayout[1]")
    private AndroidElement favorites;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.RelativeLayout[10]")
    private AndroidElement fuelSpendConversion;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.RelativeLayout[10]")
    private AndroidElement speedConversion;

    public void clickOpenMenu(){
        click(openMenu);
    }

    public void clickArea(){
        click(areaConversion);
    }

    public void clickSpeed(){
        click(speedConversion);
    }

    public void scrollOnMenu(){
        AppiumDriver driver = getDriver();
        new TouchAction((PerformsTouchActions) driver).press(fuelSpendConversion).moveTo(favorites).release().perform();
    }

}
