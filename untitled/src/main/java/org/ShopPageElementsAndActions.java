package org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ShopPageElementsAndActions {

    public WebDriver driver;
    private final String url = "https://cms.demo.katalon.com/";
    private final By productOne = By.cssSelector("a[data-product_sku=\'HOODIE-HAPPY-NINJA\']");
    private final By productOneAdded = By.xpath("//a[@data-product_sku='HOODIE-HAPPY-NINJA']/../a[@class='added_to_cart wc-forward']");

    private final By productTwo = By.cssSelector("a[data-product_sku=\'POSTER-FLYING-NINJA\']");
    private final By productTwoAdded = By.xpath("//a[@data-product_sku='POSTER-FLYING-NINJA']/../a[@class='added_to_cart wc-forward']");

    private final By productThree = By.cssSelector("a[data-product_sku=\'T-SHIRT-HAPPY-NINJA\']");
    private final By productThreeAdded = By.xpath("//a[@data-product_sku='T-SHIRT-HAPPY-NINJA']/../a[@class='added_to_cart wc-forward']");
    private final By productFour = By.cssSelector("a[data-product_sku=\'T-SHIRT-NINJA-SILHOUETTE\']");
    private final By productFourAdded = By.xpath("//a[@data-product_sku='T-SHIRT-HAPPY-NINJA']/../a[@class='added_to_cart wc-forward']");

    public final By cartItem = By.cssSelector(".cart_item");

    private final By cartButton = By.cssSelector(".page-item-8");

    private final By cartPriceItem = By.cssSelector(".product-price .amount");

    public ShopPageElementsAndActions(WebDriver driver) {
        this.driver = driver;
    }

    public void goToUrl() {
        driver.navigate().to(url);
    }

    public void addProductsToCart() throws InterruptedException {
        driver.findElement(productOne).click();
        Thread.sleep(2000);
        driver.findElement(productTwo).click();
        Thread.sleep(2000);
        driver.findElement(productThree).click();
        Thread.sleep(2000);
        driver.findElement(productFour).click();
        Thread.sleep(2000);
    }

    public void goToCart(){
        driver.findElement(cartButton).click();
    }

    public void removeLowestPriceItem() throws InterruptedException {

        List <WebElement> pricesList = driver.findElements(cartPriceItem);
        List<Double> priceListDouble = new ArrayList<>();
        for (WebElement e: pricesList){
            priceListDouble.add(Double.parseDouble(e.getText().replace("$","")));
        }

        double min = priceListDouble.stream().min(Comparator.<Double>naturalOrder()).get();
        System.out.println(min);

        driver.findElement( By.xpath("//*[contains(text(), '"+min+"')]/../../td[@class='product-remove']/a")).click();
        Thread.sleep(2000);
    }

}


