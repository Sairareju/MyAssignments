package week4.day2.assignments;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro", Keys.ENTER);

		WebElement PhoneEle = driver
				.findElement(By.xpath("(//span[contains(@class,'a-color-base a-text-normal')])[2]"));
		String PriceofFirstEle = driver.findElement(By.xpath("//span[@class='a-price-whole']")).getText();
		PriceofFirstEle = PriceofFirstEle.replaceAll("[^a-zA-Z0-9]", "");
		String NameofPhone = PhoneEle.getText();
		System.out.println("Price of " + NameofPhone + ": " + PriceofFirstEle);
		PhoneEle.click();

		Set<String> windowHandles = driver.getWindowHandles();

		List<String> list = new ArrayList<>(windowHandles);
		driver.switchTo().window(list.get(1));

		String CustRating = driver.findElement(By.xpath("//span[@id='acrCustomerReviewText']")).getText();
		System.out.println("Number of customer Rating for " + NameofPhone + ": " + CustRating);

		File src = driver.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./snaps/onplus.png");
		FileUtils.copyFile(src, Dest);

		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();

		Thread.sleep(5000);

		String SubTotal = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		Thread.sleep(3000);

		int end = SubTotal.indexOf(".");
		SubTotal = SubTotal.substring(0, end);
		System.out.println(SubTotal);
		SubTotal = SubTotal.replaceAll("[₹,]", "");

		System.out.println("Sub total in cart: " + SubTotal);

		SubTotal = SubTotal.replaceAll("[^a-zA-Z0-9]", "");
		PriceofFirstEle = PriceofFirstEle.replaceAll("[^a-zA-Z0-9]", "");
		int PriceofFirst = Integer.parseInt(PriceofFirstEle);
		int SubTtal = Integer.parseInt(SubTotal);
		if (PriceofFirst == SubTtal) {

			System.out.println("Both price matches ");
		}

		else
			System.out.println("Prices does not match");

		driver.quit();

	}

}
