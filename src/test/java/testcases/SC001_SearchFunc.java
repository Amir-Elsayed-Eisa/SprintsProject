/* SC_001_SearchFunc is a class used to execute TCs related to SC_001 */

/*............................................ Packages...........................................................*/

package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Data;
import pages.SearchFunc;



public class SC001_SearchFunc extends TestBase{

    /*.........................................Variables and Objects..................................................*/
    SearchFunc searchObj;
    Data dataObj;

    /*............................................Functions...........................................................*/

    @Test(priority = 1)
    public void input_search_test()  {
        searchObj = new SearchFunc(driver);
        dataObj = new Data();

        searchObj.input_search();
        Assert.assertEquals(searchObj.searchResult, dataObj.searchPage);

    }

    @Test(priority = 2)
    public void load_more_products_to_search_result()
    {
        searchObj = new SearchFunc(driver);
        searchObj.load_more_products();
        Assert.assertTrue(searchObj.loadMoreButt.isDisplayed());
        Assert.assertTrue(searchObj.pageNumber2.isEnabled());

    }

    @Test(priority = 3)
    public void auto_suggest_search_test()  {
        searchObj = new SearchFunc(driver);
        searchObj.auto_suggest_search();
        Assert.assertTrue(searchObj.hpDesktop.isDisplayed());
        searchObj.auto_search_result_page();
        Assert.assertEquals(dataObj.hpProduct, searchObj.autoSearchResult);

    }

    @Test(priority = 4)
    public void user_can_filter_search_results()
    {
        searchObj = new SearchFunc(driver);
        searchObj.apply_filter_on_search_result();
        Assert.assertTrue(searchObj.inStockFilter.isDisplayed());
        Assert.assertTrue(searchObj.resetButt.isDisplayed());

    }

    @Test(priority = 5)
    public void user_can_remove_search_filter()
    {
        searchObj = new SearchFunc(driver);
        searchObj.remove_filter_on_search_result();
        Assert.assertEquals(searchObj.hpDesktopProduct.getText(), dataObj.hpProduct);
    }

    @Test(priority = 6)
    public void user_enter_invalid_search_data()
    {
        searchObj = new SearchFunc(driver);
        searchObj.invalid_search_input();
        Assert.assertTrue(searchObj.noProductFound.isDisplayed());
    }
}
