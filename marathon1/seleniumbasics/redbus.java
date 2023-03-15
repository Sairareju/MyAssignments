package marathon1.seleniumbasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class redbus {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);
		options.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.redbus.in/");
		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.xpath("//input[@id='src']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();

		driver.findElement(By.xpath("//input[@id='dest']")).sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[@select-id='results[0]']")).click();
		driver.findElement(By.xpath("//label[@class='db text-trans-uc']")).click();
		driver.findElement(By.xpath("//td[@class='wd day']")).click();
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();

		String text = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();

		System.out.println(text);

		WebElement sleeper = driver.findElement(By.xpath("//label[text()='SLEEPER']"));
		driver.executeScript("arguments[0].click();", sleeper);
		String text2 = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();

		System.out.println(text2);
		String endtitle = driver.getTitle();
		System.out.println(endtitle);

		Thread.sleep(3000);
		driver.close();

	}

}
