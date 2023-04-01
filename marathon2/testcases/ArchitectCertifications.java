package marathon2.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.sukgu.Shadow;

public class ArchitectCertifications {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Leaf@123");
		driver.findElement(By.xpath("//input[@id='Login']")).click();
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> windowHandles = driver.getWindowHandles();

		List<String> list = new ArrayList<>(windowHandles);
		driver.switchTo().window(list.get(1));

		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Shadow dom = new Shadow(driver);
		// dom.setImplicitWait(30);
		dom.findElementByXPath("//span[text()='Learning']").click();
		WebElement Museover = dom.findElementByXPath("//span[text()='Learning on Trailhead']");

		Actions act = new Actions(driver);

		act.moveToElement(Museover).perform();

		WebElement ScrltoEnd = dom.findElementByXPath("//a[text()='Salesforce Certification']");
		act.scrollToElement(ScrltoEnd).perform();
		ScrltoEnd.click();

		driver.findElement(By.xpath("//div[text()='Architect']")).click();
		String Sum1 = driver.findElement(By.xpath(
				"//h1[contains(@class,'cert-site_title')]/following-sibling::div[contains(@class,'slds-text-align')]"))
				.getText();
		System.out.println("Salesforce Architect " + '\n' + Sum1);
		WebElement moveto = driver.findElement(By.xpath("//a[text()='Application Architect']"));
		act.scrollToElement(moveto).perform();

		List<WebElement> cert = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("Salesforce Architect Certifications available: ");
		for (WebElement each : cert) {
			String text = each.getText();
			System.out.println(text);
		}
		moveto.click();

		List<WebElement> cert1 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("Application Architect Certifications available: ");
		for (WebElement each : cert1) {
			String text = each.getText();
			System.out.println(text);
		}

		WebElement snapele = driver.findElement(By.xpath("//a[text()='Platform App Builder']"));
		act.scrollToElement(snapele).perform();

		File src = driver.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./snaps/archcert.png");
		FileUtils.copyFile(src, Dest);

		driver.quit();
	}

}
