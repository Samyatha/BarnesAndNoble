package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utils.AndroidAction;

/** Captured the elements in Product Detail page */
public class ProductDetailPage extends AndroidAction {
	AppiumDriver driver;

	public ProductDetailPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private WebElement AddtoCartbutton;

	/** Taps on "Add to cart" button in PDP */
	public void ClickAddtocart() {
		AddtoCartbutton.click();
	}
}