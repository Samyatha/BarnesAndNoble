package testScripts;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.WelcomePage;
import utils.Configration;
import utils.FrameworkException;

/**
 * •Launch BN App • Tap on Signin button • Select Create Account option • Fill
 * the form • Tap Create Account button • Navigate to Account section and check
 * for My Account header
 */

public class CreateNewAccount extends Configration {

	@Test(dataProvider = "getData")
	public void createAccount(HashMap<String, String> input) throws InterruptedException {

		WelcomePage signin = new WelcomePage(driver);
		CreateAccountPage accountcreation = new CreateAccountPage(driver);
		signin.tapSign();
		accountcreation.tapCreateAccountoption();
		accountcreation.setFirstName(input.get("Firstname"));
		accountcreation.setLastName(input.get("Lastname"));
		accountcreation.Email(input.get("Email"));
		accountcreation.setPassword(input.get("Password"));
		accountcreation.setConfirmPassword(input.get("ConfirmPassword"));
		accountcreation.setSecurityQuestion("In what city were you born?");
		accountcreation.setSecurityAnswer("Bangalore");
		try {
			accountcreation.tapCreateAccount();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

	/** The Create Account details are passed from the json file */
	@DataProvider
	public Object[][] getData() throws IOException {
		List<HashMap<String, String>> data = getJsonData(
				"C:\\Users\\Girish\\eclipse-workspace\\BarnesAndNoble\\src\\test\\java\\testData\\CreateAccount.json");
		return new Object[][] { { data.get(0) } };
	}
}
