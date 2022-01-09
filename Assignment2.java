import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 */

/** Automating Cleartrip.com
 * not possible with cleartrip.com. Cleartrip blocked the ip address when tried multiple times
 * @author apple
 *
 */
public class Assignment2 {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "//Users//apple//Downloads//yuvi_programs//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cleartrip.com");
		
		Thread.sleep(2000);
		// System.out.println(driver.findElement(By.cssSelector(".fs-3.fw-600.c-neutral-900.mb-2")).getText());
		//if(driver.findElement(By.cssSelector(".fs-3.fw-600.c-neutral-900.mb-2")).getText().equals("Adults"))
		//driver.findElement(By.xpath("//h4[@text()='Adults']"))
			WebElement adult = driver.findElement(By.xpath("//h4[@text()='Adults']"));
			//driver.findElement(By.cssSelector(".bc-neutral-100.bg-transparent"));
			Select selectAdult = new Select(adult);
			selectAdult.selectByValue("4");
		
		

	}

}
