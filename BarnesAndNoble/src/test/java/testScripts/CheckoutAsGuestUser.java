package testScripts;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ProductDetailPage;
import pageObjects.ProductListingPage;
import pageObjects.SearchPage;
import pageObjects.WelcomePage;
import utils.Configration;

/**
 * Precondition: User is Guest Scenario: •Enter As Guest •Search for product
 * •Add to cart •Continue as Guest •Add shipping address and payment methods
 * •Review the order •Place order
 */

public class CheckoutAsGuestUser extends Configration

{
	@Test
	public void login() throws Exception {

		WelcomePage GuestCheckout = new WelcomePage(driver);
		ProductDetailPage AddtoCart = new ProductDetailPage(driver);
		SearchPage search = new SearchPage(driver);
		CheckoutPage checkout = new CheckoutPage(driver);
		CartPage cart = new CartPage(driver);

		/** Selects Enter As Guest Option from Welcome page */
		GuestCheckout.tapEnterAsGuest();
		Thread.sleep(3000);

		/** Search the product through its EAN */
		search.Searchbar("9780143105466");
		Thread.sleep(15000);

		/** Adds an item to cart from PDP */
		AddtoCart.ClickAddtocart();

		/** Taps on Cart icon */
		cart.ClickCartIcon();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(AppiumBy.xpath("//android.view.View[@text='Cart']"), "text",
				"Cart"));
		Thread.sleep(5000);

		/** Taps on Checkout button */
		cart.TapCheckoutbutton();
		Thread.sleep(3000);

		/** Selects "continue as guest" option */
		cart.TapCheckoutbutton();

		// Need to call continue as guest method
		Thread.sleep(10000);

		/** Enters first name */
		checkout.EnterFirstName("test");

		/** Enters last name */
		checkout.EnterLastName("test");

		/** Enters Address line1 */
		checkout.Address1("test");

		/** Enters City name */
		checkout.CityName("test");

		/** Selects State name from dropdown */
		checkout.StateName("WA");

		/** Enters zip code */
		checkout.Zip("98121");

	}

}
