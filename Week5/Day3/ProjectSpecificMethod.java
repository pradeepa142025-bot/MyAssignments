package week5.day3;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class ProjectSpecificMethod {
	
ChromeDriver driver;
	
	@Parameters({"username","password","url","browsername"})
	@BeforeMethod
	public void PreCondition(String uname,String passwd,String appurl)
	{
		ChromeOptions options = new ChromeOptions();
		  options.addArguments("--guest");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(appurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(passwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	@AfterMethod
	public void PostCondition()
	{
		driver.quit();
	}

}
