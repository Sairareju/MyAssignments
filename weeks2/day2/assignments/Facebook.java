package weeks2.day2.assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		options.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://en-gb.facebook.com/");
		String title = driver.getTitle();
		System.out.println(title);

		driver.findElement(By.xpath("//div[@class='_6ltg']//a[@role='button']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Student");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("9789555643");
		driver.findElement(By.xpath("//input[@id='password_step_input']")).sendKeys("Student_9789");

		WebElement BirthDD = driver.findElement(By.xpath("//select[@id='day']"));
		Select Birthdate = new Select(BirthDD);
		Birthdate.selectByIndex(14);

		WebElement MonthDD = driver.findElement(By.xpath("//select[@id='month']"));
		Select Birthmonth = new Select(MonthDD);
		Birthmonth.selectByVisibleText("Dec");

		WebElement YearDD = driver.findElement(By.xpath("//select[@id='year']"));
		Select Birthyear = new Select(YearDD);
		Birthyear.selectByValue("1984");

		driver.findElement(By.xpath("//input[@name='sex']")).click();

		Thread.sleep(3000);
		driver.close();

	}

}
