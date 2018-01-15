package homeworks;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopUp {

	WebDriver driver;

	@BeforeTest

	public void setUp() {

		System.setProperty("webdriver.chrome.driver", 
				"C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test

	public void popUp() throws InterruptedException {

		driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
		driver.findElement(By.id("j_idt87:j_idt88")).click();
		driver.findElement(By.id("j_idt87:j_idt89_title")).isDisplayed();
		driver.findElement(By.id("j_idt87:j_idt91")).click();
	}

	@Test

	public void javaScript() throws InterruptedException {

		driver.get("http://t4t5.github.io/sweetalert/");
		// driver.findElement(By.xpath("html/body/div[1]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("( //button[.='Show error message'])[1]")).click();
		Thread.sleep(2000);

		String verifyAlert = "Oops... Something went wrong!";
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals(alert.getText(), verifyAlert);
		alert.accept();
		Thread.sleep(3000);
		driver.findElement(By.xpath("( //button[.='Show error message'])[2]")).click();

		String verifyAlert2 = "Something went wrong!";
		String secondAlert = driver.findElement(By.xpath("//p[.='Something went wrong!']")).getText();
		System.out.println(secondAlert);
		Assert.assertEquals(secondAlert, verifyAlert2);
		driver.findElement(By.xpath("/ /button[.='OK']")).click();
	}

	@Test

	public void tabs() {

		driver.get("http:// seleniumframework.com/demo- sites");
		// click link: seleniumframework.com/practice form
		driver.findElement(By.linkText("http://www. seleniumframework.com/ Practiceform/")).click();
		String newTab = "Selenium Framework | Practiceform";
		String newURL = "http://www.seleniumframework. com/Practiceform/";
		for (String tab : driver.getWindowHandles()) {
			driver.switchTo().window(tab);
			if (driver.getTitle().equals(newTab)) {
				break;
			}
		}
		Assert.assertEquals(driver.getCurrentUrl(), (newURL));
		driver.findElement(By.id(" button1")).click();

		// switch to new tab using title "SeleniumFramework | Selenium,
		// Cucumber, Ruby, Java et al."
		String thirdPageTitle = "Selenium Framework | Selenium, Cucumber, Ruby, Java et al.";
		for (String str : driver.getWindowHandles()) {
			driver.switchTo().window(str);
			if (driver.getTitle().equals(thirdPageTitle)) {
				
				break;
			}
		}
		String thirdURL = "http://www.seleniumframework. com/";
		Assert.assertEquals(driver.getCurrentUrl(), thirdURL);
	}

	@Test

	// go to ""http://yahoo.com"
	// search for "how to handle iframe in selenium"
	// in the results, some links are separated with a hyphen ("-"). In those
	// links, text before the hyphen is the title of the result page, text after
	// the hyphen is the domain name.
	// separately capture the title and the domain name
	// click on the result link
	// when the new tab opens, switch to that tab using the title from step 4
	// verify that current url contains the domain name from step 4
	// close the current tab
	// switch back to the yahoo results tab
	// do this for five links with a hyphen (-)

	public void YahooSearch() throws InterruptedException {

		driver.get("http://yahoo.com");
		driver.findElement(By.id("uh- search-box")).sendKeys("How to handle iframe in selenium" + Keys.ENTER);
		Thread.sleep(3000);
		WebElement searchResult = (driver.findElement(By.partialLinkText("-")));
		String[] split = searchResult.getText().split("-");
		String mainPage = "https://search.yahoo.com/";
		String title = split[0];
		String domain = split[split.length - 1].replaceAll(" ", "");
		searchResult.click();
		for (String tabs : driver.getWindowHandles()) {
			driver.switchTo().window(tabs);

			if (driver.getTitle().contains(title)) {
				break;
			}
		}
		Assert.assertTrue(driver.getCurrentUrl().contains(domain.toLowerCase()));
		driver.close();

		for (String tabs : driver.getWindowHandles()) {
			driver.switchTo().window(tabs);

			if (driver.getCurrentUrl().contains(mainPage)) {
				break;
			}
		}
	}

	@Test

	public void iframe() {

		// go to "https://the-internet. herokuapp.com/nested_frames"
		// capture and print all of the text displayed on this page
		// (this website uses nested frames, you need to switch to back and
		// forth between multiple frames )

		driver.get("https://the- internet.herokuapp.com/nested_ frames");
		driver.switchTo().frame(" frame-top");
		driver.switchTo().frame(" frame-left");
		String one = driver.findElement(By.xpath("/ /html/body")).getText();
		System.out.println(one);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame(" frame-middle");
		String two = driver.findElement(By.id(" content")).getText();
		System.out.println(two);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(0);
		driver.switchTo().frame(" frame-right");
		String three = driver.findElement(By.xpath("/ /html/body")).getText();
		System.out.println(three);

		driver.switchTo().defaultContent();
		driver.switchTo().frame(" frame-bottom");
		String four = driver.findElement(By.xpath("/ /html/body")).getText();
		System.out.println(four);

	}

}
