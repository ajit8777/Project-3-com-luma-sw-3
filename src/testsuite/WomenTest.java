package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/** Write down the following test into WomenTestclass
 1. verifyTheSortByProductNameFilter
 * Mouse Hover on Women Menu
 * Mouse Hover on Tops
 * Click on Jackets
 * Select Sort By filter “Product Name”
 * Verify the products name display in alphabetical order
 2. verifyTheSortByPriceFilter
 * Mouse Hover on Women Menu
 * Mouse Hover on Tops
 * Click on Jackets
 * Select Sort By filter “Price”
 * Verify the products price display in Low to High
 */

public class WomenTest extends Utility {
    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyTheSortByProductNameFilter() throws InterruptedException {
        mouseHoverToElement(By.id("ui-id-4"));
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        // Select Sort By filter “Product Name”
        selectByVisibleTextFromDropDown(By.id("sorter"), "Product Name");

        // Verify the products name display in alphabetical order

        List actualList = new ArrayList();
        List<WebElement> productsName = driver.findElements(By.xpath("//strong[@class='product name product-item-name']"));

        for (WebElement nameOfProduct : productsName) {
            String data = nameOfProduct.getText();
            actualList.add(data);
        }
        List expectedList = new ArrayList();
        expectedList.addAll(actualList);
        Collections.sort(expectedList);

        Assert.assertTrue(actualList.equals(expectedList));
    }

    @Test
    public void verifyTheSortByPriceFilter() throws InterruptedException {
        mouseHoverToElement(By.id("ui-id-4"));
        Thread.sleep(2000);
        mouseHoverToElement(By.xpath("//a[@id='ui-id-9']//span[contains(text(),'Tops')]"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//a[@id='ui-id-11']//span[contains(text(),'Jackets')]"));

        selectByVisibleTextFromDropDown(By.id("sorter"), "Price");

        // Verify the products price display in Low to High
        List<WebElement> beforeFilterPrice = driver.findElements(By.xpath("//span[@data-price-type='finalPrice']"));

        // remove $ symbol from the price and convert the string into double
        List<Double> actualPriceList = new ArrayList();

        for (WebElement p : beforeFilterPrice) {
            actualPriceList.add(Double.valueOf(p.getText().replace("$", "")));
        }

        List expectedPriceList = new ArrayList();
        expectedPriceList.addAll(actualPriceList);
        Collections.sort(expectedPriceList);

        Assert.assertTrue(actualPriceList.equals(expectedPriceList));
    }

    @After
    public void closingBrowser(){
        closeBrowser();
    }
}


