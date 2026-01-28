package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Precondition: - - - 
			Initialize the WebDriver (ChromeDriver). 
			Load the URL http://leaftaps.com/opentaps/. 
			Maximize the browser window. 
		Requirements: - - - - - - - - - - - - 
			Enter a username and password. 
			Click the "Login" button. 
			Click on the "CRM/SFA" link. 
			Click on the "Leads" tab. 
			Click on the "Create Lead" button. 
			Enter a FirstName. 
			Enter a LastName. 
			Enter a CompanyName. 
			Enter a Title . 
			Click the "Create Lead" button. 
			Verify that the Title is displayed correctly. 
			Close the browser window.
		 */
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		WebElement usernameField = driver.findElement(By.xpath("//input[@id='username']"));
		usernameField.sendKeys("demosalesmanager");
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.sendKeys("crmsfa");
		//click on login button
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		//locate and click on the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		//locate and click on the Leads tab
		driver.findElement(By.linkText("Leads")).click();
		//locate and click on the Create Lead button
		driver.findElement(By.linkText("Create Lead")).click();
		//locate and enter the FirstName
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pradeepa");
		//locate and enter the LastName
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Shanmugam");
		//locate and enter the CompanyName
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCLTech");
		//locate and Click the "Create Lead" button
		driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
		//locate and get the Title of the webpage
		String title = driver.getTitle();
		System.out.println(title);
		//verify the title of the webpage 
		if(title.equalsIgnoreCase("View Lead | opentaps CRM"))
		{
			System.out.println("Title verified sucessfully");
		}
		else
		{
			System.out.println("Title mismatched");
		}

	}

}
