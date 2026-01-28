package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomatingFrameandAlertInteractions {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Initialize ChromeDriver
		ChromeDriver driver=new ChromeDriver();
		//Load the URL (https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm)
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//Maximize the browser window
		driver.manage().window().maximize();
		//Add an implicit wait to ensure the webpage elements are fully loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		//Switch to the frame
		driver.switchTo().frame(0);
	    // Click the "Try It" button inside the frame
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		//Switch to alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//verifying the text displayed
		WebElement text = driver.findElement(By.xpath("//p[@id='demo']"));
		System.out.println(text.getText());
		File src=driver.getScreenshotAs(OutputType.FILE);
		File target=new File("./snap/alert.png");
		FileUtils.copyFile(src, target);

	}

}
