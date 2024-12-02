package mavric_POM_QA_AutomationTesting;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WebTableHandling {

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
		driver.get("https://money.rediff.com/index.html");

		// Navigate to another url.
		driver.navigate().to("https://money.rediff.com/gainers");

	}

	@Test
	public static void webTableHandling() throws Exception {

		// Total number of 'columns' and 'rows' in table head
		// Total numbers of rows in table head.
		List<WebElement> allRowsHead = driver.findElements(By.xpath("//table[contains(@class,'dataTable')]/thead/tr"));
		System.out.println("Total No. of rows in head:-" + allRowsHead.size());

		// Total numbers of columns in table head.
		List<WebElement> allColumnsHead = driver
				.findElements(By.xpath("//table[contains(@class,'dataTable')]/thead/tr/th"));
		System.out.println("Total No. of columns in head:-" + allColumnsHead.size());

		// Total number of 'columns' amd 'rows' in table body
		// Total numbers of row in table body
		List<WebElement> allRowsBody = driver.findElements(By.xpath("//table[contains(@class,'dataTable')]/tbody/tr"));
		System.out.println("Total NO. of rows in body:-" + allRowsBody.size());

		// Total number of columns in table body
		List<WebElement> allColumnsBody = driver
				.findElements(By.xpath("//table[contains(@class,'dataTable')]/tbody/tr/td[1]"));
		System.out.println("Total No. of columns in body:-" + allColumnsBody.size());

		// Handling webtable
		// Remove the extra space from the text of companiers name and also in case of
		// handling the link we use " /a "
		List<WebElement> allCompanies = driver
				.findElements(By.xpath("//table[contains(@class,'dataTable')]/tbody/tr/td[1]/a"));
		System.out.println("Total No. of companies:-" + allCompanies.size());

		// Current prince
		List<WebElement> currentPrice = driver
				.findElements(By.xpath("//table[contains(@class,'dataTable')]/tbody/tr/td[4]"));
		System.out.println("Total No. number of price:-" + currentPrice.size());

		// I want to select one company randomly and want to check it's current prince
		// Using for loop amd if styatement

		try {

			for (int i = 0; i < allCompanies.size(); i++) {

				String expectedResult = "Innovassynth Investm";

				if (allCompanies.get(i).getText().equalsIgnoreCase(expectedResult)) {

					System.out.println("AllCompanies:-" + allCompanies.get(i).getText() + "===" + "Current Price:-"
							+ currentPrice.get(i).getText());
					break;

				}

			}

			for (int i = 0; i < allCompanies.size(); i++) {

				String expectedResult1 = "Mirza International";

				if (allCompanies.get(i).getText().equalsIgnoreCase(expectedResult1)) {

					System.out.println("AllCompanies: -" + allCompanies.get(i).getText() + "===" + "Current Price"
							+ currentPrice.get(i).getText());

					break;
				}

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e);
		}

	}

	@AfterMethod
	public void quit() {

		driver.quit();

	}

}
