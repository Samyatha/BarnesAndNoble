package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import utils.AndroidAction;

/** Captured the elements in Cart page */
public class CartPage extends AndroidAction {
	AppiumDriver driver;

	public CartPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='Cart']")
	private WebElement Carticon;

	@FindBy(xpath = "//android.widget.Button[@index='0']")
	private WebElement Checkoutbutton;

	/** Only for Guest user */
	@FindBy(xpath = "//android.widget.TextView[@text='CONTINUE AS A GUEST']")
	private WebElement TapContinueAsGuestoption;

	/** Taps on Cart icon present in the footer */
	public void ClickCartIcon() throws InterruptedException {
		Carticon.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(AppiumBy.xpath("//android.view.View[@text='Cart']"), "text",
				"Cart"));
	}

	/** Taps on Checkout button */
	public void TapCheckoutbutton() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='CHECKOUT ']")));
		Checkoutbutton.click();
		Thread.sleep(5000);
//		wait.until(ExpectedConditions
//				.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Checkout\"]")));
	}

	/** For Guest User, this selects "Continue As Guest" option */
	public void ContinueAsGuestoption() throws InterruptedException{
		TapContinueAsGuestoption.click();
	}
}