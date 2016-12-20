package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.training.selenium.pages.Page;

/**
 * Created by mpastuhov on 20.12.2016.
 */
public class ProductPage extends Page {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void open(){
        driver.findElement(By.xpath("//a[contains(@title,'Duck')]")).click();
    }

    public void addToCart() {
        driver.findElement(By.xpath("//button[@name='add_cart_product']")).click();
    }

    public void selectSizeOfProduct() {
        if (isElementPresent(driver, By.xpath("//select[@name='options[Size]']"))) {
            Select size = new Select(driver.findElement(By.xpath("//select[@name='options[Size]']")));
            size.selectByIndex(1);
        }
    }
    public void waitForUpdateCart() {
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.xpath("//a/span[@class='quantity']")), "textContent", String.valueOf(getProductCount() + 1)));
    }

    public int getProductCount() {
        return Integer.parseInt(driver.findElement(By.xpath("//a/span[@class='quantity']")).getAttribute("textContent"));
    }


}
