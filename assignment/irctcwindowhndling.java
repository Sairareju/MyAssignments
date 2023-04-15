package week4.day1.assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class irctcwindowhndling {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.irctc.co.in/nget/train-search");
		driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
		String ptitle = driver.getTitle();
		System.out.println("Parent Title: " + ptitle);
		// String pwindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles.size());
		List<String> list = new ArrayList<>(windowHandles);
		driver.switchTo().window(list.get(1));
		String ctitle = driver.getTitle();
		System.out.println("Child window title: " + ctitle);
//--If we have more than 1 child window, go for for-each loop. But if we have only 1 child, then above three 
//--		line of code is enough

//		for (String each : windowHandles) {
//			System.out.println(each);
//			if (!each.equals(pwindow)) {
//				driver.switchTo().window(each);
//				String ctitle = driver.getTitle();
//				System.out.println("Child window title: " + ctitle);
//
//			}
//
//		}

	}

}
