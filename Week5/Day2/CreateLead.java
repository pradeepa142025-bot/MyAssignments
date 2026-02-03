package week5.day2;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
public class CreateLead extends ProjectSpecificMethod {
	
	@Test
	public void run1() {
		
		
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Testleaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Pradeepa");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Baskare");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("1234");
		driver.findElement(By.name("submitButton")).click();
		String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String expectedText="Testleaf";
		String[] split=text.split(" ");
		String actualText=split[0];
		assertEquals(actualText, expectedText);
		
	}
}


	

	


