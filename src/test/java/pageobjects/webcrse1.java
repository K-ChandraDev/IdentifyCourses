package pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;


public class webcrse1 extends Basepage {
	public JavascriptExecutor js= (JavascriptExecutor)driver;

	public webcrse1(WebDriver driver) {
		super(driver);
		
	}
	
	List<String> data = new ArrayList<String>();
	
	@FindBy(xpath="//input[@placeholder='What do you want to learn?']")
	WebElement searchbox;
	
	@FindBy(xpath="//*[text()='Language']")
	WebElement scrll;
	
	@FindBy(xpath="//div[@data-testid='search-filter-group-Language']//div[contains(@data-testid,'English')]//input[@type='checkbox']")
	WebElement clkeng ;
	
	@FindBy(xpath="//*[text()='Level']")
	WebElement scrll2;
	
	@FindBy(xpath="//div[contains(@data-testid,'Beginner')]//input[@type='checkbox']")
	WebElement beginner;
	
	@FindBy(xpath="//li[contains(@class,'cds-9')]//div[@class='css-1botxkk']")
	List<WebElement> crsesList;
	
	@FindBy(xpath="//h1[@data-e2e='hero-title']")
	WebElement crseHeading;
	
	@FindBy(xpath = "//div[@class='css-1mocuok']//div[@class='css-guxf6x']//div[contains(@class,'cds-121')]")
	WebElement crseRating;
	
	@FindBy(xpath="//div[@class='css-1mocuok']//div[@class='css-fw9ih3']/preceding-sibling::*[contains(text(),'hours')]")
	WebElement crseduration;
	
	
	public void enterSearchbox(String txt) {
		searchbox.sendKeys(txt);
		searchbox.sendKeys(Keys.ENTER);
	}
	
	public void clkcheckbox() throws InterruptedException {
		
	    js.executeScript("arguments[0].scrollIntoView",scrll);
		clkeng.click();
		js.executeScript("arguments[0].scrollIntoView",scrll2);
		beginner.click();
		 Thread.sleep(4000);

		
	}
	  
	public void clkcourse1() throws IOException, InterruptedException {
       	 //List<String> courseData = new ArrayList<String>();
       	 WebElement crse1=crsesList.get(0);
       	 crse1.click();
       	 Thread.sleep(4000);
       	 
       	 Set<String> windowid = driver.getWindowHandles();
		    List<String> windowsidList = new ArrayList<String>(windowid);
		    String parentid = windowsidList.get(0);
		    String childid = windowsidList.get(1);
		    driver.switchTo().window(childid);
       	 
		 System.out.println("courseName 1: "+crseHeading.getText());
		 data.add(crseHeading.getText());
		 ExcelUtils.writeData("WebCourses",data,0,0);
		 
		
		 System.out.println("courseRating1: "+crseRating.getText());
		 data.add(crseRating.getText());
		 ExcelUtils.writeData("WebCourses",data,1,0);
		
		 
		 System.out.println("course duration: "+crseduration.getText());
		 data.add(crseduration.getText());
		 ExcelUtils.writeData("WebCourses",data,2,0);
		   
		 driver.close();
		
		driver.switchTo().window(parentid);
		Thread.sleep(4000);
	}


}
