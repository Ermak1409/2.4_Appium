package ru.netology.qa;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.netology.qa.screens.AppiumMain;


import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class AppiumTest {

    private AndroidDriver driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName", "Some name");
        desiredCapabilities.setCapability("appium:app", "D:\\\\Netology\\\\2.4_Appium\\\\app-debug.apk");
        desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
        desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
        desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void testEmptyString() {
        AppiumMain screen = new AppiumMain(driver);
        String beginText = screen.textToBeChanged.getText();
        screen.userInput.sendKeys(" ");
        screen.buttonChange.click();
        String endText = screen.textToBeChanged.getText();
        assertEquals(beginText, endText);
    }

    @Test
    public void testOpenTextInNewActivity() {
        AppiumMain screen = new AppiumMain (driver);
        String newText = "New Activity";
        screen.userInput.sendKeys(newText);
        screen.buttonActivity.click();
        assertEquals(newText, screen.text.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}