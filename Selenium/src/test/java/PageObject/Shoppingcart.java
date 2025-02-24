package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class Shoppingcart {
    
    @FindBy(name = "proceedToRetailCheckout")
    WebElement proceedToCheckoutButton;

    // Constructor to initialize the elements using PageFactory
    public Shoppingcart(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    // Method to click the Proceed to Checkout button
    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}
