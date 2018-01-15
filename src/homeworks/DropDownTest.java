package homeworks;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDownTest {

	WebDriver driver;

	@BeforeTest

	public void setUp() {

		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dropdown");
	}

	@Test

	public void dropDownTest() {

		WebElement list = driver.findElement(By.id("dropdown"));
		Select dropdownList = new Select(list);

		for (WebElement option : dropdownList.getOptions()) {
			System.out.println(option.getText());
		}

		WebElement chosenOne = dropdownList.getAllSelectedOptions().get(0);
		System.out.println(chosenOne.getText());

		dropdownList.selectByVisibleText("Option 1");
		chosenOne = dropdownList.getAllSelectedOptions().get(0);
		System.out.println(chosenOne.getText());
		assertEquals("Option 1", chosenOne.getText());

		dropdownList.selectByIndex(2);
		chosenOne = dropdownList.getAllSelectedOptions().get(0);
		assertNotEquals("Option 1", chosenOne.getText());

		dropdownList.selectByValue("1");
		chosenOne = dropdownList.getAllSelectedOptions().get(0);
		assertEquals("Option 1", chosenOne.getText());

	}

	@AfterTest

	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
