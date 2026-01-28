package week2.day1;

import org.openqa.selenium.chrome.ChromeDriver;

public class ToLaunchFacebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declaring chromedriver to variable driver
		ChromeDriver driver=new ChromeDriver();
		//Get the URL
		driver.get("https://www.facebook.com");
		//maximize the browser
		driver.manage().window().maximize();
		//To get the title of the window
		String titleOfTheCurrentWindow=driver.getTitle();
		System.out.println(titleOfTheCurrentWindow);
		//close the browser
		driver.quit();
		
		
		

	}

}
