package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utils.AndroidAction;

/** Captured the elements in Welcome page */
public class WelcomePage extends AndroidAction {

	AppiumDriver driver;

	public WelcomePage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.Button[@content-desc=\"Press to login to your account\"]")
	private WebElement signinbutton;

	@FindBy(xpath = "//android.widget.TextView[@text='ENTER AS GUEST']")
	private WebElement EnterAsGuestbutton;

	/** Taps on Sign-in option */
	public void tapSign() {
		signinbutton.click();
	}

	/** Taps on Enter As Guest option */
	public void tapEnterAsGuest() {
		EnterAsGuestbutton.click();
	}
}