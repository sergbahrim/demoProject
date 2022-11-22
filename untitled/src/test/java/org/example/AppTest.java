package org.example;

import static org.junit.Assert.assertTrue;
import org.ShopPageElementsAndActions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void buyProductsTest() throws InterruptedException {

        //Chrome driver initialisation
        WebDriver driver = new ChromeDriver();

        //Create new istance of ShopPageELementsAndActions object
        ShopPageElementsAndActions shop1 = new ShopPageElementsAndActions(driver);
        
        shop1.goToUrl();
        shop1.addProductsToCart();
        shop1.goToCart();

        //Validate that cart contains 4 items 
        List <WebElement> elementsInCart = driver.findElements(shop1.cartItem);
        Assert.assertEquals(elementsInCart.size(),4);
        
        //Remove the item with lowest price
        shop1.removeLowestPriceItem();

        //Validate that cart contains 3 items
        List <WebElement> elementsInCartUpdated = driver.findElements(shop1.cartItem);
        Assert.assertEquals(elementsInCartUpdated.size(),3);

    }

}
