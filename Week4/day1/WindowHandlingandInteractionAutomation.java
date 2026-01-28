package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandlingandInteractionAutomation {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		//Get the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		//Use Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Enter the username and password.
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("demosalesmanager");
		//locate the password and enter the password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		//Click on the Login button
		driver.findElement(By.className("decorativeSubmit")).click();
		//Click on the CRM/SFA link.
		driver.findElement(By.linkText("CRM/SFA")).click();
		//Click on the Contacts button.
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();	
		//Click on Merge Contacts
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		//Click on the widget of the "From Contact"
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> currentlyActiveWindowIds = driver.getWindowHandles();
		ArrayList<String> listOfCurrentlyActiveWindowsID= new ArrayList<String>(currentlyActiveWindowIds);
		driver.switchTo().window(listOfCurrentlyActiveWindowsID.get(1));
		Thread.sleep(2000);
		//Click on the first resulting contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		driver.switchTo().window(listOfCurrentlyActiveWindowsID.get(0));
		Thread.sleep(2000);
		//Click on the widget of the "To Contact".
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> currentlyActiveWindowIds2 = driver.getWindowHandles();
		ArrayList<String> listOfCurrentlyActiveWindowsID2= new ArrayList<String>(currentlyActiveWindowIds2);
		driver.switchTo().window(listOfCurrentlyActiveWindowsID2.get(1));
		Thread.sleep(2000);
		//Click on the second resulting contact.
		driver.findElement(By.xpath("(//a[@class='linktext'])[6]")).click();
		driver.switchTo().window(listOfCurrentlyActiveWindowsID2.get(0));
		Thread.sleep(2000);
		//Click on the Merge button
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
	    // Accept the alert.
		driver.switchTo().alert().accept();
		//Verify the title of the page
		String title = driver.getTitle();
		System.out.println(title);
		//verify the title of the webpage 
		if(title.equalsIgnoreCase("View Contact | opentaps CRM"))
		{
			System.out.println("Title verified sucessfully");
		}
		else
		{
			System.out.println("Title mismatched");
		}
		
	}

}
