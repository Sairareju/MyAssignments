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

public class administratorCertifications {

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
		String ctitle = driver.getTitle();
		System.out.println(ctitle);
		WebElement admin = dom.findElementByXPath("//a[text()='Administrator']");
		act.scrollToElement(admin).perform();
		admin.click();
		List<WebElement> cert = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for (WebElement each : cert) {
			String text = each.getText();
			System.out.println(text);

		}
		WebElement Endele = driver.findElement(By.xpath("//a[text()='Business Administration Specialist']"));
		act.scrollToElement(Endele).perform();
		File src = driver.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./snaps/admincert.png");
		FileUtils.copyFile(src, Dest);

		driver.quit();

	}

}
