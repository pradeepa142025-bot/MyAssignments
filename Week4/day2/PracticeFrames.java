package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PracticeFrames {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Initialize the chromeDriver
		ChromeDriver driver=new ChromeDriver();
		//Get the URL
		driver.get("https://www.leafground.com/frame.xhtml");
		//Use Implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Switch to the First Frame
		driver.switchTo().frame(0);
		//Locate the Webelement from the first frame
		WebElement firstFrameElement = driver.findElement(By.xpath(" //button[@id='Click']"));
		firstFrameElement.click();
		//Get the text from the clicked icon
		System.out.println(firstFrameElement.getText());
		//Switch to the root document
		driver.switchTo().defaultContent();
		//Switch to the 2nd frame
		driver.switchTo().frame(1);
		//locate the webelement for frame2
		WebElement framesecond = driver.findElement(By.xpath(" //button[@id='Click']"));
		framesecond.click();
		//Get the frame2 Webelement text
		System.out.println(framesecond.getText());
		//Switch to the root document
		driver.switchTo().defaultContent();
		//Switch to Frame3
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='page.xhtml']")));
		//Switch to Frame4
		driver.switchTo().frame("frame2");
		//Locate the Webelement from the nested frame
		WebElement nestedFrameElement = driver.findElement(By.xpath(" //button[@id='Click']"));
		nestedFrameElement.click();
		System.out.println(nestedFrameElement.getText());
		//Switch to the parent frame
		WebDriver parentFrame = driver.switchTo().parentFrame();
		
		//Take screenshot
		File src=driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./practiceframes/frames.png");
		FileUtils.copyFile(src, target);
		
	}

}
