package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * Mouse Hover on Gear Menu
 * Click on Bags
 * Click on Product Name ‘Overnight Duffle’
 * Verify the text ‘Overnight Duffle’
 * Change Qty 3
 * Click on ‘Add to Cart’ Button.
 * Verify the text
 * <p>
 * ‘You added Overnight Duffle to your shopping cart.’
 * Click on ‘shopping cart’ Link into
 * message
 * Verify the product name ‘Cronus Yoga Pant’
 * Verify the Qty is ‘3’
 * Verify the product price ‘$135.00’
 * Change Qty to ‘5’
 * Click on ‘Update Shopping Cart’ button
 * Verify the product price ‘$225.00’
 */

public class GearTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() throws InterruptedException {
        // *Mouse Hover on Gear Menu
        mouseHoverToElement(By.id("ui-id-6"));

        //* Click on Bags
        mouseHoverToElementAndClick(By.id("ui-id-25"));

        //* Click on Product Name ‘Overnight Duffle’
        clickOnElement(By.xpath("//img[@alt='Overnight Duffle']"));

        //* Verify the text ‘Overnight Duffle’
        String expectedText = "Overnight Duffle";
        String actualText = getTextFromElement(By.xpath("(//span[@class='base'])[1]"));
        Assert.assertEquals(expectedText, actualText);

        //* Change Qty 3
        driver.findElement(By.id("qty")).clear();
        sendTextOnElement(By.id("qty"), "3");

        //* Click on ‘Add to Cart’ Button.
        clickOnElement(By.id("product-addtocart-button"));

        //* Verify the text ‘You added Overnight Duffle to your shopping cart.’
        String expectedText1 = "You added Overnight Duffle to your shopping cart.";
        String actualText1 = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expectedText1, actualText1);

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        Thread.sleep(3000);

        //* Verify the product name ‘Cronus Yoga Pant’
        // String expectedText2 = "Cronus Yoga Pant";
        // String actualText2 = getTextFromElement(By.xpath("(//a[normalize-space()='Cronus Yoga Pant'])[2]"));
        // Assert.assertEquals(expectedText2, actualText2);

        //* Verify the Qty is ‘3’
        String expectedText3 = "3";
        String actualText3 = driver.findElement(By.xpath("//input[@title='Qty']")).getAttribute("value");
        //System.out.println(actualText3.getAttribute("value"));
        Assert.assertEquals(expectedText3, actualText3);

        //* Verify the product price ‘$135.00’
        String expectedText4 = "$135.00";
        String actualText4 = getTextFromElement(By.xpath("//td[@class='col subtotal']//span[@class='cart-price']"));
        Assert.assertEquals(expectedText4, actualText4);
        Thread.sleep(1000);

        //* Change Qty to ‘5’
        driver.findElement(By.xpath("//input[@title='Qty']")).clear();
        sendTextOnElement(By.xpath("//input[@title='Qty']"), "5");


        //* Click on ‘Update Shopping Cart’ button
        clickOnElement(By.xpath("//span[normalize-space()='Update Shopping Cart']"));

        //* Verify the product price ‘$225.00’
        String expectedText5 = "$225.00";
        String actualText5 = getTextFromElement(By.xpath("//span[contains(text(),'$225.00')]"));
        Assert.assertEquals(expectedText5, actualText5);
    }

    @After
    public void closingBrowser() {
        closeBrowser();
    }
}
