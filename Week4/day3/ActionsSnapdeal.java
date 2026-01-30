package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class ActionsSnapdeal{

	public static void main(String[] args) throws InterruptedException, IOException {
		//Initialize ChromeDriver
		 ChromeDriver driver=new ChromeDriver();
		 // Load the URL (https://www.snapdeal.com/)
		 driver.get("https://www.snapdeal.com/");
		 
		 //maximize the browser
		 driver.manage().window().maximize();
		 
		 //Add an implicit wait to ensure the webpage elements are fully loaded
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	     
		 //Go to "Men's Fashion"
		 Actions action=new Actions(driver);
		 action.moveToElement(driver.findElement(By.id("tab-category-0"))).click().build().perform();
		 
		 //Go to "Sports Shoes".
		 action.moveToElement(driver.findElement(By.xpath("(//div[contains(text(),'Sports')])[2]"))).click().build().perform();
		 
		 //Get the count of sports shoes.
		 System.out.println("Total count of sport shoes - " + driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText());
		 
		 //Click on "Training Shoes
		 action.moveToElement(driver.findElement(By.xpath("//div[text()='Training Shoes']"))).click().build().perform();
		 
		 //Sort the products by "Low to High"
		 action.moveToElement(driver.findElement(By.xpath("//div[@class='sort-drop clearfix']"))).click().perform();
		 action.moveToElement(driver.findElement(By.xpath("(//ul[@class='sort-value']//li)[2]"))).click().perform();
		 Thread.sleep(3000);
		 
		 //Scroll to the element
		 action.scrollToElement(driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"))).build().perform();
		 Thread.sleep(3000);
		 
		 //Select any price range ex:(500-700).
		 action.dragAndDropBy(driver.findElement(By.xpath("//div[@class='filter-inner']//a[1]")), 7, 0).build().perform();
		 Thread.sleep(3000);
		 action.scrollToElement(driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"))).build().perform();
		 Thread.sleep(3000);
		 action.dragAndDropBy(driver.findElement(By.xpath("//div[@class='filter-inner']//a[2]")), -170, 0).build().perform();
		 Thread.sleep(3000);
		 action.scrollToElement(driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']"))).build().perform();
		 Thread.sleep(3000);
		
		 //Filter by any colour
		 action.scrollToElement(driver.findElement(By.xpath("//span[@class='filter-color-tile White&Blue ']"))).build().perform();
		 Thread.sleep(5000);
		 
		 //Verify all the applied filters.
		 action.scrollToElement(driver.findElement(By.xpath("//label[@for='Color_s-White%20%26%20Blue']"))).build().perform();
		 Thread.sleep(3000);
		 
		 if(driver.findElement(By.xpath("//label[@for='Color_s-White%20%26%20Blue']")).isSelected())
		 {
			 System.out.println("Checkbox is selected");
		 }
		 else {
			 
			 System.out.println("Checkbox is not selected");
	          }
	   
		 Thread.sleep(3000);
		 //Mouse hover on the first resulting "Training Shoes"
		 action.moveToElement(driver.findElement(By.xpath("//a[@class='dp-widget-link hashAdded']"))).build().perform();
		 action.moveToElement(driver.findElement(By.xpath("//div[text()='Training Shoes']"))).click().build().perform();
		 Thread.sleep(3000);
		 //Click the "Quick View" button.
		 action.moveToElement(driver.findElement(By.xpath("//div[@class='clearfix row-disc']"))).click().build().perform();
		 //Print the cost and the discount percentage.
		 System.out.println("Asian Training shoe price is Rs." + driver.findElement(By.xpath("//span[@class='payBlkBig']")).getText());
		 Thread.sleep(3000);
		 System.out.println("Asian Training shoe discount price is " + driver.findElement(By.xpath("//span[@class='percent-desc ']")).getText());
		 // Take a snapshot of the shoes.
		 File screenshotofTheDisplayedProduct = driver.getScreenshotAs(OutputType.FILE);
		 File target=new File("./Actions/TrainingShoescreenshot.png");
		 FileUtils.copyFile(screenshotofTheDisplayedProduct, target);
		 //Close the current window.
		 driver.close();
		 //Close the main window.
		 driver.quit();
	}
}

