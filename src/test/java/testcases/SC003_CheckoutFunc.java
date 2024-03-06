/* SC_003_CheckoutFunc is a class to execute the TCs of SC_003 of the checkout function */

/*............................................ Packages...........................................................*/

package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartFunc;
import pages.CheckoutFunc

/*................................................................................................................*/

;
import pages.SearchFunc;

public class SC003_CheckoutFunc extends TestBase{


    /*.........................................Variables and Objects..................................................*/
     CheckoutFunc checkoutObj;
    CartFunc cartObj;
    SearchFunc searchObj;

    /*............................................Functions...........................................................*/

    @Test(priority = 1)
    public void customer_info_check()
    {
        cartObj = new CartFunc(driver);
        searchObj = new SearchFunc(driver);
        checkoutObj = new CheckoutFunc(driver);

        searchObj.input_search();
        cartObj.add_search_result_to_cart();
        cartObj.cart_page_with_products();

        checkoutObj.check_elements_of_customer_info();
        Assert.assertTrue(checkoutObj.fullNameField.isDisplayed());
        Assert.assertTrue(checkoutObj.phoneField.isDisplayed());
        Assert.assertTrue(checkoutObj.addPromoCode.isDisplayed());
        Assert.assertTrue(checkoutObj.changeBillingAddressLabel.isDisplayed());
        Assert.assertTrue(checkoutObj.asusProduct1.isDisplayed());

        checkoutObj.check_order_delivery_info();
        Assert.assertTrue(checkoutObj.addressField.isDisplayed());
        Assert.assertTrue(checkoutObj.zipCodeField.isDisplayed());
        Assert.assertTrue(checkoutObj.shippingCost.isDisplayed());
        Assert.assertTrue(checkoutObj.updateShippingRateHint.isDisplayed());

        checkoutObj.check_payment_method_info();
        Assert.assertTrue(checkoutObj.paymentMethod.isDisplayed());
        Assert.assertTrue(checkoutObj.paymentHint.isDisplayed());
        Assert.assertTrue(checkoutObj.customerNotesField.isDisplayed());
    }


    @Test(priority = 2)
    public void cs_can_not_place_order_before_sign_in()
    {
        checkoutObj = new CheckoutFunc(driver);
        checkoutObj.check_out_without_sign_in();
        Assert.assertTrue(checkoutObj.phoneMandatoryField.isDisplayed());
    }

    @Test(priority = 3)
    public void cs_can_not_place_order_without_address()
    {
        checkoutObj = new CheckoutFunc(driver);

        checkoutObj.cs_provide_info();
        checkoutObj.check_out_without_address_info();
        Assert.assertTrue(checkoutObj.addressMandatoryMessage.isDisplayed());
        Assert.assertTrue(checkoutObj.zipCodeMandatoryMessage.isDisplayed());
    }


}
