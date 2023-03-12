package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Assignment1_CreateLead {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("http://leaftaps.com/opentaps/control/main");

		String title = driver.getTitle();

		System.out.println(title);

		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeafPVTLTD");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Saira");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("S");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Quality");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Assignment");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("reju@gmail.com");

		WebElement state = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateid = new Select(state);
		stateid.selectByVisibleText("New York");

		Thread.sleep(3000);

		driver.findElement(By.name("submitButton")).click();

		String endtitle = driver.getTitle();

		System.out.println(endtitle);

		Thread.sleep(3000);

		driver.close();

	}

}
