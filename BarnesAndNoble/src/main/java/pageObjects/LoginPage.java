package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import utils.AndroidAction;

/** Captured the elements in Login page */

public class LoginPage extends AndroidAction {
	AppiumDriver driver;

	public LoginPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.EditText[@content-desc='Your email address']")
	private WebElement EnterEmail;

	@FindBy(xpath = "//android.widget.EditText[@content-desc='your bn.com or nook or browsery password']")
	private WebElement loginPassword;

	@FindBy(xpath = "//android.widget.TextView[@text='CONTINUE']")
	private WebElement continueButton;

	/** Enters the registered email address and closes the keyboard */
	public void enterEmail(String email) {
		EnterEmail.sendKeys(email);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Enters the Password and closes the keyboard */
	public void enterPassword(String password) {
		loginPassword.sendKeys(password);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Taps on Continue button */
	public void continueSignin() {
		continueButton.click();
	}

}
