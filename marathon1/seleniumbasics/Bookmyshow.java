package marathon1.seleniumbasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Bookmyshow {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		options.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://in.bookmyshow.com/");
		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.xpath("//input[@class='sc-hCaUpS cLnzvB']")).sendKeys("Hyderabad");
		driver.findElement(By.xpath("//li[@class='sc-gJqsIT jMjMYb']")).click();

		String currentUrl = driver.getCurrentUrl();
		if (currentUrl.contains("Hyderabad")) {
			System.out.println("URL contains Hyderabad: " + currentUrl);
		}

		else
			System.out.println("URL is: " + currentUrl);
		driver.findElement(By.xpath("//a[text()='Movies']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Sir']")).click();
		driver.findElement(By.xpath("//span[text()='Book tickets']")).click();
		Thread.sleep(2000);
		String Firstthea = driver.findElement(By.xpath("(//a[@class='__venue-name'])[1]")).getText();
		System.out.println(Firstthea);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("(//div[@class='venue-info-text'])[1]")).click();
		Thread.sleep(2000);

		WebElement info = driver.findElement(By.xpath("//div[contains(text(),'Parking')]"));
		String prkinfo = info.getText();
		if (prkinfo.contains("Parking")) {
			System.out.println("Parking is available for the selected theatre");
		}

		driver.findElement(By.xpath("//*[name()='svg' and @viewBox='0 0 23 23']//*[local-name()='path']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='showtime-pill-container _available'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@id='pop_1']")).click();
		driver.findElement(By.xpath("//div[@id='proceed-Qty']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[contains(@id,'_1_21')]")).click();
		Thread.sleep(2000);
		WebElement pay = driver.findElement(By.xpath("//span[@id='btnSTotal_reserve']"));
		driver.executeScript("arguments[0].click();", pay);

		Thread.sleep(3000);

		WebElement subtot = driver.findElement(By.xpath("//span[@id='subTT']"));
		String total = subtot.getText();
		System.out.println("Sub Total: " + total);

		Thread.sleep(3000);

		driver.close();
	}

}
