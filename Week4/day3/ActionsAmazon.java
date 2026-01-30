package week4.day3;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsAmazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		//Initialize ChromeDriver
		 ChromeDriver driver=new ChromeDriver();
		 // Load the URL (https://www.amazon.in/)
		 driver.get("https://www.amazon.in/");
		 //Maximize the browser window
		 driver.manage().window().maximize();
		 //Add an implicit wait to ensure the webpage elements are fully loaded
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		 WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		 //Enter "oneplus 9 pro" in the search box
		 searchbox.sendKeys("oneplus 9 pro",Keys.ENTER);
		 //Get the price of the first product
		 WebElement mobilebagCasePrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		 System.out.println("Mobile Price of the product - Rs." + mobilebagCasePrice.getText());
		 //Print the number of customer ratings for the first displayed product.
		 System.out.println("Customer rating of the product - " + driver.findElement(By.xpath("//div[@class='a-row a-size-small']/span[1]")).getText()+"***");
		 //Click the first text link of the first image.
		 Actions action=new Actions(driver);
		 action.moveToElement(driver.findElement(By.xpath("(//div[@data-cy='title-recipe']//h2)[1]"))).click().perform();
		 Set<String> parentWindowid = driver.getWindowHandles();
		 List<String> currentlyActiveWindow=new ArrayList<String>(parentWindowid);
		 driver.switchTo().window(currentlyActiveWindow.get(currentlyActiveWindow.size()-1));
		 Thread.sleep(3000);
		 //Take a screenshot of the product displayed.
		  File screenshotofTheDisplayedProduct = driver.getScreenshotAs(OutputType.FILE);
		  File target=new File("./Actions/screenshotoftheproduct.png");
		  FileUtils.copyFile(screenshotofTheDisplayedProduct, target);
		 //Click the 'Add to Cart' button
		 driver.findElement(By.id("atc-declarative")).click();
		 // Get the cart subtotal and verify if it is correct
		 String cartsubtotal = driver.findElement(By.xpath("//span[@class='a-price sw-subtotal-amount']")).getText();
		 if(cartsubtotal.equals(0))
		 {
			 System.out.println("CartSubtotal is 0");
		 }
		 else
		 {
			 System.out.println("Cart subtotal: " + cartsubtotal);
		 } 
		 driver.close();
	}
}
