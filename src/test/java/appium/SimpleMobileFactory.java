package appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.events.EventFiringWebDriverFactory;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import static io.appium.java_client.remote.MobileCapabilityType.*;
import static java.util.concurrent.TimeUnit.SECONDS;

public class SimpleMobileFactory {
    private static final Logger log = LogManager.getLogger(SimpleMobileFactory.class);

    public AppiumDriver<?> getDriver(AppiumConfig config) {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(PLATFORM_VERSION,config.platformVersion());
        capabilities.setCapability(DEVICE_NAME, config.deviceName());
        capabilities.setCapability(UDID, config.deviceUdId());

        AppiumServerAddress address = new AppiumServerAddress(config.appiumServerIp(), config.appiumServerPort());

        AppiumDriver<?> driver = config.platform().setDriver(address, capabilities, config);
        driver.manage().timeouts().implicitlyWait(1, SECONDS);
        driver = EventFiringWebDriverFactory.getEventFiringWebDriver(driver);
        return driver;
    }

    public enum MobileDriver {

        ANDROID {
            @Override
            public AndroidDriver<AndroidElement> setDriver(AppiumServerAddress address, DesiredCapabilities cap,
                                                           AppiumConfig config) {
                cap.setCapability("appPackage", config.appPackage());
                cap.setCapability("appActivity", config.appActivity());
                return new AndroidDriver<AndroidElement>(address.getRemoteAddress(), cap);
            }
        },

        IOS {
            @Override
            public IOSDriver<IOSElement> setDriver(AppiumServerAddress address, DesiredCapabilities cap,
                                                   AppiumConfig config) {
                return new IOSDriver<IOSElement>(address.getRemoteAddress(), cap);
            }
        };

        public abstract AppiumDriver<?> setDriver(AppiumServerAddress address, DesiredCapabilities cap,
                                                  AppiumConfig config);
    }
}
