package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdown2 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		WebElement dropdown = driver.findElement(By.xpath("//label[text()='Select Country']"));
		dropdown.click();
		Select dropdownOption=new Select(dropdown);
		List<WebElement> selectedOptions = dropdownOption.getOptions();
		System.out.println(selectedOptions);
		int size = selectedOptions.size();
		System.out.println(size);
		for(int i=0;i<selectedOptions.size();i++)
		{
			System.out.println("Option " + i + ": " + selectedOptions.get(i).getText());
			if(i==2)
			{
				dropdownOption.selectByIndex(i);
				Thread.sleep(5000);
				selectedOptions.get(i).getText();

			}
		}
	}

}
