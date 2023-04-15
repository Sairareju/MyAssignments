package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		WebElement MenElement = driver.findElement(By.xpath("//span[text()=\"Men's Fashion\"]"));
		// driver.executeScript("arguments[0],click();", MenElement);
		MenElement.click();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
		String SportsCount = driver.findElement(By.xpath("//h1[@class='category-name']/following-sibling::span"))
				.getText();
		String SportsCount1 = SportsCount.replace("(", "");
		String SportsCount2 = SportsCount1.replace(")", "");
		System.out.println("Number of Sports shoes displayed: " + SportsCount2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		driver.findElement(By.xpath("//li[@class='search-li']")).click();
		String Sortselect = driver.findElement(By.xpath("//div[@class='sort-selected']")).getText();
		if (Sortselect.contains("Low To High")) {
			System.out.println("Sorting done from Price low to high");
		}

		WebElement Scroll = driver.findElement(By.xpath("(//div[@class='filter-type-name lfloat'])[2]"));
		Actions Act = new Actions(driver);
		Act.scrollToElement(Scroll).perform();

		WebElement LowRange = driver.findElement(By.xpath("//div[@class='price-text-box']/input[@name='fromVal']"));
		LowRange.clear();
		LowRange.sendKeys("900", Keys.ENTER);

		WebElement HighRange = driver.findElement(By.xpath("//div[@class='price-text-box']/input[@name='toVal']"));

		String attribute = HighRange.getAttribute("value");

		int parseInt = Integer.parseInt(attribute);

		if (parseInt > 1200) {
			HighRange.clear();
			HighRange.sendKeys("1200", Keys.ENTER);
			driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		}

		else
			driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();

		Thread.sleep(3000);

		WebElement size = driver.findElement(By.xpath("(//div[@class='filter-type-name lfloat'])[4]"));
		Act.scrollToElement(size).perform();
		driver.findElement(By.xpath("//button[text()='View More ']")).click();

		driver.findElement(By.xpath("//label[@for='Color_s-Yellow']")).click();

		Thread.sleep(3000);

		List<WebElement> filters = driver.findElements(By.xpath("//div[@class='navFiltersPill']"));

		for (WebElement each : filters) {

			String text = each.getText();

			if (text.contains("Price")) {
				System.out.println("Price filter applied");
			}

			else if (text.contains("Color")) {
				System.out.println("Color filter applied");
			}

		}

		WebElement Picture = driver.findElement(By.xpath("//picture[@class='picture-elem']"));
		Act.moveToElement(Picture).perform();
		driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]")).click();
		Thread.sleep(3000);
		String Price = driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText();
		System.out.println("Price of the selected shoes: " + Price);
		String Disc = driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText();
		System.out.println("Discounted % of the selected shoes: " + Disc);

		File src = driver.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./snaps/snapdeal.png");
		FileUtils.copyFile(src, Dest);

		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();

		Thread.sleep(3000);

		driver.close();
	}

}
