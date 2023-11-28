package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

/**
 * userShouldAddProductSuccessFullyToShoppinCart()
 * Mouse Hover on Men Menu
 * Mouse Hover on Bottoms
 * Click on Pants
 * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on size 32.
 * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on colour Black.
 * Mouse Hover on product name
 * ‘Cronus Yoga Pant’ and click on
 * ‘Add To Cart’ Button.
 * Verify the text
 * ‘You added Cronus Yoga Pant to your shopping cart.’
 * Click on ‘shopping cart’ Link into message
 * Verify the text ‘Shopping Cart.’
 * Verify the product name ‘Cronus Yoga Pant’
 * Verify the product size ‘32’
 * Verify the product colour ‘Black’
 */

public class MenTest extends Utility {

    String baseUrl = "https://magento.softwaretestingboard.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldAddProductSuccessFullyToShoppingCart() {
        // Mouse Hover on Men Menu
        mouseHoverToElement(By.id("ui-id-5"));

        // Mouse Hover on Bottoms
        mouseHoverToElement(By.id("ui-id-18"));

        //* Click on Pants
        clickOnElement(By.id("ui-id-23"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on size 32.
        mouseHoverToElementAndClick(By.id("option-label-size-143-item-175"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on colour Black.
        mouseHoverToElementAndClick(By.id("option-label-color-93-item-49"));

        //* Mouse Hover on product name ‘Cronus Yoga Pant’ and click on ‘Add To Cart’ Button.
        mouseHoverToElementAndClick(By.xpath("(//button[@title='Add to Cart'])[1]"));

        //* Verify the text ‘You added Cronus Yoga Pant to your shopping cart.’
        String expectedText = "You added Cronus Yoga Pant to your shopping cart.";
        String actualText = getTextFromElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));
        Assert.assertEquals(expectedText, actualText);

        //* Click on ‘shopping cart’ Link into message
        clickOnElement(By.xpath("//a[text()='shopping cart']"));

        //* Verify the text ‘Shopping Cart.’
        String expectedText1 = "Shopping Cart";
        String actualText1 = getTextFromElement(By.xpath("//span[@data-ui-id='page-title-wrapper']"));
        Assert.assertEquals(expectedText1, actualText1);

        //* Verify the product name ‘Cronus Yoga Pant’
        String expectedText2 = "Cronus Yoga Pant";
        String actualText2 = getTextFromElement(By.xpath("//td[@class='col item']//a[normalize-space()='Cronus Yoga Pant']"));
        Assert.assertEquals(expectedText2, actualText2);

        //* Verify the product size ‘32’
        String expectedText3 = "32";
        String actualText3 = getTextFromElement(By.xpath("//dd[contains(text(),'32')]"));
        Assert.assertEquals(expectedText3, actualText3);

        //* Verify the product colour ‘Black’
        String expectedText4 = "Black";
        String actualText4 = getTextFromElement(By.xpath("//dd[contains(text(),'Black')]"));
        Assert.assertEquals(expectedText4, actualText4);
    }

    @After
    public void closingBrowser() {
        closeBrowser();
    }
}
