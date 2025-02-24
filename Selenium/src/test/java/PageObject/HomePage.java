package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

    @FindBy(id = "twotabsearchtextbox")
    WebElement searchBox;
    
    @FindBy(id = "nav-search-submit-button")
    WebElement searchButton;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void searchForProduct(String keyword) {
        searchBox.sendKeys(keyword);
        searchButton.sendKeys(Keys.RETURN);
    }
}
