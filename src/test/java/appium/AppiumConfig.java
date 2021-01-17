package appium;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources("file:src/test/resources/appium.config")
public interface AppiumConfig extends Config {

    @Key("device.name")
    String deviceName();

    @Key("device.udid")
    String deviceUdId();

    @Key("platform")
    SimpleMobileFactory.MobileDriver platform();

    @Key("platform.version")
    String platformVersion();

    @Key("app")
    String app();

    @Key("android.app.package")
    String appPackage();

    @Key("android.app.activity")
    String appActivity();

    @Key("appium.server.ip")
    String appiumServerIp();

    @Key("appium.server.port")
    int appiumServerPort();

    @Key("appium.new.command.timeout")
    int newCommandTimeout();

    @Key("appium.timeout")
    int timeout();
}
