package homeworks;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButtonDemo {

		WebDriver driver;

		@BeforeTest

		public void setUp() {

		System.setProperty("webdriver.chrome.driver", 
		"C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://hotwire.com");
	}

		@Test

		public void HotWireTest() {

		WebElement hotel = driver.findElement(By.id("hoteloption"));
		WebElement cars = driver.findElement(By.id("caroption"));
		WebElement flights = driver.findElement(By.id("flightoption"));
		printWhatsSelected(hotel, cars, flights);

		assertTrue(hotel.isSelected());
		flights.click();
		System.out.println("fligt click sonra");
		printWhatsSelected(hotel, cars, flights);
		System.out.println("fligt clic what select");
		assertFalse(hotel.isSelected());
	}

		private void printWhatsSelected(WebElement hotel, WebElement cars, WebElement flights) {
		System.out.println(hotel.isSelected());
		System.out.println(cars.isSelected());
		System.out.println(flights.isSelected());
	}

		@AfterTest

		public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit(); // driver.close();
	}

}
