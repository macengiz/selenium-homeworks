package homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		String url = "http://newtours.demoaut.com/";

		driver.get(url);
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		if (expectedTitle.equals(actualTitle)) {
			System.out.println("title passed");
		} else {
			System.out.println("title failed");
		}
		driver.findElement(By.linkText("Register here")).click();
		driver.findElement(By.name("firstName")).sendKeys("aydin");
		driver.findElement(By.name("lastName")).sendKeys("cengiz");
		driver.findElement(By.name("phone")).sendKeys("1234567");
		driver.findElement(By.name("userName")).sendKeys("maydin");
		driver.findElement(By.name("address1")).sendKeys("fairfax");
		driver.findElement(By.name("city")).sendKeys("fairfax");
		driver.findElement(By.name("state")).sendKeys("va");
		driver.findElement(By.name("postalCode")).sendKeys("22030");
		driver.findElement(By.name("country")).sendKeys("usa");
		driver.findElement(By.name("email")).sendKeys("maydin");
		driver.findElement(By.name("password")).sendKeys("1234567");
		driver.findElement(By.name("confirmPassword")).sendKeys("1234567");
		Thread.sleep(2000);
		driver.findElement(By.name("register")).click();

		String user = driver.findElement(By.linkText("Note: Your user name is maydin.")).getText();
		if (user.contains("maydin")) {
			System.out.println("username passed");
		} else {
			System.out.println("username failed");
		}
		driver.findElement(By
				.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[2]/font/a[1]"))
				.click();

		boolean imgDisplayed = driver.findElement(By.name("userName")).isDisplayed();
		boolean imgDisplayed2 = driver.findElement(By.name("password")).isDisplayed();
		boolean imgDisplayed3 = driver.findElement(By.name("login")).isDisplayed();
		if (imgDisplayed && imgDisplayed2 && imgDisplayed3) {
			System.out.println("image display passed");
		} else {
			System.out.println("image display failed");
		}
		driver.findElement(By.name("userName")).sendKeys("maydin");
		driver.findElement(By.name("password")).sendKeys("1234567");
		driver.findElement(By.name("login")).click();

		String expTitle = "Find a Flight: Mercury Tours: ";
		String actTitle = driver.getTitle();
		if (actTitle.equals(expTitle)) {
			System.out.println("title verification passed");
		} else {
			System.out.println("title vrification failed");
		}
		driver.findElement(By.linkText("SIGN-OFF")).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
