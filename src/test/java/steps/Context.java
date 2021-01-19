package steps;

import io.appium.java_client.AppiumDriver;
import org.assertj.core.api.SoftAssertions;

public class Context {
    public static AppiumDriver<?> driver;
    public static SoftAssertions softAssertions;
}
