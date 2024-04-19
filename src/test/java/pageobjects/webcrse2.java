package pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

//import Utilities.excelUtils;

public class webcrse2 extends Basepage{
	public JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public webcrse2(WebDriver driver){
		super(driver);
	}
	
	List<String> data1 = new ArrayList<String>();
	List<String> data2 = new ArrayList<String>();
	@FindBy(xpath="//li[contains(@class,'cds-9')]//div[@class='css-1botxkk']")
	List<WebElement> crseList;
	
	@FindBy(xpath="//h1[@data-e2e='hero-title']")
	WebElement crseHeading;
	
	@FindBy(xpath="//div[@class='css-1xbrjyc']//parent::div/div")
	WebElement crseRating;
	
	
	@FindBy(xpath ="(//div[contains(text(),'hours')])[1]")
	WebElement crseduration;
	
	@FindBy(xpath ="//div[@class='css-1mocuok']//div[@class='css-guxf6x']//div[contains(@class,'cds-121')]")
	WebElement crseRating2;
	
	@FindBy(xpath ="//div[@class='css-1mocuok']//div[@class='css-fw9ih3']/preceding-sibling::*[contains(text(),'hours')]")
	WebElement crseduration2;
	
	public void clkcourse2() throws IOException, InterruptedException {
		
//		List<String> data1 = new ArrayList<String>();
		WebElement crse2=crseList.get(1);
		crse2.click();
		
		Set<String> windowid1 = driver.getWindowHandles();
	    List<String> windowsidList1=  new ArrayList<String>(windowid1); 
	    String parentid = windowsidList1.get(0);
	    String childid2 = windowsidList1.get(1);
	    driver.switchTo().window(childid2);
	    
		 System.out.println("courseName 2: "+crseHeading.getText());
		 data1.add(crseHeading.getText());
		 ExcelUtils.writeData("WebCourses",data1,0,1);
		
		 try {
		 
		 System.out.println("courseRating2: "+crseRating2.getText());
		 data1.add(crseRating2.getText());
		 ExcelUtils.writeData("WebCourses",data1,1,1);
		 
		 System.out.println("course duration: "+crseduration2.getText());
		 data2.add(crseduration2.getText());
		 ExcelUtils.writeData("WebCourses",data2,2,1);
		 }
		 catch(Exception e) {}
		 
		 Thread.sleep(3000);
		    
		 try {
			 
			 System.out.println("courseRating2: "+crseRating.getText());
			 data1.add(crseRating2.getText());
			 ExcelUtils.writeData("WebCourses",data1,1,1);
			 
			 System.out.println("course duration: "+crseduration.getText());
			 data2.add(crseduration2.getText());
			 ExcelUtils.writeData("WebCourses",data2,2,1);
			 }
			 catch(Exception e) {}
		    

		driver.close();
		driver.switchTo().window(parentid);
    	    
		 
		//js.executeScript("arguments[0].click();",crse2);
		Thread.sleep(3000);
	}
   
}
