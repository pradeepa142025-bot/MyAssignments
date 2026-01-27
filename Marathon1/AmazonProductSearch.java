package seleniumbasicsmarathon;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import week3.day3.ListInterface;

public class AmazonProductSearch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver=new ChromeDriver();
		// Load the application URL
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		//Used implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		//Enter "Bags for boys" in the search box
		searchbox.sendKeys("Bags for boys",Keys.ENTER);
		//Printed the total number of search results
		WebElement searchResults = driver.findElement(By.xpath("//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']"));
		System.out.println(searchResults.getText());
		//Selected the first two brands from the left-side filter
		driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[15]")).click();
		WebElement gearCheckBox = driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'])[16]"));
		gearCheckBox.isSelected();
		//Selecting the Feature dropdown
		driver.findElement(By.xpath("//span[@class='a-button-text a-declarative']/span[2]")).click();
		//Selecting "New Arrivals"
		WebElement featuredDropDoown = driver.findElement(By.xpath("//a[text()='Newest Arrivals']"));
		featuredDropDoown.click();
		//printed the first product name and discounted price)
		WebElement productName = driver.findElement(By.xpath("(//h2[contains(@class,'a-size-base-plus a-spacing-none a-color-base a-text-normal')])[1]"));
		System.out.println(productName.getText());
		//printed the first product discounted price
		WebElement bagPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		System.out.println(bagPrice.getText());
		//print the page title
		String title=driver.getTitle();
		System.out.println(title);
		if(title.equalsIgnoreCase("Amazon.in: Bags For Boys - 418063"))
			{
				System.out.println("Title verified sucessfully");
			}	
		else
			{
			System.out.println("Title mismatched sucessfully");
			}
	}

}
