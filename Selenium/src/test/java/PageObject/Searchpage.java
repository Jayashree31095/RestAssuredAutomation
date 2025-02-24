package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Searchpage {
	
	WebDriver driver;
    
    @FindBy(xpath = "(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")
    WebElement firstProduct;
    
    //@FindBy(id = "buybox-see-all-buying-choices")
    WebElement seeallbuyingoptions;
    
    @FindBy(id = "add-to-cart-button")
   WebElement addToCartButton;
    
    @FindBy(xpath = "//i[@class='a-icon aod-close-button']")
    WebElement closebutton;

    public Searchpage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void selectFirstProduct() {
        firstProduct.click();
    }
    
    public void addToCart() {
    	//seeallbuyingoptions.click();
    	    	
    	 /*WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='productTitle']")));
        System.out.println("Product Title: " + productTitle.getText());
        
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='a-autoid-2-offer-1-announce']")));*/
        addToCartButton.click();
    }
    
   
}

