package pageobjects;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Utilities.ExcelUtils;

//import Utilities.excelUtils;

public class languagelearn extends Basepage{
	
	public JavascriptExecutor js= (JavascriptExecutor)driver;
	
	public languagelearn(WebDriver driver) {
		super(driver);
		
	}
	
	List<String> data3 = new ArrayList<String>();
	
	@FindBy(xpath="//input[@placeholder='What do you want to learn?']")
	WebElement searchbox1;
	
	@FindBy(xpath="//button[@aria-label='Show more Language options']")
	WebElement langshow;
	
	@FindBy(xpath="//div[@class='css-zweepb']//div/span/span")
	List<WebElement>  languages;
	
	@FindBy(xpath="//div[@class='css-1lqbpgq']//button")
	WebElement closepopup;
	
	@FindBy (xpath="//*[text()='Level']") 
	WebElement scrll3;
	
	@FindBy (xpath="//div[@data-testid='search-filter-group-Level']//div[@class='cds-checkboxAndRadio-labelText']/span/span")
	List<WebElement> lvl;
	
	public void entersearchbox2(String txt1 ) throws InterruptedException {
		searchbox1.sendKeys(Keys.CLEAR);
		Thread.sleep(3000);
		searchbox1.sendKeys(txt1);
		searchbox1.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
	}
	
	public void showlanguages() throws IOException, InterruptedException {
		
		
		js.executeScript("arguments[0].scrollIntoView",langshow);
		js.executeScript("arguments[0].click()",langshow);
//		langshow.click();
//		List<String> data3 = new ArrayList<String>();
		for(WebElement lang :languages) {
			String str = lang.getText();
			Thread.sleep(2000);
			
			data3.add(str);
	
			System.out.println(str);	
		}
		ExcelUtils.writeData("LanguageLearning",data3,0,0);
		Thread.sleep(2000);
		System.out.println("total languages: "+languages.size());
		
		js.executeScript("arguments[0].click()",closepopup);
		//closepopup.click();		
}
	public void levels() throws InterruptedException {
		
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView",scrll3);
		Thread.sleep(4000);
		System.out.println("total count of levels:");
//	    Thread.sleep(4000);
	    for(WebElement level : lvl) {
	    	System.out.println(level.getText());
	    }
	      System.out.println("total count of level: "+lvl.size());
	}
	

}
