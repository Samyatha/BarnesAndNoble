package pageObjects;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import utils.AndroidAction;

/** Captured the elements from Browse Categories to Product Listing page */
public class ProductListingPage extends AndroidAction {
	AppiumDriver driver;

	public ProductListingPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.TextView[@text='BROWSE CATEGORIES']")
	private WebElement browseCategories;

	@FindBy(xpath = "//android.widget.TextView[@text='Books']")
	private WebElement subCategory;

	@FindBy(xpath = "//android.widget.TextView[@text='SEE ALL']")
	private WebElement SeeAllOption;

	@FindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> AddtoCartbutton;

	@FindBy(xpath = "//android.widget.Button[@index='0']")
	private WebElement Checkoutbutton;

	/** Taps on Browse Categories from Home page */
	public void ClickbrowseCategories() {
		browseCategories.click();
	}

	/**
	 * Taps on one of the sub-category Example:Books
	 */
	public void ClicksubCategory() {
		subCategory.click();
	}

	/** Taps on one of the See All Option */
	public void ClickSeeAll() {
		SeeAllOption.click();
	}

	/** Taps on one Add to Cart button from PLP */
	public void ClickAddtocart(int index) {
		AddtoCartbutton.get(index).click();
	}

}
