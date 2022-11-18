package utils;

import java.io.FileInputStream;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
/**Configuration set up for BrowserStack */
/*public class Configration extends AndroidAction{
	public AppiumDriver driver;
	@BeforeClass
	public void baseTest() throws MalformedURLException{
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S8 Plus");
		desiredCapabilities.setCapability("os_version", "7.0");
		desiredCapabilities.setCapability("project", "Vioc Android");
		desiredCapabilities.setCapability("build", "QA Build");
		desiredCapabilities.setCapability("name", "SamyathaAutomation");
		desiredCapabilities.setCapability("app","bs://ed2610a2e50d0e6a5844d00152d2ef675d2219be");
		try{
		driver = new AndroidDriver(new URL("https://samyatha_59oQ8I:JyudG7wvcw49ZiM2D8Hx@hub-cloud.browserstack.com/wd/hub"), desiredCapabilities);
		}catch (MalformedURLException e)
		{System.out.println("MalformedURLException Caught: "+e.getMessage());
			e.printStackTrace();}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		desiredCapabilities.setCapability("unicodeKeyboard", true);
		desiredCapabilities.setCapability("resetKeyboard", true);
	}
	public List<HashMap<String,String>>getJsonData(String jsonFilePath) throws IOException{
	String jsonContent=FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);
	ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>>data=mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){;
	});
		return data;}
	@AfterClass
	public void tearDown()
	{driver.quit();
	}	
}*/

/** Configuration set up for Appium Server with Android Studio */
public class Configration extends AndroidBase {
	public AppiumDriverLocalService service;
	public AppiumDriver driver;

	@BeforeClass
	public void baseTest() throws Throwable {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\Resources\\data.properties");
		prop.load(fis);
		String ipAddress = prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		service = startAppiumServer(ipAddress, Integer.parseInt(port));
		UiAutomator2Options option = new UiAutomator2Options();

		option.setDeviceName(prop.getProperty("AndroidDeviceName"));

		option.setApp(
				"C:\\Users\\Girish\\eclipse-workspace\\BarnesAndNoble\\src\\test\\java\\Resources\\app-qa-release-1.2.14-44.apk");
		driver = new AndroidDriver(service.getUrl(), option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		service.stop();
	}
}
