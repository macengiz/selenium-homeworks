package homeworks;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MercuryToursRegression {

	WebDriver driver;

	@BeforeTest

	public void setUp() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://newtours.demoaut.com/");
	}

	@Test

	public void login() {

		driver.findElement(By.name("userName")).sendKeys("tutorial");
		driver.findElement(By.name("password")).sendKeys("tutorial");
		driver.findElement(By.name("login")).click();

		String url = driver.getCurrentUrl();
		System.out.println(url);

		String expTitle = ("Find a Flight: Mercury Tours:");
		String actTitle = driver.getTitle();
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");

		// if(actTitle.equals(expTitle)){
		// System.out.println("actual title matched");
		// }else{
		// System.out.println("actual title mismatched");
		// }

		WebElement roundTrip = driver.findElement(By.xpath("//input[@value='roundtrip']"));
		Assert.assertTrue(roundTrip.isSelected());
		WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
		Assert.assertFalse(oneWay.isSelected());
	
		// select passenger 2 and verify
		WebElement list = driver.findElement(By.name("passCount"));
		Select dropdownList = new Select(list);
		dropdownList.selectByIndex(1);
		WebElement passTwoSelected = dropdownList.getAllSelectedOptions().get(0);
		Assert.assertTrue(passTwoSelected.isSelected());

	}
}


