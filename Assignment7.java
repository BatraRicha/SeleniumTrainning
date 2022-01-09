import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "//Users//apple//Downloads//yuvi_programs//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		
		Thread.sleep(2000);
		System.out.println("Number of rows " + driver.findElements(By.xpath("//table[@class='table-display'] //tr")).size());
		System.out.println("Number of Columns" + driver.findElements(By.xpath("//table[@class='table-display'] //th")).size());
		
		int size = driver.findElements(By.xpath("//table[@class='table-display'] //tr[3]")).size();
		
		for(int i =0; i< size; i++ )
		{
			System.out.println(driver.findElements(By.xpath("//table[@class='table-display'] //tr[3]")).get(i).getText());
		}
	}
	

}
