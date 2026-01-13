package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		ChromeDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		WebElement usernameField = driver.findElement(By.id("username"));
		usernameField.sendKeys("demosalesmanager");
		driver.findElement(By.name("PASSWORD")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCLTech");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pradeepa");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Shanmugam");
		WebElement sourceDropDown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		// select class -->  Choosing the option based on index
		Select option = new Select(sourceDropDown);
		option.selectByIndex(7);
		WebElement marketingCampDropDown = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		// Choosing the option based on value as the attribute 
		Select  marketingOption = new Select(marketingCampDropDown);
		marketingOption.selectByVisibleText("Car and Driver");
		WebElement ownerShipDropDown = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownerShipOption=new Select(ownerShipDropDown);
		ownerShipOption.selectByValue("OWN_CCORP");
		driver.findElement(By.name("submitButton")).click();
		String title = driver.getTitle();
		System.out.println(title);
		//verify the title of the webpage 
		if(title.equalsIgnoreCase("Create Lead | opentaps CRM"))
		{
			System.out.println("Title verified sucessfully");
		}
		else
		{
			System.out.println("Title mismatched");
		}

	}

}
