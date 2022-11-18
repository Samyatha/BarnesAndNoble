package testScripts;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.ProductDetailPage;
import pageObjects.ProductListingPage;
import pageObjects.SearchPage;
import pageObjects.WelcomePage;
import utils.Configration;

/**
 * Precondition: User has no saved Addresses or Payment method Scenario: •Login
 * to BN Account •add an item to cart •proceed to checkout •AddShipping Address
 * and Payment method •Review the order •Place Order
 */
public class LoginWithNoSavedAddressOrPayment extends Configration {

	@Test(dataProvider = "getData")

	public void createAccount(HashMap<String, String> input) throws InterruptedException {
		WelcomePage signin = new WelcomePage(driver);
		LoginPage login = new LoginPage(driver);
		ProductDetailPage pdp = new ProductDetailPage(driver);
		SearchPage search = new SearchPage(driver);
		ProductListingPage AddtoCart = new ProductListingPage(driver);
		CartPage cart = new CartPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);

		/** Tap on Signin button */
		signin.tapSign();

		/** Enters Email address */
		login.enterEmail(input.get("Email"));

		/** Enters Password */
		login.enterPassword(input.get("Password"));
		Thread.sleep(3000);

		/** Logins to BN App */
		login.continueSignin();
		Thread.sleep(10000);

		/** Searches for the keyword */
		search.Searchbar("into the wild");
		Thread.sleep(20000);

		/** Adds an item to the cart from Product listing page */
		AddtoCart.ClickAddtocart(0);
		Thread.sleep(5000);

		/** Taps on Cart icon */
		cart.ClickCartIcon();
		Thread.sleep(15000);

		/** Taps on the checkout button */
		cart.TapCheckoutbutton();
		Thread.sleep(15000);

		/** Taps Add Shipping Address */
		checkout.TapAddShippingAddress();
		Thread.sleep(5000);

		/** Taps on Country dropdown and selects the county name */
		// checkout.CountryName(input.get("Countryname"));

		/** Enters the first name */
		checkout.EnterFirstName(input.get("Fname"));

		/** Enters the last name */
		checkout.EnterLastName(input.get("Lname"));

		/** Enters Address line 1 */
		checkout.Address1(input.get("Address1"));

		/** Enters City name */
		checkout.CityName(input.get("City"));

		/** Taps on State dropdown and selects the state */
		checkout.StateName(input.get("State"));
		Thread.sleep(2000);

		/** Enters zip code */
		checkout.Zip(input.get("ZipCode"));

		/** Enters Phone number */
		checkout.PhoneNum(input.get("PhoneNumber"));

		/** Taps on Continue button */
		checkout.TapContinue();
		Thread.sleep(2000);
	}

	/**
	 * Required details are captured from json file
	 * 
	 * @return 1st set of elements
	 */
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				"C:\\Users\\Girish\\eclipse-workspace\\BarnesAndNoble\\src\\test\\java\\testData\\LoginDetails.json");

		return new Object[][] { { data.get(0) } };
	}
}
