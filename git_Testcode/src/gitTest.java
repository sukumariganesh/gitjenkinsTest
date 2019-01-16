

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class gitTest {
	static WebDriver driver;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
			
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Selenium Tutorial Total-QA");
		search.submit();
		takeScreenshot();	
		WebElement link = driver.findElement(By.partialLinkText("Selenium - Total-QA"));
		link.click();
		WebElement popup = driver.findElement(By.xpath("//a[contains(@id,'sendx-close')]"));
		popup.click();
		takeScreenshot();		
		}
		
public static  void takeScreenshot() throws IOException {
  		
  		TakesScreenshot tsh = (TakesScreenshot) driver;
		File scrFile = tsh.getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

}
