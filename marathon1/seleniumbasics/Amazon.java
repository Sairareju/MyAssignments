package marathon1.seleniumbasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);

		options.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Bags");
		WebElement Boys = driver.findElement(By.xpath("//div[@class='s-suggestion-container']//span[contains(text(),'boys')]"));
		Boys.click();
		
		String word1 = driver.findElement(By.xpath("//span[contains(text(),'1-48')]")).getText();
		
		WebElement Boysword = driver.findElement(By.xpath("//div[@class='sg-col-inner']//span[contains(@class,'a-color-state')]"));
		String word2 = Boysword.getText();
		System.out.println(word1 + " " +word2);
		
		driver.findElement(By.xpath("//input[@type='checkbox']/following-sibling::i[contains(@class,'a-icon-checkbox')]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::i[contains(@class,'a-icon-checkbox')])[2]")).click();
		
		/*
		 * WebElement dd =
		 * driver.findElement(By.xpath("//select[@id='s-result-sort-select']")); Select
		 * newarr = new Select(dd); newarr.selectByValue("Newest Arrivals");
		 */
		
		driver.findElement(By.xpath("//span[@class='a-button-inner']/span[contains(@class,'a-declarative')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Newest Arrivals')]")).click();
		String name = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus')])")).getText();
				
		String info = driver.findElement(By.xpath("(//span[contains(@class,'a-size-base-plus')])[2]")).getText();
		
		
		
		WebElement price = driver.findElement(By.xpath("//div[@id='search']/div[1]/div[1]/div[1]/span[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/a[1]/span[1]/span[2]/span[2]"));
		String disprice = price.getText();
		
		System.out.println("Newest Arrival: "+name+" "+ info );
		System.out.println("Discounted Price: " + disprice);
		
		Thread.sleep(3000);
		
		driver.close();

	}

}
