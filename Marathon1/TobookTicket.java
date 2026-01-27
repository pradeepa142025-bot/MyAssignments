package seleniumbasicsmarathon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TobookTicket {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.pvrcinemas.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Click on Cinema under Quick Book
		driver.findElement(By.xpath("//div[@class='date-show']/span[2]")).click();
		Thread.sleep(1000);
		//To click on cinema
		driver.findElement(By.id("cinema")).click();
		Thread.sleep(2000);
		//To select a Cinema drop down
		driver.findElement(By.xpath("(//li[@class='p-dropdown-item']/span)[1]")).click();
		Thread.sleep(2000);
		//To select particular date
		driver.findElement(By.xpath("//li[2]/span[contains(text(),'Tomorrow')]")).click();
		Thread.sleep(1000);
		//To Select particular Movie
		//driver.findElement(By.xpath("(//li[@class='p-dropdown-item']/span)[1]")).click();
		driver.findElement(By.xpath("(//div[@class='p-dropdown-panel p-component p-ripple-disabled p-connected-overlay-enter-done']//li[@class='p-dropdown-item'])[5]")).click();
		//Click on Select Timing drop down
		//driver.findElement(By.id("time")).click();
		//To Select particular time
		driver.findElement(By.xpath("(//li[@class='p-dropdown-item']//span[@class='mx-2'])[2]")).click();
		Thread.sleep(1000);
		//Click on Book button
		driver.findElement(By.xpath("(//span[text()='Book'])[4]")).click();
		// Accept Terms and Conditions
		driver.findElement(By.xpath("//button[text()='Accept']")).click();
		//Select any one available seat
		driver.findElement(By.xpath("//span[@class='seat-current-pvr']")).click();
		// Click on Proceed button
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		//Capture and print Seat info from Booking Summary
		WebElement seatInfo = driver.findElement(By.className("seat-number"));
		System.out.println(seatInfo.getText());
		//Capture and print Grand Total from Booking Summary
		WebElement grandTotal = driver.findElement(By.xpath("//div[@class='grand-prices']"));
		System.out.println(grandTotal.getText());
		//Click on Continue button
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		//Close the pop-up
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
		//Capture and print current page title
		System.out.println(driver.getTitle());
		//Quit the browser
		driver.quit();
	}

}

