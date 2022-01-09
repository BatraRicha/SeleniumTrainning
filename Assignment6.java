import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String elementId = "checkBoxOption2"; 
		String FirstSelectedOption = null;
		System.setProperty("webdriver.chrome.driver", "//Users//apple//Downloads//yuvi_programs//chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		
		driver.findElement(By.id(elementId)).click();
		
	
		boolean result = driver.findElement(By.id(elementId)).isSelected();
		if(result == true) 
		{
			FirstSelectedOption = driver.findElement(By.xpath("//input[@id='"+elementId+"']/parent::label")).getText();
			System.out.println(FirstSelectedOption);
		}
		
		WebElement dropdownElement = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(dropdownElement);
		dropdown.selectByVisibleText(FirstSelectedOption);
		
		driver.findElement(By.id("name")).sendKeys(FirstSelectedOption);
		driver.findElement(By.id("alertbtn")).click();
		
		String fromAlert = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		System.out.println(fromAlert);
		if(fromAlert.equals(FirstSelectedOption))
		{
			driver.switchTo().alert().accept();
			System.out.println("Matches");
		}
		
	}
	

}
