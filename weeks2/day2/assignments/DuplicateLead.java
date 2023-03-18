package weeks2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("http://leaftaps.com/opentaps/control/login");

		String title = driver.getTitle();

		System.out.println(title);

		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.name("emailAddress")).sendKeys("mail@gmail.com");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(3000);

		WebElement leadid = driver.findElement(By.xpath("(//a[@class='linktext'])[6]"));
		String capture = leadid.getText();
		System.out.println("First Resulting lead Name displayed: " + capture);
		Thread.sleep(3000);

		leadid.click();

		driver.findElement(By.linkText("Duplicate Lead")).click();

		String sub = driver.getTitle();

		if (sub.contains("Duplicate Lead")) {

			System.out.println("The title is verfied: " + sub);
			driver.findElement(By.xpath("//input[@name='submitButton']")).click();

			WebElement duplinme = driver.findElement(By.id("viewLead_firstName_sp"));
			String name = duplinme.getText();

			System.out.println("Duplicate Lead name displayed: " + name);

			if (capture.equals(name)) {
				System.out.println("Duplicate Lead name and captured lead name are same: " + name);
				Thread.sleep(3000);
				driver.close();
			}

			else {
				driver.close();
			}
		}

	}

}
