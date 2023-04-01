package marathon2.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class Orderingmobile {

	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://dev57553.service-now.com/");
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("2oaD6KN$q$vN");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		Shadow dom = new Shadow(driver);
		dom.setImplicitWait(30);
		dom.findElementByXPath("//div[@id='all']").click();

		dom.findElementByXPath("//span[text()='Service Catalog']").click();

		WebElement iframeele = dom.findElementByXPath("//iframe[@title='Main Content']");
		driver.switchTo().frame(iframeele);
		driver.findElement(
				By.xpath("(//div[@class='drag_section'])[8]/table/tbody/tr/td[4]/a[contains(text(),'Mobiles')]"))
				.click();
		WebElement scrltoele = dom.findElementByXPath("//a[text()='Apple iPhone 6s']");

		Actions act = new Actions(driver);
		act.scrollToElement(scrltoele).perform();
		scrltoele.click();
		WebElement color = driver.findElement(
				By.xpath("(//table[@id='item_table']//table)[7]/tbody[1]/tr[5]/td[1]/div[1]/div[1]/div[2]/select[1]"));
		Select cgold = new Select(color);
		cgold.selectByVisibleText("Gold");

		WebElement strge = driver.findElement(
				By.xpath("(//table[@id='item_table']//table)[7]/tbody[1]/tr[6]/td[1]/div[1]/div[1]/div[2]/select[1]"));
		Select storge = new Select(strge);
		storge.selectByValue("onetwentyeight");

		driver.findElement(By.xpath("//table[@id='qty']/tbody[1]/tr[8]/td[1]/button[1]")).click();
		String order = driver.findElement(By.xpath("//div[@id='sc_order_status_intro_text']/dl")).getText();
		if (order.contains("Placed")) {
			System.out.println("Order has been successfully placed");
			String reqnum = driver.findElement(By.xpath("//a[@class='linked requestItemUrl']//b[1]")).getText();
			System.out.println("The order request number is: " + reqnum);
		}

		else {
			System.out.println("Order has not been placed");
		}

		File src = driver.getScreenshotAs(OutputType.FILE);
		File Dest = new File("./snaps/ordermobile.png");
		FileUtils.copyFile(src, Dest);

		driver.quit();
	}

}
