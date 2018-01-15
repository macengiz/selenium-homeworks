package homeworks;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BrowserTestCases {

	static WebDriver driver;

	SoftAssert softAssert = new SoftAssert();

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void BrowserPopUpTest() {
		String url = "https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml";
		// go to url
		driver.get(url);
		// locate button and click
		driver.findElement(By.xpath("//span[text()='Destroy the World']")).click();
		// verify pop is displayed
		boolean popUpVerification = driver.findElement(By.id("j_idt87:j_idt89")).isDisplayed();
		Assert.assertTrue(popUpVerification);
		// click no option
		driver.findElement(By.xpath("//span[text() ='No']")).click();
	}

	public void alertTest() {
		String url = "http://t4t5.github.io/sweetalert/";

		// go to url
		driver.get(url);
		// locate and click button
		driver.findElement(By.xpath("//button[text()='Show errormessage']")).click();
		// switch control to alert
		Alert alert = driver.switchTo().alert();
		String expedAlertValue = "Oops...Something went wrong!";
		String actualAlertValue = alert.getText();
		// verify alert is displayed
		assertEquals(expedAlertValue, actualAlertValue);

		// dismiss alert
		alert.dismiss();

		// locate and click button
		driver.findElement(By.xpath("(//button[text()='Show error message'])[2]")).click();
		// verify pop up is displayed
		boolean popUpVerification = driver.findElement(By.xpath("//P[text()='Something went wrong!']")).isDisplayed();
		assertTrue(popUpVerification);
	}

	public void tabTest() {
		String url = "http://seleniumframework.com/demo-sites";
		driver.get(url);
		driver.findElement(By.linkText("http://www.seleniumframework.com/Practiceform/")).click();

		System.out.println(driver.getTitle());

		String expectedTitle = "Selenium Framework | Practiceform";

		switchTab(driver, expectedTitle);
		System.out.println(driver.getTitle());

		System.out.println("~~~~~~~~~~~~~");
		driver.findElement(By.id("button1")).click();

		System.out.println(driver.getTitle());

		String expectedOne = "Selenium Framework | Selnium, Cucumber, Ruby, Java et al";
		switchTab(driver, expectedOne);
		System.out.println(driver.getTitle());

		System.out.print(driver.getCurrentUrl());
		assertTrue(true);
	}

	public static void switchTab(WebDriver driver, String title) {
		for (String windowHandle : driver.getWindowHandles()) {
			driver.switchTo().window(windowHandle);
			if (driver.getTitle().equals(title)) {
				break;
			}
		}
	}

	@Test
	public void yahooSearchTest() throws InterruptedException {
		String url = "https://www.yahoo.com/";
		String yahooTitle = driver.getTitle();
		String searchInput = "How to handle iframe in selenium";
		driver.get(url);
		driver.findElement(By.id("uh-search-box")).sendKeys(searchInput + Keys.ENTER);

		/// get all the search result

		Thread.sleep(2000);

		List<WebElement> elements = driver.findElements(By.cssSelector("ol li h3>a"));

		for (int i = 0; i < elements.size(); i++) {
			if (!(elements.get(i).getText().contains("-"))) {
				elements.remove(i);
			}
		}

		for (WebElement el : elements) {
			System.out.println(el.getText());
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		for (int i = 1; i <= 5; i++) {
			// Store elements in string
			String nameAndDomain = elements.get(i).getText();

			System.out.println(nameAndDomain);

		}

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		for (int i = 1; i <= 5; i++) {
			// Store elements in string

			// How To Handle Iframe In Selenium
			// Video Results

			String nameAndDomain = elements.get(i).getText();

			// split string by -
			String[] split = nameAndDomain.split("-");
			// store index 0 as title
			String title = split[0];
			// store second/last elements as domain
			String domain = split[split.length - 1];
			domain.replaceAll(" ", "");
			// print output
			System.out.println("Title:  " + title);
			System.out.println("Domain: " + domain);
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

			// get current window handle
			String windowHandle = driver.getWindowHandle();

			// Get the list of window handles
			elements.get(i).click();

			ArrayList tabs = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) tabs.get(1));
			Thread.sleep(1000);

			String currentUrl = driver.getCurrentUrl();
			softAssert.assertEquals(currentUrl, domain);
			System.out.println(currentUrl);
			System.out.println(domain);

			Thread.sleep(1000);
			driver.close();

			// switch back to original window
			driver.switchTo().window((String) tabs.get(0));
		}
	}

	public void frameTesting() {
		String url = "https://the-internet.herokuapp.com/nested_frames";
		driver.get(url);
		// capture top frame
		driver.switchTo().frame("frame-top");
		// switch to left frame inside topFrame
		driver.switchTo().frame("frame-left");
		// print body
		printBody();
		// switch back to top frame
		driver.switchTo().parentFrame();
		// go to middle frame
		driver.switchTo().frame("frame-middle");
		// print body
		printBody();
		// switch back to top frame
		driver.switchTo().parentFrame();
		// switch to right frame
		driver.switchTo().frame("frame-right");
		// print body
		printBody();
		// switch back to top frame
		driver.switchTo().parentFrame();
		// switch to parent/main frame that contain all child frames
		driver.switchTo().parentFrame();
		// switch to bottom frame
		driver.switchTo().frame("frame-bottom");
		// print body
		printBody();
		/// aryubiasif@gmail.com

	}

	public static void printBody() {
		String str = driver.findElement(By.tagName("body")).getText();
		System.out.println("Printing From " + str + " frame");
	}

	@AfterTest
	public void tearDown() throws InterruptedException {

		Thread.sleep(2000);
		driver.quit();
	}

}
