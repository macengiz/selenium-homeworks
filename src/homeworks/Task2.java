package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String url = "http://thedemosite.co.uk/index.php";
		driver.get(url);
		driver.findElement(
				By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.name("username")).sendKeys("macengiz");
		driver.findElement(By.name("password")).sendKeys("1234567");
		driver.findElement(By.name("FormsButton2")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[2]/small/a"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.name("username")).sendKeys("macengiz");
		driver.findElement(By.name("password")).sendKeys("1234567");
		driver.findElement(By.name("FormsButton2")).click();

		boolean imgDisplayed = driver
				.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"))
				.isDisplayed();
		if (imgDisplayed) {
			System.out.println("passed");
		} else {
			System.out.println("failed");
		}
		
		Thread.sleep(2000);
		driver.close();
	}

}
