package week2.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Launchleaftap {

	public static void main(String[] args) {

		// To use Chrome version which is not 110

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origin=*");

		// To launch the Chromedriver
		ChromeDriver driver = new ChromeDriver(options);

		// To maximize the web page
		driver.manage().window().maximize();

		// To launch the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		// To get the title

		String title = driver.getTitle();

		System.out.println(title);

		// Code to enter the user credentials
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();

		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeafPVTLTD");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Saira");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("R");

		// For drop down

		WebElement sourceDD = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sec = new Select(sourceDD);
		// sec.selectByIndex(1);
		sec.selectByValue("LEAD_EMPLOYEE");

		driver.findElement(By.name("submitButton")).click();
		
		driver.close();

	}

}
