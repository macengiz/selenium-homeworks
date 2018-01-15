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

public class CheckBoxTest {

	WebDriver driver;

	@BeforeTest

	public void setUp() {

		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/checkboxes");
	}

	@Test

	public void checkBoxTest() throws InterruptedException {

		WebElement one = driver.findElement(By.xpath("//input[@type='checkbox']"));
		WebElement two = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));

		Thread.sleep(2000);

		assertFalse(one.isSelected());
		assertTrue(two.isSelected());

		one.click();
		assertTrue(one.isSelected());
		assertTrue(two.isSelected());

		two.click();
		assertFalse(two.isSelected());
		assertTrue(one.isSelected());

	}

	@Test
	//
	// public void changeState() {
	// WebElement one =
	// driver.findElement(By.xpath("//input[@type='checkbox']"));
	// // one radio button exercise
	// toggle(one, false);
	// assertFalse(one.isSelected());
	// toggle(one, true);
	// assertTrue(one.isSelected());
	//
	// }

	public void toggle(WebElement checkbox, boolean checked) {

		if (checkbox.isSelected() != checked) {
			checkbox.click();
		}
	}

	@AfterTest

	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit(); // driver.close();
	}
}
