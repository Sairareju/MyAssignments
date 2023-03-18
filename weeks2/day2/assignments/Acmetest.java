package weeks2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Acmetest {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://acme-test.uipath.com/login");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kumar.testleaf@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("leaf@12");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String title2 = driver.getTitle();
		System.out.println("The Title of the page is: " + title2);

		driver.findElement(By.linkText("Log Out")).click();

		Thread.sleep(3000);

		driver.close();

	}

}
