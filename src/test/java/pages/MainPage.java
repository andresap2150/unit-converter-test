package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class MainPage extends BasePage<AppiumDriver>{
    public MainPage(AppiumDriver pDriver) {
        super(pDriver);
    }

    @AndroidFindBy(id = "com.ba.universalconverter:id/to_units_spinner")
    private AndroidElement toUnits;

    @AndroidFindBy(id = "com.ba.universalconverter:id/target_value")
    private AndroidElement convertedvalue;

    @AndroidFindBy(id="com.ba.universalconverter:id/img_switch")
    private AndroidElement switchMagnitudes;

    private String sqaredKilometersText = "Kil";

    public void clickToUnits(){
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
            String actualRow = "";
            int tempDig = digit/3;
            if(tempDig ==2){
                actualRow = String.valueOf(tempDig);
            }else{
                actualRow = String.valueOf(3-tempDig);
            }
            int tempDigCol = Math.floorMod(digit,3);
            String actualDig = "";
            if(tempDigCol == 0){
                actualDig = String.valueOf(3);
            }else{
                actualDig = String.valueOf(tempDigCol);
            }
            getDriver().findElement(By.xpath("//android.widget.LinearLayout[@resource-id=\"com.ba.universalconverter:id/buttons_row_"+actualRow+"\"]/android.widget.Button["+actualDig+"]")).click();
            auxValue = auxValue - (digit*divisor);
        }
    }

    public String readTargetValue(){
        return getText(convertedvalue);
    }

    public void clickSwitch(){
        click(switchMagnitudes);
    }
}
