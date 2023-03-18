package weeks2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment4Button {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		options.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.leafground.com/button.xhtml");
		driver.findElement(By.xpath("//span[contains(@class,'ui-button-text ui-c')]")).click();
		String title = driver.getTitle();
		System.out.println("The title of the page is: " + title);
	}

}
