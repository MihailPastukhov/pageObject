package ru.stqa.training.selenium.tests;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * Created by Michael on 05.12.2016.
 */
public class CartTest extends TestBase {

    @Test
    public void cartRefreshTest(){
        app.homePage.open();

        for (int i = 0; i < app.quantity; i++) {
            app.productPage.open();
            app.productPage.selectSizeOfProduct();
            app.productPage.addToCart();
            app.productPage.waitForUpdateCart();
        }

        app.cartPage.open();

        for (int i = app.quantity; i > 0; i--){

            List<String> oldPrds = app.cartPage.getProductsSku();
            app.cartPage.removeOneProductFromCart(i);
            List<String> newPrds = app.cartPage.getProductsSku();
            Assert.assertTrue("Element hasn't been removed from cart", newPrds.size() == oldPrds.size() - 1);
        }

        app.homePage.open();
    }


}
