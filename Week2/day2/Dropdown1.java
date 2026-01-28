package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		WebElement dropdown = driver.findElement(By.className("ui-selectonemenu"));
		dropdown.click();
		Select dropdownOption=new Select(dropdown);
		List<WebElement> selectedOptions = dropdownOption.getOptions();
		int size = selectedOptions.size();
		
		System.out.println(size);
		for(int i=0;i<selectedOptions.size();i++)
		{
			Thread.sleep(2000);
			selectedOptions.get(3).click();
			if(i==3 || i==5)
			{
				System.out.println(selectedOptions.get(i));
			}
		}
	}

}
