package ru.stqa.training.selenium.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by mpastuhov on 20.12.2016.
 */
public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.get("http://localhost/litecart/");
    }

}
