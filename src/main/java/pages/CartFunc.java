/* CartFunc is a class used to find and control elements which are related to cart function.*/

    /*............................................ Packages...........................................................*/

package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/*................................................................................................................*/


public class CartFunc extends PageBase{
    public CartFunc(WebDriver driver) {
        super(driver);
    }
    /*.........................................Variables and Objects..................................................*/
    Data dataObj;




    /*............................................Page Elements.......................................................*/

    /*elements related to cart function.*/

    @FindBy(id = "button_cart_5715")
    public WebElement addToCartOfHoveredProduct;

    @FindBy(linkText = "Asus 24 Inch VS248HR FHD TN 60Hz 1Ms Gaming Monitor")
    public WebElement asusProduct1;

    @FindBy(xpath = "//bdi[text()='Continue shopping']")
    public WebElement continueShoppingButtAlertWindow;


    @FindBy(xpath = "//bdi[text()='Checkout']")
    public WebElement checkoutButtAlertWindow;

    @FindBy(id = "cart_icon_4700")
    public WebElement cartIcon;

    @FindBy(linkText = "View cart")
    public WebElement viewCartButt;

    @FindBy(xpath = "//bdi[text()='Checkout']")
    public WebElement checkoutButtCartIcon;

    @FindBy(xpath = "//bdi[text()='Clear cart']")
    public WebElement clearCartButt;



    @FindBy(xpath = "//p[text()='Your cart is empty']")
    public WebElement cartIsEmpty;

    @FindBy(id = "add_to_cart_update_7644")
    public WebElement inactiveCartIcon;

    @FindBy(id = "det_img_1669118989")
    public WebElement homePageButt;

    @FindBy(linkText = "HiLook THC-T123-P 2.8MM 1080mp 2 MP Ultra Low Light Indoor Fixed Turret Camera")
    public WebElement cameraProduct;

    @FindBy(id = "button_cart_4437")
    public WebElement addToCartOfProductPage;


    @FindBy(xpath = "//div[text()='\n" +
            "                                                                offers\n" +
            "                                        \n" +
            "                ']")
    public WebElement homePageOffer;

    @FindBy(xpath = "//div[text()='\n" +
            "                                                                Surveillance Systems\n" +
            "                                        \n" +
            "                ']")
    public WebElement surveillanceSystems;


    /*............................................Functions...........................................................*/

    /*
    @Func: function is used to simulate add products to cart from a search result.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<continueShoppingButtSearchPage> assert on the visibility of the button,
                <checkoutButtSearchPage> assert if the button is active.
    */
    public void add_search_result_to_cart()
    {
        hover_action(asusProduct1);
        explicit_wait_fun(addToCartOfHoveredProduct);

        addToCartOfHoveredProduct.click();
        explicit_wait_fun(continueShoppingButtAlertWindow);
        continueShoppingButtAlertWindow.click();
    }

    /*
    @Func: function is used to simulate to explore cart from a search result page.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions:<asusLaptop1> assert on the visibility of the product in the cart,
                <viewCartButt> assert on the visibility of the button in the cart icon,
                <checkoutButtCartIcon> assert if the button is active.
    */
    public void explore_cart_icon()
    {

        cartIcon.click();

    }

    /*
    @Func: function is used to simulate to add another product to cart from the home page.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions: <addToCartOfProductPage> assert on the visibility of the button in the product page.
                 <checkoutButtAlertWindow> assert on the add to cart alert is closed automatically.
    */
    public void add_another_product()
    {
        homePageButt.click();
        explicit_wait_fun(homePageOffer);
        page_explore(homePageOffer);
        page_explore(surveillanceSystems);
        cameraProduct.click();
        addToCartOfProductPage.click();
        explicit_wait_fun(continueShoppingButtAlertWindow);
        continueShoppingButtAlertWindow.click();


    }



    /*
    @Func: function is used to view the cart page and verify if the added items exist.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions: <asusLaptop1> assert on the visibility of the product,
                  <cameraProduct> assert on the visibility of the product.

    */
    public void cart_page_with_products()
    {
        cartIcon.click();
        explicit_wait_fun(viewCartButt);
        viewCartButt.click();



    }

    /*
    @Func: function is used to view the cart page and verify the cart is empty.
    @Param:
    @Return_value: no value will be returned by the function.
    @assertions: <cartIsEmpty> assert on the visibility of the element,
                  <cartIsEmpty> assert on the message of the empty cart.

    */
    public void empty_cart()
    {
        dataObj = new Data();

        page_explore(clearCartButt);
        clearCartButt.click();

    }




}
