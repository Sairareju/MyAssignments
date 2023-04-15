package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LeafTapCloseall {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");

		ChromeDriver driver = new ChromeDriver(options);
		options.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		String pwindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		for (String each : windowHandles) {
			System.out.println(each);
			if (!each.equals(pwindow)) {
				driver.switchTo().window(each);
				String ctitle = driver.getTitle();
				System.out.println("Child window title: " + ctitle);
				Thread.sleep(1000);
				driver.close();
			}
		}
	}
}
	
