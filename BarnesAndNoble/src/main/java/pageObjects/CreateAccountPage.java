package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumBy;
//import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import utils.AndroidAction;
import utils.FrameworkException;

/** Captured the elements in the Create Account page */
public class CreateAccountPage extends AndroidAction {
	AppiumDriver driver;

	public CreateAccountPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.view.View[@content-desc=\"Create Account, tab, 2 of 2\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.TextView")
	private WebElement CreateAccountoption;

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"First Name\"]")
	private WebElement FirstNameTextfield;

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"Last Name\"]")
	private WebElement LastNameTextfield;

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"Email\"]")
	private WebElement EmailTextfield;

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"Password\"]")
	private WebElement PasswordTextfield;

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"Confirm Password\"]")
	private WebElement ConfirmPasswordTextfield;

	@FindBy(xpath = "//android.widget.TextView[@text='Security Question']")
	private WebElement SecurityQuestiondropdown;

	@FindBy(xpath = "//android.widget.EditText[@content-desc=\"Security Answer\"]")
	private WebElement SecurityAnswerTextfield;

	@FindBy(xpath = "//android.widget.TextView[@text='CREATE ACCOUNT']")
	private WebElement CreateAccountbutton;

	@FindBy(xpath = "//android.view.ViewGroup[@content-desc='Profile button']/android.widget.ImageView")
	private WebElement MyAccounticon;

	/** /** Taps on Create Account option */
	public void tapCreateAccountoption() {
		CreateAccountoption.click();
	}

	/** Enters the first name and closes the keyboard */
	public void setFirstName(String fname) {
		FirstNameTextfield.sendKeys(fname);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Enters the last name and closes the keyboard */
	public void setLastName(String lname) {
		LastNameTextfield.sendKeys(lname);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Enters the Email address and closes the keyboard */
	public void Email(String email) {
		EmailTextfield.sendKeys(email);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Enters the Password and closes the keyboard */
	public void setPassword(String pw) {
		PasswordTextfield.sendKeys(pw);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Enters the same password and closes the keyboard */
	public void setConfirmPassword(String confirmpassword) {
		ConfirmPasswordTextfield.sendKeys(confirmpassword);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Taps on Security Question dropdown and selects one question */
	public void setSecurityQuestion(String securityQuestion) throws InterruptedException {
		SecurityQuestiondropdown.click();
		scrollToText(securityQuestion);
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@index='1']")).click();
	}

	/** Enters the Security Answer and closes the keyboard */
	public void setSecurityAnswer(String securityAnswer) {
		SecurityAnswerTextfield.sendKeys(securityAnswer);
		((HidesKeyboard) driver).hideKeyboard();
	}

	/** Taps on Create Account button  */
	public void tapCreateAccount() throws Throwable {
		CreateAccountbutton.click();
		Thread.sleep(5000);
	}

	/** Taps on Account icon */

	public void tapMyAccount() {
		try {
			MyAccounticon.click();
			System.out.println("Account Created successfully");
		} catch (NoSuchElementException e) {
			throw new FrameworkException("Could not create an account", e);
		}

	}
}
