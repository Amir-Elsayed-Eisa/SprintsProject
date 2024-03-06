/* PageBase is a class used to initiate a driver to control pages and find the pages' elements.  */

    /*............................................ Packages...........................................................*/

package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/*................................................................................................................*/

public class PageBase {

    /*.........................................Variables and Objects..................................................*/

    protected WebDriver driver;

    public Actions actions;


    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    /*............................................Functions...........................................................*/

    /*
    @Func: function is used to explore pages by scrolling down/up.
    @Param:
    @Return_value: no value will be returned by the function.
    */
    public void page_explore(WebElement element) {
        JavascriptExecutor scroll = (JavascriptExecutor) driver;
        scroll.executeScript("arguments[0].scrollIntoView(true)", element);

    }



    /*
    @Func: function is used to hover on Web Elements.
    @Param: <elementName> "parameter is used to specify a Web Element to be hovered"
    @Return_value: no value will be returned by the function.
    */
    public void hover_action(WebElement elementName){
        actions = new Actions(driver);
        actions.moveToElement(elementName).build().perform();
    }

    /*
    @Func: function is used to wait until an element to be visible.
    @Param: <elementToShow> "parameter is used to specify a WebElement to be visible"
    @Return_value: no value will be returned by the function.
    */
    public void explicit_wait_fun(WebElement elementToShow)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(elementToShow));

    }

    /*
    @Func: function is used to wait until an element to be clickable.
    @Param: <elementToClick> "parameter is used to verify if a WebElement to be clickable"
    @Return_value:no value to return.
    */
    public void explicit_wait_click_element(WebElement elementToClick)
    {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(elementToClick));
    }

    /*
    @Func: function is used to select element from list.
    @Param: <element> "parameter is used to specify an element to be visible"
    @Return_value: no value will be returned by the function.
    */
    public void select_element_from_list(WebElement element)
    {
        Select select = new Select(element);
    }

}
