package PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Createaccount {
	
	WebDriver driver;
    
	@FindBy(id = "createAccountSubmit")
    WebElement createaccount;
	
	@FindBy(id = "ap_customer_name")
    WebElement yourname;
	
	@FindBy(id = "ap_email")
    WebElement youremail;
	
	@FindBy(id = "ap_password")
    WebElement yourpswd;
	
	@FindBy(id = "ap_password_check")
    WebElement yourre_enterpswd;
	
	@FindBy(id = "continue")
    WebElement createacc;
    
    public Createaccount(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    
    public void createaccountnew() {
    	
    	createaccount.click();
    }
    
    public void login(String username, String email, String password) {
    	yourname.sendKeys(username);  
        youremail.sendKeys(email); 
        yourpswd.sendKeys(password); 
        yourre_enterpswd.sendKeys(password); 
        createacc.click(); 
    }
    




}
