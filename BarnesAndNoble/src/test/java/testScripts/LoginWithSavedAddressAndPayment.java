package testScripts;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.LoginPage;
import pageObjects.ProductListingPage;
import pageObjects.SearchPage;
import pageObjects.WelcomePage;
import utils.Configration;

/**
 * Precondition: User has saved shipping Address and Payment method •Login to BN
 * App •Search for the keyword •Add an item to cart •Proceed to checkout •Review
 * the order •Place order after verifying CVV
 */
public class LoginWithSavedAddressAndPayment extends Configration {
	@Test(dataProvider = "getData")
	public void createAccount(HashMap<String, String> input) throws Throwable {
		WelcomePage signin = new WelcomePage(driver);
		LoginPage login = new LoginPage(driver);
		ProductListingPage AddtoCart = new ProductListingPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		SearchPage search = new SearchPage(driver);
		CartPage cart = new CartPage(driver);

		/** Taps on Signin */
		signin.tapSign();

		/** Enters the email address */
		login.enterEmail(input.get("Email"));

		/** Enters the password */
		login.enterPassword(input.get("Password"));
		Thread.sleep(3000);

		/** Taps on Signin button */
		login.continueSignin();
		Thread.sleep(10000);

		/** Enters the keyword in the Search bar */
		search.Searchbar("into the wild");
		Thread.sleep(20000);

		/** Add an item to cart */
		AddtoCart.ClickAddtocart(0);
		Thread.sleep(5000);

		/** Taps on Cart icon */
		cart.ClickCartIcon();
		Thread.sleep(10000);

		/** Taps on Checkout button */
		cart.TapCheckoutbutton();
		Thread.sleep(20000);

		/** Taps on Place Order button */
		checkout.TapPlaceOrder();
		Thread.sleep(10000);
		String orderplacedmsg = driver
				.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Thank you for your order.']")).getText();
		Assert.assertEquals(orderplacedmsg, "Thank you for your order.");
		if (orderplacedmsg.equals("Thank you for your order.")) {
			System.out.println("Order Placed Successfully");
		} else {

			/** Enters the CVV */
			checkout.verifyCvv("382");
			Thread.sleep(3000);

			/** Taps on Confirm to Continue button */
			checkout.TapConfirmNContinue();
			Thread.sleep(10000);
		}
	}

	/** Required data is driven from json file */
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				"C:\\Users\\Girish\\eclipse-workspace\\BarnesAndNoble\\src\\test\\java\\testData\\OldUserLoginDetails.json");

		return new Object[][] { { data.get(0) } };
	}
}
