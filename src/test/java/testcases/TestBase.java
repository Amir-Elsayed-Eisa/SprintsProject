
/*  TestBase is a class used to initiate the browser and control events of the test processes */

/*  packages are used by functions */
package testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;



public class TestBase {

    public static WebDriver driver;     //An object from the WebDriver library.

    /*
    @Func: function is used to initiate the Chrome browser and navigate to the website.
    @Param:
    @Return_value: no value will be returned by the function.
    */
    @BeforeClass
    public void startDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver = new FirefoxDriver();


        driver.manage().window().maximize();
        driver.navigate().to("https://egyptlaptop.com/");

    }


    /*
        @Func: function is used to close the Chrome browser.
        @param:
        @Return_value: no value will be returned by the function.
     */
    @AfterClass                 //Notation for The time frame of the function to be executed after the test suites.
    public void QuitDriver() {

        driver.quit();

    }

    /*
        @Func: function is used to generate a screenshot for a specific event that prevent the test method to be done.
        @param:
        @Return_value: no value will be returned by the function.
     */

    @AfterMethod            //Notation for The time frame of the function to be executed after each test method.
    public void screenshotOnFailure(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE){
            System.out.println("Failed");
            System.out.println("Taking a screenshot");
            Helper.captureScreenshot(driver, result.getName());
        }else {
            System.out.println("Test is good");
        }
    }
}
