package ru.netology.qa.screens;

import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class AppiumMain {

    @AndroidFindBy(id = "textToBeChanged")
    public MobileElement textToBeChanged;

    @AndroidFindBy(id = "userInput")
    public MobileElement userInput;

    @AndroidFindBy(id = "buttonChange")
    public MobileElement buttonChange;

    @AndroidFindBy(id = "buttonActivity")
    public MobileElement buttonActivity;

    @AndroidFindBy(id = "text")
    public MobileElement text;

    public AppiumMain (AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(15)), this);
    }
}
