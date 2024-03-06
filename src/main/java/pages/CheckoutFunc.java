/* CartFunc is a class used to find and control elements which are related to the checkout function.*/


/*............................................ Packages...........................................................*/


package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



/*................................................................................................................*/

public class CheckoutFunc extends PageBase{

    /*.........................................Variables and Objects..................................................*/
    Data dataObj;


    public CheckoutFunc(WebDriver driver) {
        super(driver);
    }


    /*............................................Page Elements.......................................................*/



    @FindBy(id ="litecheckout_place_order")
    public WebElement placeOrderButt;

    @FindBy(id = "litecheckout_fullname")
    public WebElement fullNameField;

    @FindBy(id = "litecheckout_phone")
    public WebElement phoneField;

    @FindBy(id = "litecheckout_phone_error_message")
    public WebElement phoneMandatoryField;

    @FindBy(linkText = "Add")
    public WebElement addPromoCode;

    @FindBy(id = "sw_litecheckout_step_billing_address_suffix_no")
    public WebElement changeBillingAddressLabel;


    @FindBy(xpath = "//bdi[text()='Proceed to checkout']")
    public WebElement proceedToCheckoutButt;


    @FindBy(linkText = "Asus 24 Inch VS248HR FHD TN 60Hz 1Ms Gaming Monitor")
    public WebElement asusProduct1;

    @FindBy(xpath = "//h2[text()='Delivery']")
    public WebElement deliveryInfoPart;

    @FindBy(id = "litecheckout_s_address")
    public WebElement addressField;

    @FindBy(id = "litecheckout_s_zipcode")
    public WebElement zipCodeField;

    @FindBy(id = "litecheckout_s_zipcode_error_message")
    public WebElement zipCodeMandatoryMessage;

    @FindBy(id = "shipping_rates_list")
    public WebElement updateShippingRateHint;

    @FindBy(xpath = "//div[text()='\n" +
            "                                                            shipping Cost — ']")
    public WebElement shippingCost;

    @FindBy(xpath = "//h2[text()='Payment methods']")
    public WebElement paymentMethodPart;


    @FindBy(xpath = "//div[text()='\n" +
            "                    Cash on Delivery\n" +
            "                ']")
    public WebElement paymentMethod;

    @FindBy(xpath = "//div[p='This means that when you receive your order... you will pay cash on delivery']")
    public WebElement paymentHint;

    @FindBy(id ="litecheckout_s_address_error_message")
    public WebElement addressMandatoryMessage;

    @FindBy(id = "litecheckout_comment_to_shipping")
    public WebElement customerNotesField;


    /*............................................Functions...........................................................*/

    /*
    @Func: function is used to check user elements.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<fullNameField>, <phoneField>, <addPromoCode>, <changeBillingAddressLabel>, <asusProduct1> assert on the visibility of the button,

    */
    public void check_elements_of_customer_info()
    {
        explicit_wait_fun(proceedToCheckoutButt);
        proceedToCheckoutButt.click();
        explicit_wait_fun(fullNameField);



    }

    /*
    @Func: function is used to check order delivery information.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<addressField>,<zipCodeField>,<shippingCost>,<updateShippingRateHint>, assert on the visibility of the button.
    */
    public void check_order_delivery_info()
    {

        page_explore(deliveryInfoPart);
        addressField.clear();
        zipCodeField.clear();

    }

    /*
    @Func: function is used to check the payment information.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<paymentMethod>,<paymentHint>,<customerNotesField>, assert on the visibility of the button.
    */
    public void check_payment_method_info()
    {
        page_explore(paymentMethodPart);

    }

    /*
    @Func: function is used to check if the user can check out without signing in.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<phoneMandatoryField> assert on the visibility of the mandatory message.
    */
    public void check_out_without_sign_in()
    {
        placeOrderButt.click();
        explicit_wait_fun(phoneMandatoryField);
    }

    /*
    @Func: function is used to provide user information.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:
    */
    public void cs_provide_info()
    {

        dataObj = new Data();
        fullNameField.sendKeys(dataObj.fullName);
        phoneField.sendKeys(dataObj.phone);

    }

    /*
    @Func: function is used to check if user can check out without address and zip code.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<addressMandatoryMessage>,<zipCodeMandatoryMessage> assert on the visibility of the mandatory message.
    */
    public void check_out_without_address_info()
    {
        page_explore(deliveryInfoPart);
        placeOrderButt.click();
        explicit_wait_fun(addressMandatoryMessage);
        explicit_wait_fun(zipCodeMandatoryMessage);

    }



}
