package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AccountCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Precondition:
   			- Initialize the WebDriver (ChromeDriver).
			- Load the URL http://leaftaps.com/opentaps/.
			- Maximize the browser window.
		Requirements:
			- Enter a username and password.
			- Click the "Login" button.
			- Click on the "CRM/SFA" link.
			- Click on the "Accounts" tab.
			- Click on the "Create Account" button.
			- Enter an account name.
			- Enter a description as "Selenium Automation Tester."
			- Enter a Number Of Employees.
			- Enter a Site Name as “LeafTaps”
			- Click the "Create Account" button.
			- Verify that the Title is displayed correctly.
			- Close the browser window.
		 */
		
		//Intializing the driver
		FirefoxDriver driver=new FirefoxDriver();
		//Launch the Url
		driver.get("http://leaftaps.com/opentaps/");
		//Maximize the browser window
		driver.manage().window().maximize();
		//locate the usename and enter the username
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys("demosalesmanager");
		//locate the password and enter the password
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("crmsfa");
		//click on login button
		driver.findElement(By.className("decorativeSubmit")).click();
		//locate and click on the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//locate and click on the Accounts tab
		driver.findElement(By.partialLinkText("Accounts")).click();
		//locate and click on the Create Account tab
		driver.findElement(By.linkText("Create Account")).click();
		//locate and enter the Accountname
		WebElement accountName = driver.findElement(By.id("accountName"));
		accountName.sendKeys("pradeepa baskar");
		//locate and enter the description
		WebElement description = driver.findElement(By.name("description"));
		description.sendKeys("Selenium Automation Tester");
		//locate and enter the number of employees
		driver.findElement(By.id("numberEmployees")).sendKeys("10567");
		//locate the webelement and enter the sitename
		WebElement siteName = driver.findElement(By.id("officeSiteName"));
		siteName.sendKeys("LeafTaps");
		//locate the webelement and click on account creation
		driver.findElement(By.className("smallSubmit")).click();
		//locate and get the Title of the webpage
		String title = driver.getTitle();
		System.out.println(title);
		//verify the title of the webpage 
		if(title.equalsIgnoreCase("Create Account | opentaps CRM"))
		{
			System.out.println("Title verified sucessfully");
		}
		else
		{
			System.out.println("Title mismatched");
		}
		
	}

}
