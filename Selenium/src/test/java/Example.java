import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.Createaccount;
import PageObject.HomePage;
import PageObject.Searchpage;
import PageObject.Shoppingcart;

public class Example {

    public static void main(String[] args) {
        
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jayas\\eclipse-workspace\\Selenium\\Drivers\\ChromeDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        
        try {
            Thread.sleep(5000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        HomePage homePage = new HomePage(driver);
        homePage.searchForProduct("shirt");
        
        Searchpage searchResultsPage = new Searchpage(driver);
        searchResultsPage.selectFirstProduct();
        
        searchResultsPage.addToCart();
                
        Shoppingcart cartPage = new Shoppingcart(driver);
        cartPage.proceedToCheckout();
        
        try {
            Thread.sleep(5000);  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        //driver.switchTo().frame("checkout-pref-init-and-store");
        Createaccount createacc = new Createaccount(driver);
        createacc.createaccountnew();
        createacc.login("asdfgh","sample1234@gmail.com","Amazon@12345");
        
        System.out.println("Test passed");
        
        driver.quit();
    }
}
