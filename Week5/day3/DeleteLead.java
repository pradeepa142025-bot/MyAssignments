package week5.day3;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class DeleteLead extends ProjectSpecificMethod  {
		
		@Test
		public void run2() throws InterruptedException {
			 
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.xpath("//span[text()='Phone']")).click();
			driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("98127");
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(2000);
			String leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			//Wait for element to be clickable
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete")));
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			//js.executeScript("arguments[0].click();", driver.findElement(By.linkText("Delete")));
			//driver.findElement(By.xpath("//a[contains(@class, 'subMenuButtonDangerous')]")).click();
			driver.findElement(By.linkText("Find Leads")).click();
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
			driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			Thread.sleep(3000);
			String text = driver.findElement(By.className("x-paging-info")).getText();
			if (text.equals("No records to display")) {
				System.out.println("Lead deleted successfully");
			} else {
				System.out.println("Lead is not deleted ");
			}
			driver.close();

		}

	}

