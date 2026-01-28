package week3.day3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		searchbox.sendKeys("phones",Keys.ENTER);
		List<WebElement> phonePrice = driver.findElements(By.className("a-price-whole")); 
		System.out.println(phonePrice.size());
		List<Integer> phonepriceList = new ArrayList<Integer>();
		for (int i = 0; i < phonePrice.size(); i++) {
			String Phonepricetext = phonePrice.get(i).getText();
			String formattedphonePrice = Phonepricetext.replaceAll("\\D","");
			System.out.println(formattedphonePrice);
			if(!formattedphonePrice.isEmpty())
			{
				int replacedphonePrice = Integer.parseInt(formattedphonePrice);
				System.out.println(replacedphonePrice);
				phonepriceList.add(replacedphonePrice);
			}
			
		}
		
		Collections.sort(phonepriceList);
		System.out.println("Lowest mobile price");
		System.out.println(phonepriceList.get(0));
		
	}
}
