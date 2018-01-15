package homeworks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.Assert;

public class MercuryTours2 {

	@Test

	public void f() {

		System.setProperty("webdriver.chrome.driver", "C:/Users/aydin/Documents/Libraries/drivers/chromedriver.exe");

		String url = "http://newtours.demoaut.com/";
		String userName = "tutorial";
		String password = "tutorial";

		WebDriver driver = new ChromeDriver();
		driver.get(url);

		// locate elements and send inputs
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Flights")).click();

		// verify find a flight page url
		String actualFlightUrl = "http://newtours.demoaut.com/mercuryreservation.php";
		String exptectedFlightURl = driver.getCurrentUrl();
		Assert.assertEquals(exptectedFlightURl, actualFlightUrl);

		// verify find a flight page title
		String actualTitle = "Find a Flight: Mercury Tours:";
		String expectedTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);

		// select type round trip and verify
		String roundTrip = driver.findElement(By.name("tripType")).getAttribute("checked");
		Assert.assertTrue(true, roundTrip);

		// select passenger 2 and verify
		// ===================================================================================
		WebElement list = driver.findElement(By.name("passCount"));
		Select dropdownList = new Select(list);
		dropdownList.selectByIndex(1);
		WebElement passTwoSelected = dropdownList.getAllSelectedOptions().get(0);
		Assert.assertTrue(passTwoSelected.isSelected());
		// ===================================================================================================
		// select Departing from "Paris and verify
		WebElement departureList = driver.findElement(By.name("fromPort"));
		Select departureDropDownList = new Select(departureList);
		departureDropDownList.selectByIndex(4);
		WebElement parisSelected = departureDropDownList.getAllSelectedOptions().get(0);
		Assert.assertTrue(parisSelected.isSelected());

		// Select on "Decem 24" and verify
		WebElement monthList = driver.findElement(By.name("fromMonth"));
		Select monthDropDownList = new Select(monthList);
		monthDropDownList.selectByIndex(11);
		WebElement decSelected = monthDropDownList.getAllSelectedOptions().get(0);
		Assert.assertTrue(decSelected.isSelected());

		// select month , day and verify
		WebElement dayList = driver.findElement(By.name("fromDay"));
		Select dayDropDownList = new Select(dayList);
		dayDropDownList.selectByIndex(23);
		WebElement daySelected = dayDropDownList.getAllSelectedOptions().get(0);
		Assert.assertTrue(daySelected.isSelected());

		// Select Arriving in Seattle and verify
		WebElement arrivalDest = driver.findElement(By.name("toPort"));
		Select arrivalDestDropDownList = new Select(arrivalDest);
		arrivalDestDropDownList.selectByIndex(7);
		WebElement seattleSelected = arrivalDestDropDownList.getAllSelectedOptions().get(0);
		Assert.assertTrue(seattleSelected.isSelected());

		// select returning Dec 30 and verify
		WebElement returnMonthList = driver.findElement(By.name("toMonth"));
		Select returnMonthDropDownList = new Select(returnMonthList);
		returnMonthDropDownList.selectByIndex(11);
		WebElement decemberSelected = returnMonthDropDownList.getAllSelectedOptions().get(0);
		Assert.assertTrue(decemberSelected.isSelected());

		// select day and verify
		WebElement returnDayList = driver.findElement(By.name("toDay"));
		Select returnDayDropDownList = new Select(returnDayList);
		returnDayDropDownList.selectByIndex(29);
		WebElement returnDaySelected = returnDayDropDownList.getAllSelectedOptions().get(0);
		Assert.assertTrue(returnDaySelected.isSelected());

		// selcect service class 'business class: and verify
		List<WebElement> newList = driver.findElements(By.name("servClass"));
		Boolean isSelected = newList.get(0).isSelected();
		if (isSelected == true) {
			newList.get(1).click();
		}

		// select airline Unified airlines and verify
		WebElement selectAirline = driver.findElement(By.name("airline"));
		Select airlineDropDownList = new Select(selectAirline);
		airlineDropDownList.selectByIndex(2);
		WebElement airlineSelected = airlineDropDownList.getAllSelectedOptions().get(0);
		Assert.assertTrue(airlineSelected.isSelected());

		// Click continue
		driver.findElement(By.name("findFlights")).click();

		// verify url
		String actualFlightURL = "http://newtours.demoaut.com/mercuryreservation2.php";
		String expectedFLightURL = driver.getCurrentUrl();
		Assert.assertEquals(actualFlightURL, expectedFLightURL);

		// verify title
		String actualSelectFlightTitle = "Select a Flight: Mercury Tours";
		String expectedSelectFlightTitle = driver.getTitle();
		Assert.assertEquals(actualSelectFlightTitle, expectedSelectFlightTitle);

		// find element click and --> verify
		List<WebElement> flightRadioButton = driver.findElements(By.name("outFlight"));
		boolean flightSelected = flightRadioButton.get(0).isSelected();
		if (flightSelected == true) {
			flightRadioButton.get(3).click();
		}
		// locate elements -- choose element 3 -- and verify
		List<WebElement> returnFlightRadioBtn = driver.findElements(By.name("inFlight"));
		boolean returnFlightSelected = returnFlightRadioBtn.get(0).isSelected();
		if (returnFlightSelected == true) {
			returnFlightRadioBtn.get(3).click();
		}

		// click link
		driver.findElement(By.name("reserveFlights")).click();

		// verify book a flight page url
		String actualBookFLightURL = "http://newtours.demoaut.com/mercurypurchase.php";
		String expectedBookFLightURL = driver.getCurrentUrl();
		Assert.assertEquals(actualBookFLightURL, expectedBookFLightURL);

		// verify book a flight page title
		String actualbookFlightTitle = "Book a Flight: Mercury Tours";
		String expectedBookFLightTitle = driver.getTitle();
		Assert.assertEquals(actualbookFlightTitle, actualbookFlightTitle);

		// store infos to string
		String fName = "John";
		String lName = "Smith";
		String number = "4111 1111 1111 1111";
		String address = "7921 Jonas Branch dr";
		String city = "McLean";
		String State = "VA";
		String postalCode = "22102";

		// locate elements and send input
		driver.findElement(By.name("passFirst0")).sendKeys(fName);
		driver.findElement(By.name("passLast0")).sendKeys(lName);
		driver.findElement(By.name("passFirst1")).sendKeys(fName);
		driver.findElement(By.name("passLast1")).sendKeys(lName);

		// select meal option and verify
		WebElement mealPreference1 = driver.findElement(By.name("pass.0.meal"));
		Select mealPreferenceDropDown = new Select(mealPreference1);
		mealPreferenceDropDown.selectByIndex(9);
		WebElement passengerOneMealSelected = mealPreferenceDropDown.getAllSelectedOptions().get(0);
		Assert.assertTrue(passengerOneMealSelected.isSelected());

		// select visa from dropdownbox and verify
		WebElement creditCard = driver.findElement(By.name("creditCard"));
		Select creditCardDropDown = new Select(creditCard);
		creditCardDropDown.selectByIndex(2);
		WebElement creditCardSelected = creditCardDropDown.getAllSelectedOptions().get(0);
		Assert.assertTrue(creditCardSelected.isSelected());

		// locate elements and send input
		driver.findElement(By.name("creditnumber")).sendKeys(number);
		driver.findElement(By.name("cc_frst_name")).sendKeys(fName);
		driver.findElement(By.name("cc_last_name")).sendKeys(lName);

		// select month form dropdown and verify
		WebElement month = driver.findElement(By.name("cc_exp_dt_mn"));
		Select monthDropDown = new Select(month);
		monthDropDown.selectByIndex(12);
		WebElement monthSelected = monthDropDown.getAllSelectedOptions().get(0);
		Assert.assertTrue(monthSelected.isSelected());

		// select year from dropdown and verify
		WebElement year = driver.findElement(By.name("cc_exp_dt_yr"));
		Select yearDropDown = new Select(year);
		yearDropDown.selectByIndex(10);
		WebElement yearSelected = yearDropDown.getAllSelectedOptions().get(0);
		Assert.assertTrue(yearSelected.isSelected());

		// clear textbox and enter andress
		driver.findElement(By.name("billAddress1")).clear();
		driver.findElement(By.name("billAddress1")).sendKeys(address);

		// clear textbox and enter city
		driver.findElement(By.name("billCity")).clear();
		driver.findElement(By.name("billCity")).sendKeys(city);

		// clear textbox and enter state
		driver.findElement(By.name("billState")).clear();
		driver.findElement(By.name("billState")).sendKeys(State);

		// clear textbox and enter zip code
		driver.findElement(By.name("billZip")).clear();
		driver.findElement(By.name("billZip")).sendKeys(postalCode);

		// locate link and verify
		driver.findElement(By.name("buyFlights")).click();

		// verify book a flight page url
		String actualFlightConftURL = "http://newtours.demoaut.com/mercurypurchase2.php";
		String expectedFlightConftURL = driver.getCurrentUrl();
		Assert.assertEquals(actualFlightConftURL, expectedFlightConftURL);

		// verify book a flight page title
		String actualFlightConfTitle = "Flight Confirmation: Mercury Tours";
		String expectedFlightConfTitle = driver.getTitle();
		Assert.assertEquals(actualFlightConfTitle, expectedFlightConfTitle);

		// verify config message
		driver.findElement(By.xpath("//font[text()[contains(., 'has been booked!')]]")).isDisplayed();
		// verify ticket number
		driver.findElement(By.xpath("//font[@color='#FFFFFF'][1]")).isDisplayed();
		// verify total tax
		driver.findElement(By.xpath("//font[text()[contains(.,'96 USD')]]")).isDisplayed();
		// verify total price
		driver.findElement(By.xpath("//font[text()[contains(.,'1264 USD')]]")).isDisplayed();
		// verify back to fligh button displayed
		driver.findElement(By.xpath("//img[@src='/images/forms/backtoflights.gif']")).isDisplayed();
		// verify back to home button displayed
		driver.findElement(By.xpath("//img[@src='/images/forms/home.gif']")).isDisplayed();
		// verify log out button displayed
		driver.findElement(By.xpath("//img[@src='/images/forms/Logout.gif']")).isDisplayed();

	}

}
