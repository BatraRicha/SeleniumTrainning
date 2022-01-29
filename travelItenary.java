import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
//Search for the cheapest flighgts from Source and destination provided
public class travelItenary {

	WebDriver driver;

	private String travelMonth = "March";
	private String travelDate = "25";
	String fromCity = "Mumbai";
	String destinationCity = "Delhi";

	@BeforeTest
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "//Users//apple//Downloads//Richa//chromedriver");
		driver = new ChromeDriver();
		driver.get("https://makemytrip.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Test
	public void searchFlights() throws InterruptedException {
		Actions a = new Actions(driver);

		// Calling method to select source city
		sourceCity(a, fromCity);

		// calling method to select destination city
		destinationCity(a, destinationCity);

		// calling method to select travel month and date
		travelMonthDate();

		driver.findElement(By.xpath("//a[text()='Search']")).click();

		// driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();

		WebElement flightList = driver.findElements(By.xpath("//div[@class='fli-list  simpleow ']")).get(0);
		flightList.findElement(By.xpath("//span[text()='View Prices']")).click();

		WebElement fareList = driver.findElements(By.xpath("//div[@class='viewFaresOuter ']")).get(0);
		fareList.findElement(By.xpath("//button[text()='Book Now']")).click();

	}

	public void sourceCity(Actions a, String fromCity) {
		// Actions a = new Actions(driver);
		WebElement sourceCity = driver.findElement(By.xpath("//label[@for='fromCity']"));
		a.moveToElement(sourceCity).click().perform();
		a.moveToElement(sourceCity).click().build().perform();
		// Thread.sleep(3000);
		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='From']")), fromCity).build().perform();

		List<WebElement> fromoptions = driver
				.findElements(By.cssSelector("li[class*='react-autosuggest__suggestion'] p"));
		for (WebElement option : fromoptions) {
			if (option.getText().contains("Mumbai")) {
				option.click();
				break;
			} else
				System.out.println("City name" + option.getText());
		}
		System.out.println("Out of the source loop");
	}

	public void destinationCity(Actions a, String destCity) {
		WebElement toCity = driver.findElement(By.xpath("//input[@id='toCity']"));

		a.moveToElement(toCity).click().sendKeys(toCity, destCity).build().perform();
		driver.manage().deleteAllCookies();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.cssSelector("li[class*='react-autosuggest__suggestion'] p")));
		List<WebElement> toOptions = driver
				.findElements(By.cssSelector("li[class*='react-autosuggest__suggestion'] p"));
		for (WebElement option : toOptions) {
			if (option.getText().contains("Delhi")) {
				option.click();
				break;

			} //else
			//	System.out.println("Destination city does not match" + option.getText());
		}
		System.out.println("out of the destination loop");
	}

	public void travelMonthDate() {
		// select the month
		while (!driver.findElement(By.cssSelector("div[class='DayPicker-Months'] [class='DayPicker-Caption']"))
				.getText().contains(travelMonth)) {
			driver.findElement(By.cssSelector("div[class='DayPicker'] [class*='next']")).click();

		}

		int count = driver.findElements(By.cssSelector(".DayPicker-Day")).size();
		// select the date
		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.cssSelector("div[class='DayPicker-Day'] p")).get(i).getText();
			if (text.equals(travelDate)) {
				driver.findElements(By.cssSelector("div[class='DayPicker-Day'] p")).get(i).click();
				break;
			}
		}
	}

}
