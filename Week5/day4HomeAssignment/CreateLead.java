package week5.day4HomeAssignment;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week5.day4.ProjectSpecificMethod;

public class CreateLead extends ProjectSpecificMethod {
	
	@BeforeTest
	public void sendLeadData() {
	fileName="CreateLead";
	}

		@Test(dataProvider ="extractData")
		public void runlead(String cname , String fname, String lname, String phNo) {
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lname);
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNo);
			driver.findElement(By.name("submitButton")).click();
			String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			if (text.contains("Testleaf")) {
				System.out.println("Lead created successfully");
			}
			else {
				System.out.println("Lead is not created");	
			}
			
	}

}