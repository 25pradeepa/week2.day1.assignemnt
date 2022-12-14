package week2.classautomate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("http://leaftaps.com/opentaps/control/main");
driver.manage().window().maximize();
driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
driver.findElement(By.id("password")).sendKeys("crmsfa");
driver.findElement(By.className("decorativeSubmit")).click();
driver.findElement(By.linkText("CRM/SFA")).click();
driver.findElement(By.linkText("Leads")).click();
driver.findElement(By.linkText("Create Lead")).click();
driver.findElement(By.id("createLeadForm_companyName")).sendKeys("HCL1");
driver.findElement(By.id("createLeadForm_firstName")).sendKeys("test");
driver.findElement(By.id("createLeadForm_lastName")).sendKeys("q");
driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("test");
driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("testing");
driver.findElement(By.id("createLeadForm_description")).sendKeys("testing automation demo");
driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("pradeepa_muthukumar@yahoo.in");
WebElement ele1 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
Select dd1 = new Select(ele1);
dd1.selectByValue("NY");

//WebElement ele2= driver.findElement(By.id("createLeadForm_dataSourceId"));
//Select dd = new Select(ele2);
//dd.selectByValue("LEAD_CONFERENCE");

driver.findElement(By.name("submitButton")).click();
String title = driver.getTitle();
System.out.println("Title is " + title);
Thread.sleep(10000);

String actualtitle = "View Lead | opentaps CRM";
if (title.equals(actualtitle))
{
	System.out.println("Lead creation is successful");
}
else
{
	System.out.println("Lead creation is not successful");
}
driver.close();



	}

}
