import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment8 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "//Users//apple//Downloads//yuvi_programs//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		
		driver.findElement(By.id("autocomplete")).sendKeys("uni");
		
		//List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		Thread.sleep(2000);
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[contains(text(),'United Kingdom')]"))).click().build().perform();
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
	}

}
