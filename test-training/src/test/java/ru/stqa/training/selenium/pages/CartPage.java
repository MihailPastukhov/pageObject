package ru.stqa.training.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by mpastuhov on 20.12.2016.
 */
public class CartPage extends Page {

    private Set<String> productsSku;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
    }

    public void removeOneProductFromCart(int count) {
        driver.findElement(By.xpath("//button[@name='remove_cart_item']")).click();
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//tr/td[@class='item']"), count));
    }

    public List<String> getProductsSku() {
        List<WebElement> list = driver.findElements(By.xpath("//td[@class='sku']"));
        List<String> lastList = new ArrayList<>();
        //list = driver.findElements(By.xpath("//td[@class='sku']"));
        for (WebElement element : list){
            lastList.add(element.getAttribute("textContent"));
        }
        return lastList;

    }

}
