package worktype.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class EditWorktypeNegative {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement drop = driver.findElement(By.xpath("//p[text()='Work Types']"));
		driver.executeScript("arguments[0].click();", drop);
		WebElement c = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]"));
		c.click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[6]")).sendKeys("9");
		driver.findElement(By.xpath("(//input[@type='text'])[7]")).sendKeys("6");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		String actual_Result=driver.findElement(By.xpath("(//li[@class='form-element__help'])[1]")).getText();
		String expected_Result="Enter a Timeframe End number that is greater than the Timeframe Start number.: Timeframe Start";
		Assert.assertEquals(actual_Result,expected_Result);
		String actual_Result1=driver.findElement(By.xpath("(//li[@class='form-element__help'])[2]")).getText();
		String expected_Result1="Enter a Timeframe End number that is greater than the Timeframe Start number.: Timeframe End";
		Assert.assertEquals(actual_Result,expected_Result);

	}

}
