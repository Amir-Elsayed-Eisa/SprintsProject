/* SC_002_CartFunc is a class to execute the TCs of SC_002 of the cart function */

    /*............................................ Packages...........................................................*/

package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartFunc;
import pages.Data;
import pages.SearchFunc;


/*................................................................................................................*/
public class SC002_CartFunc extends TestBase{

    /*.........................................Variables and Objects..................................................*/
    CartFunc cartObj;
    SearchFunc searchObj;

    Data dataObj;


    /*............................................Functions...........................................................*/

    @Test(priority = 1)
    public void add_product_from_search_page()
    {
        cartObj = new CartFunc(driver);
        searchObj = new SearchFunc(driver);
        searchObj.input_search();
        cartObj.add_search_result_to_cart();
        Assert.assertTrue(cartObj.continueShoppingButtAlertWindow.isDisplayed());
        Assert.assertTrue(cartObj.checkoutButtAlertWindow.isEnabled());

    }

    @Test(priority = 2)
    public void cart_icon_shows_added_product()
    {
        cartObj = new CartFunc(driver);
        cartObj.explore_cart_icon();
        Assert.assertTrue(cartObj.asusProduct1.isDisplayed());
        Assert.assertTrue(cartObj.viewCartButt.isDisplayed());
        Assert.assertTrue(cartObj.checkoutButtCartIcon.isEnabled());

    }

    @Test(priority = 3)
    public void add_more_than_one_item()
    {
        cartObj = new CartFunc(driver);
        cartObj.add_another_product();
        Assert.assertTrue(cartObj.continueShoppingButtAlertWindow.isDisplayed());
        Assert.assertTrue(cartObj.checkoutButtAlertWindow.isEnabled());
    }


    @Test(priority = 4)
    public void added_products_shows_in_cart()
    {
        cartObj = new CartFunc(driver);
        cartObj.cart_page_with_products();
        Assert.assertTrue(cartObj.asusProduct1.isDisplayed());
        Assert.assertTrue(cartObj.cameraProduct.isDisplayed());

    }

    @Test(priority = 5)
    public void verify_if_cart_is_empty()
    {
        dataObj = new Data();
        cartObj = new CartFunc(driver);

        cartObj.empty_cart();
        Assert.assertTrue(cartObj.cartIsEmpty.isDisplayed());
        Assert.assertEquals(cartObj.cartIsEmpty.getText(), dataObj.emptyCart);
    }


}
