package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ChromeDriver driver=new ChromeDriver();
		// Load the application URL
		driver.get("https://www.irctc.co.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		driver.findElement(By.xpath("//label[text()='FLIGHTS']")).click();
		//String childWindowId = driver.getWindowHandle();
		//System.out.println(childWindowId);
		Set<String> currentlyActiveWindowIds = driver.getWindowHandles();
		ArrayList<String> listOfCurrentlyActiveWindowsID= new ArrayList<String>(currentlyActiveWindowIds);
		driver.switchTo().window(listOfCurrentlyActiveWindowsID.get(listOfCurrentlyActiveWindowsID.size()-1)); 
		System.out.println(driver.getTitle());
		driver.switchTo().window(listOfCurrentlyActiveWindowsID.get(0));
		driver.quit();
		

	}

}
