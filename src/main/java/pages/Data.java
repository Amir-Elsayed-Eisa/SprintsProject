/* Data class is used to provide data  */

package pages;


import com.github.javafaker.Faker;

public class Data {

    Faker faker = new Faker();


    public String searchInput = "asus";

    public String autoSuggestInput = "h";

    public String searchPage = "Search results";

    public String hpProduct =
            "HP Omen 30L GT13-0380T Intel Core I7-10700K 1TB + 512GB SSD 16GB Ram Nvidia GeForce RTX 3090 24GB Win.10";
    public String invalidInput = "#";

    public String emptyCart = "Your cart is empty";

    public String fullName = faker.name().fullName();

    public String phone = faker.phoneNumber().phoneNumber();

    public String address = faker.address().fullAddress();

    public String zipCode = faker.address().zipCode();

}
