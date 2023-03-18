package weeks2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assigment4Input {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		options.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.leafground.com/input.xhtml");
		driver.findElement(By.xpath("//input[contains(@id,'name')]")).sendKeys("Test");
		driver.findElement(By.xpath("//input[contains(@class,'ui-state-filled')]")).sendKeys(" India");
		
		WebElement searchTextBox= driver.findElement(By.xpath("(//input[contains(@class,'ui-state-default')])[3]"));
		String attribute = searchTextBox.getAttribute("placeholder");
		if(attribute.equals("Disabled"))
		{
			System.out.println("The textbox is disabled");
		}
		else
		{
			System.out.println("The textbox is not disabled");
		}
	}

}
