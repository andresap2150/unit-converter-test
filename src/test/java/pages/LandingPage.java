package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class LandingPage extends BasePage<AppiumDriver>{
    public LandingPage(AppiumDriver pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Abrir el cajon de navegacion\"]")
    private AndroidElement openMenu;

    @AndroidFindBy(xpath = "//android.widget.ListView/android.widget.RelativeLayout[5]")
    private AndroidElement areaConversion;

    @AndroidFindBy(id = "com.ba.universalconverter:id/to_units_spinner")
    private AndroidElement toUnits;

    private String sqaredKilometersText = "Kil";

    public void clickOpenMenu(){
        click(openMenu);
    }

    public void clickArea(){
        click(areaConversion);
    }

    public void clicToUnits(){
        click(toUnits);
    }

    public void setKilometers(){
        AndroidElement kmelement = getAndroidElementByText(sqaredKilometersText);
        click(kmelement);
    }

    public void setInitialValue(int initialValue) {
        int auxValue = initialValue;
        int digits = (int) (Math.log10(initialValue));
        for (int i= digits; i >= 0; i--){
            int divisor = (int)Math.round(Math.pow(10, i));
            int digit = auxValue / divisor;
            if(digit ==0){
                getDriver().findElement(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.ba.universalconverter:id/buttons_row_4\"]/android.widget.Button[1]")).click();
                auxValue = auxValue - (digit*divisor);
                continue;
            }
            String actualRow = String.valueOf(3-(digit/3));
            String actualDig = String.valueOf(Math.floorMod(digit,3));
            getDriver().findElement(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.ba.universalconverter:id/buttons_row_"+actualRow+"\"]/android.widget.Button["+actualDig+"]")).click();
            auxValue = auxValue - (digit*divisor);
        }
    }
}
