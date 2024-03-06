/* SearchFunc is a class used to find and control elements which are related to search function.*/

    /*............................................ Packages...........................................................*/

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




/*................................................................................................................*/


public class SearchFunc extends PageBase {

    public SearchFunc(WebDriver driver) {
        super(driver);
    }

    /*.........................................Variables and Objects..................................................*/
    Data dataObj;

    public String searchResult;
    public String autoSearchResult;


    /*............................................Page Elements.......................................................*/

    /*elements related to search function.*/
    @FindBy(id = "search_input")
    public WebElement searchBar;
    @FindBy(xpath = "//button[@class='ty-search-magnifier']")
    public WebElement searchIcon;

    @FindBy(xpath = "//span[text()='Search results']")
    public WebElement searchResultPage;

    @FindBy(linkText = "Asus 24 Inch VS248HR FHD TN 60Hz 1Ms Gaming Monitor")
    public WebElement asusProduct1;

    @FindBy(linkText = "Asus VP228DE 22 Inch FHD TN 60Hz 5Ms Eye Care Anti Glare Monitor")
    public WebElement asusLaptop2;

    @FindBy(id ="det_img_7580desktop")
    public WebElement firstProductOfPage2;
    @FindBy(id = "button_cart_5715")
    public WebElement addToCartIcon;

    @FindBy(id = "load_more_products_search_pagination_contents")
    public WebElement loadMoreButt;


    @FindBy(xpath = "//span[text()='2']")
    public WebElement pageNumber2;


    @FindBy(xpath = "//a[b='P Desktop']")
    public WebElement hpDesktop;

    @FindBy(linkText = "HP Omen 30L GT13-0380T Intel Core I7-10700K 1TB + 512GB SSD 16GB Ram Nvidia GeForce RTX 3090 24GB Win.10")
    public WebElement hpDesktopProduct;

    @FindBy(id ="sw_elm_filter_657_42")
    public WebElement availableFilter;
    @FindBy(xpath = "//*[@id=\"ranges_657_42\"]/li/label")
    public WebElement inStockFilter;

    @FindBy(xpath = "//*[@id=\"category_products_515\"]/div/a")
    public WebElement resetButt;

    @FindBy(xpath = "//div[text()='Sorry, nothing found for ']")
    public WebElement noProductFound;


    /*............................................Functions...........................................................*/

    /*
    @Func: function is used to simulate user search on the Website.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<searchResult> assert on the search page string, <addToCartIcon> assert on the visibility of cart icon,
                <loadMoreButt> assert on the visibility of load more button.
    */
    public void input_search()
    {

        dataObj = new Data();
        searchBar.click();

        searchBar.sendKeys(dataObj.searchInput);
        searchIcon.click();
        explicit_wait_fun(searchResultPage);
        searchResult = searchResultPage.getText();

    }

    /*
    @Func: function is used to simulate user search on the Website.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions: <loadMoreButt> assert on the visibility of load more button, <pageNumber2> assert if page number 2
                became active.
    */
    public void load_more_products()
    {
        page_explore(asusLaptop2);
        explicit_wait_fun(loadMoreButt);


        loadMoreButt.click();
        explicit_wait_fun(firstProductOfPage2);
        page_explore(loadMoreButt);


    }

    /*
    @Func: function is used to simulate user search on the Website with the help of the auto suggest service.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<hpDesktop> assert on the visibility of cart icon.

    */

    public void auto_suggest_search()
    {
        dataObj = new Data();
        searchBar.clear();
        searchBar.click();
        searchBar.sendKeys(dataObj.autoSuggestInput);
        explicit_wait_fun(hpDesktop);


    }

    /*
    @Func: function is used to simulate logging into another search result page from auto suggest search.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<autoSearchResult> assert on the string of a product content as a result of search.
    */
    public void auto_search_result_page()
    {
        hpDesktop.click();
        explicit_wait_fun(hpDesktopProduct);
        autoSearchResult = hpDesktopProduct.getText();
        hover_action(hpDesktopProduct);
    }


    /*
    @Func: function is used to simulate the filters effect on the search result.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<inStockFilter> assert on the visibility of inStock filter.
    */
    public void apply_filter_on_search_result()
    {
        availableFilter.click();
        explicit_wait_fun(inStockFilter);
        inStockFilter.click();
        explicit_wait_fun(resetButt);
    }

    /*
    @Func: function is used to simulate the response of the search result page after removing all filters.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<resetButt> assert on the visibility of inStock filter,
                <hpDesktopResult> assert on the effect of removing search filters.
    */
    public void remove_filter_on_search_result()
    {


        resetButt.click();
        explicit_wait_fun(hpDesktopProduct);

    }

    /*
    @Func: function is used to simulate the search result for invalid data.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<noProductFound> assert on the visibility of "no product found for" element.
    */
    public void invalid_search_input()
    {
        dataObj = new Data();
        searchBar.clear();
        searchBar.click();
        searchBar.sendKeys(dataObj.invalidInput);
        explicit_wait_fun(noProductFound);

    }
}
