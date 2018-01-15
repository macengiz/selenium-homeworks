package homeworks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TutorialsPoint {

	WebDriver driver;
	String url = "http://www.tutorialspoint.com/java/";

	@BeforeTest

	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test

	public void findElements() {
		driver.get("http://www.tutorialspoint.com/java/");

		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("number of elements " + links.size());

		for (WebElement link : links) {
			System.out.println(link.isDisplayed());
			System.out.println(link.getText());
			System.out.println(driver.getCurrentUrl());
		}

	}
}
