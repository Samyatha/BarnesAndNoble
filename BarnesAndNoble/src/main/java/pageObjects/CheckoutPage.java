package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import utils.AndroidAction;

/** Captured the elements in the Checkout page */
public class CheckoutPage extends AndroidAction {
	AppiumDriver driver;

	public CheckoutPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.Button[@index='4']")
	private WebElement addShippingAddressbutton;

	@FindBy(xpath = "//android.widget.ImageView[@index='2']")
	private WebElement countrydropdown;

	@FindBy(xpath = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.widget.EditText")
	private WebElement firstNameTextfield;

	@FindBy(xpath = "//android.view.ViewGroup[3]/android.view.ViewGroup/android.widget.EditText")
	private WebElement lastNameTextfield;

	@FindBy(xpath = "//android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.EditText")
	private WebElement addressLine1Textfield;

	@FindBy(xpath = "//android.view.ViewGroup[5]/android.view.ViewGroup/android.widget.EditText")
	private WebElement addressLine2Textfield;

	@FindBy(xpath = "//android.view.ViewGroup[6]/android.view.ViewGroup/android.widget.EditText")
	private WebElement cityTextfield;

	@FindBy(xpath = "//android.view.ViewGroup[7]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup")
	private WebElement statedropdown;

	@FindBy(xpath = "//android.view.ViewGroup[8]/android.view.ViewGroup/android.widget.EditText")
	private WebElement zipCodeTextfield;

	@FindBy(xpath = "//android.view.ViewGroup[9]/android.view.ViewGroup/android.widget.EditText")
	private WebElement phoneNumberTextfield;

	@FindBy(xpath = "//android.widget.TextView[@text='Company Name']")
	private WebElement companyTextfield;

	@FindBy(xpath = "//android.widget.Button[@index='0']")
	private WebElement continueButton;

	@FindBy(xpath = "//android.widget.ImageView[@index='0']")
	private WebElement selectAddressRadiobutton;

	@FindBy(xpath = "//android.widget.Button[@index='0']")
	private WebElement SelectAddressbutton;

	@FindBy(xpath = "//android.widget.Button[@index='3']")
	private WebElement addCreditorDebitButton;

	@FindBy(xpath = "//android.widget.TextView[@text='Cardholder Name']")
	private WebElement cardNameTextfield;

	@FindBy(xpath = "//android.widget.TextView[@text='Card Number']")
	private WebElement cardNumberTextfield;

	@FindBy(xpath = "//android.widget.TextView[@text='EXP (MM/YY)']")
	private WebElement expiryTextfield;

	@FindBy(xpath = "//android.widget.TextView[@text='CVV']")
	private WebElement CVVTextfield;

	@FindBy(xpath = "//android.widget.Button[@index='1']")
	private WebElement applyInCheckoutButton;

	@FindBy(xpath = "//android.widget.Button[@index='0']")
	private WebElement placeOrderbutton;

	@FindBy(xpath = "//android.widget.EditText[@index='0']")
	private WebElement verifyCVVTextfield;

	@FindBy(xpath = "//android.widget.Button[@index='3']")
	private WebElement confirmToContinuebutton;

	/** Tap on Add Shipping Address button */
	public void TapAddShippingAddress() throws InterruptedException {
		addShippingAddressbutton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Add Shipping Address']")));
	}

	/** Select Country Name from dropdown (by default USA would be selected */
	public void CountryName(String country) {
		scrollToText(country);
		if (countrydropdown.getText().equals(country)) {
			countrydropdown.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
			}

			driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='" + country + "']")).click();
		}
	}

	/** Enters firstName and closes the keyboard */
	public void EnterFirstName(String fname) {
		firstNameTextfield.click();
		firstNameTextfield.sendKeys(fname);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Enters lastName and and closes the keyboard */
	public void EnterLastName(String lname) {
		lastNameTextfield.click();
		lastNameTextfield.sendKeys(lname);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Enters Address1 and and closes the keyboard */
	public void Address1(String address1) {
		addressLine1Textfield.click();
		addressLine1Textfield.sendKeys(address1);
		((HidesKeyboard) driver).hideKeyboard();

	}

	/** Enters Address2 and and closes the keyboard */
	public void Address2(String address2) {
		addressLine2Textfield.click();
		addressLine2Textfield.sendKeys(address2);
		((HidesKeyboard) driver).hideKeyboard();

	}

	/** Enters city and and closes the keyboard */
	public void CityName(String city) {
		scrollToEnd();
		cityTextfield.click();
		cityTextfield.sendKeys(city);
		((HidesKeyboard) driver).hideKeyboard();

	}

	/** Taps on State dropdown and selects the desired state */
	public void StateName(String state) throws InterruptedException {
		scrollToEnd();
		statedropdown.click();
		scrollToText(state);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.ViewGroup[@index='2']")));
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@index='2']")).click();

	}

	/** Enters the zipcode and and closes the keyboard */
	public void Zip(String zip) {
		zipCodeTextfield.sendKeys(zip);
		((HidesKeyboard) driver).hideKeyboard();

	}

	/** Enters the phone number and and closes the keyboard */
	public void PhoneNum(String phone) {
		phoneNumberTextfield.sendKeys(phone);
		((HidesKeyboard) driver).hideKeyboard();

	}

	/** Enters the Company Name and and closes the keyboard */
	public void CompanyName(String CName) {
		companyTextfield.sendKeys(CName);
		((HidesKeyboard) driver).hideKeyboard();

	}

	/** Scrolls the page and taps on Continue button */
	public void TapContinue() {
		scrollToEnd();
		continueButton.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				AppiumBy.xpath("//android.widget.TextView[@content-desc=\"We didn't recognize your address\"]")));
	}

	/**
	 * Selects the radio button from the list of addresses in "verify your address"
	 * page
	 */
	public void AddressSelection() {
		selectAddressRadiobutton.click();
	}

	/** Taps on Select Address button */
	public void TapSelectAddress() {
		SelectAddressbutton.click();
	}

	/** Taps on Add Credit/Debit button */
	public void AddPayment() {
		addCreditorDebitButton.click();
	}

	/** Enters the Card name and closes the keyboard */
	public void EnterCardName(String NameOnCard) {
		cardNameTextfield.sendKeys(NameOnCard);
		((HidesKeyboard) driver).hideKeyboard();

	}

	/** Enters the card number and closes the keyboard */
	public void EnterCardNumber(String cardnum) {
		cardNumberTextfield.sendKeys(cardnum);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Enters the Expiry date (MM/DD) and closes the keyboard */
	public void ExpiryDate(String expiryDate) {
		expiryTextfield.sendKeys(expiryDate);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Enters the CVV number and closes the keyboard */
	public void EnterCVV(String cvvNum) {
		CVVTextfield.sendKeys(cvvNum);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Taps Apply in Checkout button */
	public void TapApplyCheckout() {
		applyInCheckoutButton.click();
	}

	/** Scrolls down the page and taps on Place Order button */
	public void TapPlaceOrder() {
		scrollToEnd();
		placeOrderbutton.click();
	}

	/** Enters the CVV to verify again */
	public void verifyCvv(String cvv) {

		verifyCVVTextfield.click();
		verifyCVVTextfield.sendKeys(cvv);
	}

	/** Taps on "Confirm to Continue" button */
	public void TapConfirmNContinue() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.Button[@index='3']")));
		confirmToContinuebutton.click();
	}
}
