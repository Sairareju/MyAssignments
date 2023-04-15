package week4.day2.assignments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		Actions Act = new Actions(driver);
		WebElement brands = driver.findElement(By.xpath("//a[text()='brands']"));
		Act.moveToElement(brands).perform();
		driver.findElement(By.xpath("//input[@id='brandSearchBox']")).sendKeys("L'Oreal Paris", Keys.ENTER);
		driver.findElement(By.xpath("//a[text()=\"L'Oreal Paris\"]")).click();
		String Loreal = driver.getTitle();
		if (Loreal.contains("L'Oreal Paris")) {
			System.out.println("L'Oreal Paris page has been loaded");
		}

		WebElement sort = driver.findElement(By.xpath("//span[text()='Hair Type']"));
		Act.moveToElement(sort).perform();
		Thread.sleep(3000);

		WebElement Toprated = driver
				.findElement(By.xpath("(//*[name()='svg' and @class='arrow-icon']//*[local-name()='path'])"));
		Thread.sleep(5000);

		Act.click(Toprated).perform();

		driver.findElement(By.xpath("//span[text()='customer top rated']/parent::div/following-sibling::div")).click();
		WebElement Category = driver.findElement(By.xpath(
				"//span[text()='Category']/following-sibling::div//*[name()='svg' and @class='arrow-icon']//*[local-name()='path']"));
		Thread.sleep(5000);
		Act.click(Category).perform();
		WebElement Hair = driver.findElement(By.xpath(
				"//span[text()='Hair']/following-sibling::span//*[name()='svg' and @class='arrow-icon']//*[local-name()='path']"));
		Thread.sleep(5000);
		Act.click(Hair).perform();
		WebElement HairCare = driver.findElement(By.xpath(
				"//span[text()='Hair Care']/following-sibling::span//*[name()='svg' and @class='arrow-icon']//*[local-name()='path']"));
		Thread.sleep(5000);
		Act.click(HairCare).perform();
		driver.findElement(By.xpath("//span[text()='Shampoo']/parent::div/following-sibling::div")).click();
		WebElement Gender = driver.findElement(By.xpath("//span[text()='Gender']"));

		Act.moveToElement(Gender).perform();
		driver.findElement(By.xpath("//span[text()='Concern']")).click();

		Act.moveToElement(Gender).perform();

		driver.findElement(
				By.xpath("//label[contains(@for,'Protection_10764')]//div[@class='control-indicator checkbox ']"))
				.click();
		List<WebElement> Filters = driver.findElements(By.xpath("//div[@class='css-1emjbq5']"));
		System.out.println("Filters applied are: ");
		for (WebElement each : Filters) {
			String text = each.getText();
			System.out.println(text);

		}

		driver.findElement(By.xpath(
				"//div[@class='css-1rd7vky']/div[contains(text(),\"L'Oreal Paris Colour Protect Shampoo With UVA & UVB\")]"))
				.click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> listhandles = new ArrayList<String>(windowHandles);
		driver.switchTo().window(listhandles.get(1));

		driver.findElement(By.xpath("//span[text()='180ml']")).click();

		List<WebElement> Price = driver.findElements(By.xpath("(//div[@class='css-1d0jf8e'])[1]"));
		for (WebElement each : Price) {
			String text = each.getText();
			System.out.println(text);

		}

		driver.findElement(By.xpath("//span[text()='Add to Bag']")).click();
		Thread.sleep(5000);
		WebElement AddToBag = driver
				.findElement(By.xpath("//button[@class='css-aesrxy']//*[name()='svg']//*[local-name()='path']"));
		Act.click(AddToBag).perform();
		Thread.sleep(5000);

		WebElement findElement2 = driver.findElement(By.xpath("//iframe[@class='css-acpm4k']"));
		driver.switchTo().frame(findElement2);

		String SubTotal = driver.findElement(By.xpath("//span[contains(@class,'css-1um1mkq')]")).getText();
		SubTotal = SubTotal.replaceAll("[^a-zA-Z0-9]", "");
		int Sub_Total = Integer.parseInt(SubTotal);
		System.out.println("Grand Total Amount :" + Sub_Total);

		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		driver.findElement(By.xpath("//span[@class='css-175whwo ehes2bo0']")).click();
		String GrandTotal = driver
				.findElement(By.xpath(
						"//div[contains(@class,'css-46b9vi')]/following-sibling::p[contains(@class,'css-1e59vjt')]"))
				.getText();

		System.out.println("GrandTotal: " + GrandTotal);
		GrandTotal = GrandTotal.replaceAll("[^a-zA-Z0-9]", "");
		int Grand_Total = Integer.parseInt(GrandTotal);
		if (Grand_Total == Sub_Total) {
			System.out.println("Grand total is same");
			driver.quit();

		}

	}

}
