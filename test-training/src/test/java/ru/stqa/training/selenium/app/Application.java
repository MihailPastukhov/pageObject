package ru.stqa.training.selenium.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.pages.CartPage;
import ru.stqa.training.selenium.pages.HomePage;
import ru.stqa.training.selenium.pages.ProductPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mpastuhov on 20.12.2016.
 */
public class Application {

    final public int quantity = 3;
    private WebDriver driver;
    private WebDriverWait wait;

    public HomePage homePage;
    public ProductPage productPage;
    public CartPage cartPage;

    public List<String> products = new ArrayList<String>();


    public void init() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void exit(){
        driver.quit();
        driver = null;
    }
}
