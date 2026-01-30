package week4.day3;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableInteractionandDataVerification {

	public static void main(String[] args) {
		 //Initialize ChromeDriver
		 ChromeDriver driver=new ChromeDriver();
		 //Load the URL (https://erail.in/)
		 driver.get("https://erail.in/");
		 //Maximize the browser window
		 driver.manage().window().maximize();
		 //Add an implicit wait to ensure the webpage elements are fully loaded
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		 //Enter "MAS" as the "From" station.
		 WebElement txtStationFrom = driver.findElement(By.id("txtStationFrom"));
		 txtStationFrom.clear();
		 txtStationFrom.sendKeys("MAS",Keys.ENTER);
		 // Enter "MDU" as the "To" station.
		 WebElement txtStationTo = driver.findElement(By.id("txtStationTo"));
		 txtStationTo.clear();
		 txtStationTo.sendKeys("MDU",Keys.ENTER);
		 // Uncheck the "Sort on Date" checkbox.
		 driver.findElement(By.xpath("//label[text()='Sort on Date']")).click();
		 //Retrieve the train names from the web table
		 int totalNoOfRows= driver.findElements(By.xpath("//table[contains(@class,'DataTable')]/tbody/tr")).size();
		 System.out.println("Total number of trains with duplicates = "+totalNoOfRows);
		 Set<String> TrainNameset = new LinkedHashSet<String>();
		 for (int i = 2; i <=totalNoOfRows; i++) {
			 String trainNameFromTable = driver.findElement(By.xpath("//table[contains(@class,'DataTable')]/tbody/tr["+i+"]/td[2]")).getText();
			 System.out.println(trainNameFromTable);
			 TrainNameset.add(trainNameFromTable);
		 }
		 System.out.println("Total Number of unique trains = " +TrainNameset.size());
		 for (String trainNameList : TrainNameset) {
			 System.out.println(trainNameList);
				
			}
			
	}

}
