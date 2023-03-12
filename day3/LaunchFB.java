package week2.day3;

import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchFB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.close();
	}

}
