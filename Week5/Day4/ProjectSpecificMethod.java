package week5.day4;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import week5.day4HomeAssignment.ReadExceldata;

public class ProjectSpecificMethod {
	
	public RemoteWebDriver driver;
	public String fileName;
	
	@Parameters({"username","password","url","browserName"})
	@BeforeMethod
	public void PreCondition(String uname,String passwd,String appurl,String executionEnv)
	{
		
		switch (executionEnv.toLowerCase()) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--guest");
			driver = new ChromeDriver(options);
			break;
		case "firefox" :
			driver = new FirefoxDriver();
			break;

		default:
			ChromeOptions defaultOptions = new ChromeOptions();
			defaultOptions.addArguments("--guest");
			driver = new ChromeDriver(defaultOptions);
			break;
		}
		driver.manage().window().maximize();
		driver.get(appurl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(passwd);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
	}
	
	@DataProvider(name = "extractData")
	public String[][] dataLibrary() throws IOException {
    return ReadExceldata.extractDataFromExcel(fileName); 
	}
	
	@AfterMethod
	public void PostCondition()
	{
		driver.quit();
	}
}
