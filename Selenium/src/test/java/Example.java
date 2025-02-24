import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageObject.Createaccount;
import PageObject.HomePage;
import PageObject.Searchpage;
import PageObject.Shoppingcart;

public class Example {

    public static void main(String[] args) {
        
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
              
        ExtentTest test = extent.createTest("Amazon Shopping Test", "Test to automate searching, adding to cart, and creating an account");
        
        System.setProperty("webdriver.edge.driver", "C:\\Users\\jayas\\eclipse-workspace\\Selenium\\Drivers\\Edge\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        try {
            
            driver.get("https://www.amazon.com/");
            driver.manage().window().maximize();
            test.info("Amazon website launched");

            Thread.sleep(5000); 
            
            HomePage homePage = new HomePage(driver);
            homePage.searchForProduct("shirt");
            test.info("Searched for product: shirt");
            
            Searchpage searchResultsPage = new Searchpage(driver);
            searchResultsPage.selectFirstProduct();
            test.info("Selected first product from search results");
            
            searchResultsPage.addToCart();
            test.info("Added product to cart");
           
            Shoppingcart cartPage = new Shoppingcart(driver);
            cartPage.proceedToCheckout();
            test.info("Proceeded to checkout");

            Thread.sleep(5000); 
            
            Createaccount createacc = new Createaccount(driver);
            createacc.createaccountnew();
            createacc.login("asdfgh", "sample1234@gmail.com", "Amazon@12345");
            test.info("Created a new account and logged in");
            
            test.pass("Test passed successfully");

        } catch (Exception e) {
            
            test.fail("Test failed due to exception: " + e.getMessage());
            
        } finally {
            
            driver.quit();
            test.info("Closed the browser");
           
            extent.flush();
        }
    }
}
