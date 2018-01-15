package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task3 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String url = "http://www.phptravels.net/";
		driver.get(url);

		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(2000);

		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='btn btn-action btn-block loginbtn']")).click();
		Thread.sleep(2000);

		// boolean invalid = driver.findElement(By.xpath("//button[@class='btn
		// btn-action btn-block loginbtn']"))
		// .isDisplayed();
		// boolean invalid = driver.findElement(By.xpath("//div[@class='alert
		// alert-danger']")).isDisplayed();

		boolean invalid = driver.findElement(By.xpath("//div[.='Invalid Email or Password']")).isDisplayed();

		if (invalid) {
			System.out.println("invalid test passed");
		} else {
			System.out.println("invalid test failed");
		}
		Thread.sleep(2000);

		driver.findElement(By.name("username")).sendKeys("user@phptravels.com");
		driver.findElement(By.name("password")).sendKeys("demouser");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@class='btn btn-action btn-block loginbtn']")).click();
		Thread.sleep(2000);

		// boolean disp = driver.findElement(By.xpath("//h3[.='Hi, John
		// Smith']")).isDisplayed();
		// boolean disp =
		// driver.findElement(By.xpath("//h3[@class='RTL']")).isDisplayed();
		boolean disp = driver.findElement(By.xpath("html/body/div[3]/div[1]/div/div[1]/h3")).isDisplayed();

		if (disp) {
			System.out.println("displayed passed");
		} else {
			System.out.println("displayed failed");
		}
		Thread.sleep(2000);

		// driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		// driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/ul/li[2]/a")).click();
		// driver.findElement(By.linkText("john")).click();

		driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul/li[2]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[2]/div/div/div[2]/ul/li[2]/ul/li[2]/a")).click();

	}

}
