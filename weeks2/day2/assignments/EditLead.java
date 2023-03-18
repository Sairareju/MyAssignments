package weeks2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EditLead {

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
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("David");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		Thread.sleep(3000);

		WebElement leadid = driver.findElement(By.xpath("(//a[@class='linktext'])[4]"));
		String capture = leadid.getText();
		System.out.println("Lead ID displayed: " + capture);
		Thread.sleep(3000);

		leadid.click();

		String sub = driver.getTitle();

		if (sub.contains("View Lead")) {

			System.out.println("The title of the page: " + sub);
			driver.findElement(By.linkText("Edit")).click();

			WebElement comp = driver.findElement(By.id("updateLeadForm_companyName"));
			comp.clear();
			String compname = "UpdatedTestLeaf";
			comp.sendKeys(compname);

			driver.findElement(By.xpath("//input[@name='submitButton']")).click();

			String updcmp = driver.findElement(By.id("viewLead_companyName_sp")).getText();

			System.out.println(updcmp);

			if (updcmp.contains(compname)) {
				System.out.println("The updated changed name has appeared" + updcmp);
				Thread.sleep(3000);
				driver.close();
			}

			else {
				driver.close();
			}
		}

	}

}
