package stepdefinitions;

import config.ConfigReader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class APKYuklemeStepDefinitions {

    AndroidDriver<AndroidElement>androidDriver;


    @Given("Kullanici {string} uygulamasini cihaza yükler")
    public void kullanici_uygulamasini_cihaza_yükler(String apkDosyaYolu) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, ConfigReader.getProperty("TELEFONADI"));//cihazin adi
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, ConfigReader.getProperty("PLATFORM"));//cihazin android olmasini tanimladik
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,ConfigReader.getProperty("ANDROIDVERSION"));//Android in versiyonunu yazdik
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, ConfigReader.getProperty("OTOMASYON_ISMI"));// cihazin otomasyonunun saglamak icin. IOS icin XCUITest yazilacak
        caps.setCapability(MobileCapabilityType.APP, apkDosyaYolu);

       androidDriver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723"), caps);
       androidDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }


    @Given("example")
    public void example() {
        Allure.step("Örenk step");
    }
}
