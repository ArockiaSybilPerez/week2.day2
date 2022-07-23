package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomCar {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//1) Launch chrome
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver= new ChromeDriver();
//2) Load https://www.zoomcar.com/in/bangalore
	driver.get("https://www.zoomcar.com/in/bangalore/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.findElement(By.className("country_list__wrapper--multiselect")).click();
	driver.findElement(By.xpath("//span[text()='India']")).click();
	driver.findElement(By.className("city_list__wrapper--multiselect")).click();
	driver.findElement(By.xpath("//span[text()='Bangalore']")).click();
	driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
//	3) Click on Pickup City
	driver.findElement(By.xpath("//div[@class='placeholder']")).click();
//	4) Click the fist suggested pick up location 
	driver.findElement(By.xpath("(//h3[text()='Suggested Pick Up Locations']/following::div)[2]")).click();
//	5) Click on Calendate date
	driver.findElement(By.xpath("//div[@class='ride-time']/a")).click();
//	6) Click on Date 21 (twice)
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[contains(text(),'22')])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[contains(text(),'22')])[1]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[contains(text(),'22')])[2]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("(//td[contains(text(),'22')])[2]")).click();
//	7) Click Continue
	driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
//	8) Click Find Cars
	driver.findElement(By.xpath("//button[contains(text(),'Find cars')]")).click();
//	9) Find the price of maruti swift dzire 
    WebElement findMarutiPrice = driver.findElement(By.xpath("(//h3[contains(text(),'Maruti Swift Dzire')]/following :: div[@class='price-book-ctr']//div)[2]"));
	String sTrfindMarutiPrice=findMarutiPrice.getText();	
	System.out.println(sTrfindMarutiPrice);

	}

}
