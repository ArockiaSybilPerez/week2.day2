package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//1	Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		
		//2	Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager"); 
		
		//3	Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		//4	Click Login
		WebElement loginButton = driver.findElement(By.className("decorativeSubmit"));
		loginButton.click();
		//5	Click crm/sfa link
		WebElement crmsfaLink = driver.findElement(By.linkText("CRM/SFA"));
		crmsfaLink.click();
		//6	Click Leads link
		WebElement leadsLink = driver.findElement(By.linkText("Leads"));
		leadsLink.click();
		//7	Click Find leads
		WebElement findleadsLink = driver.findElement(By.linkText("Find Leads"));
		findleadsLink.click();
		//8	Enter first name
		//WebElement firstName = driver.findElement(By.name("firstName"));
		//firstName.sendKeys("Arockia");
		driver.findElement(By.xpath("//*[@id=\"ext-gen248\"]")).sendKeys("Arockia Sybil"); 
		//9	Click Find leads button
		//WebElement findleadsButton = driver.findElement(By.xpath("//*[@id=\"ext-gen334\"]"));
		//findleadsButton.click();
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		//10 Click on first resulting lead
		//WebElement findByName = driver.findElement(By.xpath("(//a[@href='/crmsfa/control/viewLead?partyId=11019'])[3]"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//a[@href='/crmsfa/control/viewLead?partyId=11019'])[3]")).click();
		//11 Verify title of the page
        String title = driver.getTitle();
		if (title.equals("View Lead | opentaps CRM")) {
			System.out.println("The view lead page is verified");
		}
		else {
			System.out.println("The view lead page is not verified");
		};
		//12 Click Edit
		driver.findElement(By.linkText("Edit")).click();
		//13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("SysARC Info");
		//14 Click Update
		WebElement updateButton = driver.findElement(By.name("submitButton"));
		updateButton.click();
		//15 Confirm the changed name appears
		String companyName = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (companyName.equals("SysARC Info (11019)")) {
			System.out.println("The company name is updated");
		}
		else {
			System.out.println("The company name is not updated");
		}
		//16 Close the browser (Do not log out)
		driver.quit();

	
	}

}
