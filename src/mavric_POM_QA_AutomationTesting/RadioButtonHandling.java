package mavric_POM_QA_AutomationTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RadioButtonHandling {

	public static WebDriver driver;

	@BeforeMethod
	public static void setUp() {

		// Invoke chrome browser instinct
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\com\\QA\\POM\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		// Maximize the chrome browser window
		driver.manage().window().maximize();
		// driver.manage().window().fullscreen();

		// Delete all cookies
		driver.manage().deleteAllCookies();

		// For implicitly wait
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// Invoke URL Universal research locator
		driver.get("https://www.facebook.com/");

	}

	@Test
	public static void radioButtonHandling() throws Exception {

		// Click on create new acount button
		driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
		// Xpath for all radio button like for male female and custom
		List<WebElement> radioButton = driver.findElements(By.xpath("//input[contains(@type,'radio')]"));

		System.out.println("Total No. of radio button:-" + radioButton.size());

		// For female radio button
		Thread.sleep(2000);
		radioButton.get(1).click();

		System.out.println("Radio button is display:-" + radioButton.get(1).isDisplayed());
		System.out.println("Radio button is display:-" + radioButton.get(1).isEnabled());
		System.out.println("Radio button is display:-" + radioButton.get(1).isSelected());

		// For male radio button
		Thread.sleep(2000);
		radioButton.get(2).click();

		System.out.println("Radio button is display:-" + radioButton.get(2).isDisplayed());
		System.out.println("Radio button is display:-" + radioButton.get(2).isEnabled());
		System.out.println("Radio button is display:-" + radioButton.get(2).isSelected());

		// For custom radio button
		Thread.sleep(2000);
		radioButton.get(-1).click();

		System.out.println("Radio button is display:-" + radioButton.get(-1).isDisplayed());
		System.out.println("Radio button is display:-" + radioButton.get(-1).isEnabled());
		System.out.println("Radio button is display:-" + radioButton.get(-1).isSelected());

	}
	
	
	@AfterMethod
	public static void quit() {

		driver.quit();

	}

}
