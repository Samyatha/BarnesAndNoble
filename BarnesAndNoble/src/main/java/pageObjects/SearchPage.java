package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import utils.AndroidAction;

/** Captured the elements in Search page */

public class SearchPage extends AndroidAction {
	AppiumDriver driver;

	public SearchPage(AppiumDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//android.widget.EditText[@index='1']")
	private WebElement Searchbar;

	/**
	 * Searches the product either with keyword or EAN and taps[Enter]key from
	 * keypad
	 */
	public void Searchbar(String keyword) throws InterruptedException {
		Searchbar.click();
		Thread.sleep(2000);
		Searchbar.sendKeys(keyword);
		Thread.sleep(2000);
		((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	}

}