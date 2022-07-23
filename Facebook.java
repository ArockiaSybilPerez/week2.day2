package week2.day2;

import java.net.PasswordAuthentication;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	private static WebElement day;
	private static WebElement month;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		// Step 1: Download and set the path 
		WebDriverManager.chromedriver().setup();
		// Step 2: Launch the chromebrowser
		ChromeDriver driver = new ChromeDriver();
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		// Step 4: Maximise the window
		driver.manage().window().maximize();
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		// Step 6: Click on Create New Account button
		WebElement createNewAccount = driver.findElement(By.linkText("Create New Account"));
		createNewAccount.click();
		// Step 7: Enter the first name
		WebElement firstName = driver.findElement(By.name("firstname"));
		firstName.sendKeys("Lura");
		// Step 8: Enter the last name
		WebElement lastName = driver.findElement(By.name("lastname"));
		lastName.sendKeys("Pejo");
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//div[contains(text(),'Mobile number')]/following::input")).sendKeys("9487725147");		
		// Step 10: Enterthe password
		WebElement password = driver.findElement(By.id("password_step_input"));
		password.sendKeys("Sybilperez#1993");
		// Step 11: Handle all the three drop downs
		WebElement day = driver.findElement(By.id("day"));
		Select dayDropdown= new Select(day);
		Thread.sleep(2000);
		dayDropdown.selectByIndex(6);
		Thread.sleep(2000);
		dayDropdown.selectByValue("7");
		Thread.sleep(2000);
		dayDropdown.selectByVisibleText("7");
		
		WebElement month = driver.findElement(By.id("month"));
		Select monthDropdown= new Select(month);
		Thread.sleep(2000);
		monthDropdown.selectByIndex(9);
		Thread.sleep(2000);
		monthDropdown.selectByValue("10");
		Thread.sleep(2000);
		monthDropdown.selectByVisibleText("Oct");

		WebElement year = driver.findElement(By.id("year"));
		Select yearDropdown= new Select(year);
		Thread.sleep(2000);
		yearDropdown.selectByIndex(30);
		Thread.sleep(2000);
		yearDropdown.selectByValue("1993");
		Thread.sleep(2000);
		yearDropdown.selectByVisibleText("1993");

		//Step 12: Select the radio button "Female" 
		WebElement femaleRadioButton = driver.findElement(By.className("_8esa"));
		femaleRadioButton.click();
       
		//(A normal click will do for this step)
		driver.findElement(By.xpath("//div[@class='_1lch']//button")).click();
       
	
	}

}
