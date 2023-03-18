package weeks2.day2.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {

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
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();

		driver.findElement(By.id("firstNameField")).sendKeys("Test");
		driver.findElement(By.id("lastNameField")).sendKeys("Leaf");
		
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Test");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Leaf");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Quality");

		driver.findElement(By.id("createContactForm_description")).sendKeys("Assignment");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("reju@gmail.com");

		WebElement state = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select stateid = new Select(state);
		stateid.selectByVisibleText("New York");

		Thread.sleep(3000);

		driver.findElement(By.name("submitButton")).click();
		
		driver.findElement(By.linkText("Edit")).click();

		WebElement desc = driver.findElement(By.id("updateContactForm_description"));
		desc.clear();

		Thread.sleep(3000);

		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Update required");

		driver.findElement(By.xpath("//input[@name='submitButton']")).click();

		String sub = driver.getTitle();
		System.out.println(sub);

		String endtitle = driver.getTitle();

		System.out.println(endtitle);

		Thread.sleep(3000);

		driver.close();

	}

}
