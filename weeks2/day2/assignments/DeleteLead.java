package weeks2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DeleteLead {

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
		driver.findElement(By.linkText("Phone")).click();
		driver.findElement(By.name("phoneNumber")).sendKeys("123456789");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(3000);
		
		WebElement leadid = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String capture = leadid.getText();
		System.out.println("Lead ID displayed: " + capture);
		Thread.sleep(3000);

		leadid.click();

		
		String sub = driver.getTitle();
		System.out.println(sub);

		String endtitle = driver.getTitle();

		System.out.println(endtitle);

		Thread.sleep(3000);

		driver.close();

	}

}
