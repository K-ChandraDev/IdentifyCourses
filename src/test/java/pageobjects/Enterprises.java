package pageobjects;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import Utilities.ExcelUtils;

public class Enterprises extends Basepage{
	public JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public Enterprises(WebDriver driver){
		super(driver) ;
	}

	@FindBy(xpath="//a[normalize-space()='For Enterprise']")
	WebElement enterprise;
	
	@FindBy(xpath="//a[normalize-space()='Solutions']")
	WebElement clksolutions;
	
	@FindBy(xpath="//p[text()='Coursera for Campus']")
	WebElement clkcourses;
	
	@FindBy(xpath="//h2[text()='Get in touch with our sales team']")
	WebElement scrll4;
	
	@FindBy(id="FirstName")
	WebElement firstName;
	
	@FindBy(name="LastName")
	WebElement lastName;
	
	@FindBy(id="Email") WebElement email;
	
	@FindBy(name="Phone") WebElement phone;
	
	@FindBy(id="Institution_Type__c") WebElement instution;
	
	@FindBy(name="Company") WebElement instutionName;
	
	@FindBy(name="Title") WebElement job;
	
	@FindBy(name="Department") WebElement  dept;
	
	@FindBy(id="What_the_lead_asked_for_on_the_website__c") WebElement describe;
	
	@FindBy(name="Country") WebElement country;
	
	@FindBy(name="State") WebElement state;
	
	@FindBy(xpath="//button[@class='mktoButton']") 
	WebElement submit;
	
	@FindBy(xpath="//div[@class='mktoError']")
	WebElement errormsg;
	
	public void clkEnterprises() {
		driver.navigate().to("https://www.coursera.org/");
		js.executeScript("arguments[0].scrollintoView", enterprise);
		js.executeScript("arguments[0].click()", enterprise);
		js.executeScript("arguments[0].click()",clksolutions );
		js.executeScript("arguments[0].click()",clkcourses );
			
		js.executeScript("arguments[0].scrollIntoView",scrll4);
	}
	
	public void filltheform() throws IOException {
		
		String[] data=ExcelUtils.InputData();//Getting input values  
		firstName.sendKeys(data[0]);
		
		lastName.sendKeys(data[1]);
		
		email.sendKeys(data[2]);
		
		phone.sendKeys(data[3]);
		
		Select drpdwn=new Select(instution);
		 drpdwn.selectByValue(data[4]);
		
		 instutionName.sendKeys(data[5]);
		 
		 Select drpdwn2 =new Select(job);
		 drpdwn2.selectByValue(data[6]);
		 
		 Select drpdwn3=new Select(dept);
		 drpdwn3.selectByValue(data[7]);
		
		 Select drpdwn4=new Select(describe);
		 drpdwn4.selectByValue(data[8]);
		
		 Select drpdwn5=new Select(country);
		 drpdwn5.selectByValue(data[9]);
		 
		 Select drpdwn6=new Select(state);
		 drpdwn6.selectByValue(data[10]);
		

	}

	public void errormsg() {
		js.executeScript("arguments[0].click();",submit); 
		//submit.click();
		 System.out.println("Error Message: "+errormsg.getText());
	}
		
}
