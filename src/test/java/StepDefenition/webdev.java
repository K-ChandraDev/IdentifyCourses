package StepDefenition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

//import TestBase.Baseclass;
import factory.BaseClass;
import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.webcrse1;
import pageobjects.webcrse2;



public class webdev {
	
	static WebDriver driver;
	webcrse1 crse1;
	webcrse2 crse2;
	
	@Given("the user is on the homepage of the Coursera website")
	public void the_user_is_on_the_homepage_of_the_Coursera_website() {
		  driver = BaseClass.getDriver();
		  crse1 = new webcrse1(BaseClass.getDriver());
		  crse2 = new webcrse2(BaseClass.getDriver());

	}
	@When("the user searches for web development courses")
	public void the_user_searches_for_web_development_courses() {
		crse1.enterSearchbox("web development courses");
	}
	
	@When("the user clicks the first webcourse and get the details")
	public void the_user_clicks_the_first_webcourse_and_get_the_details() throws InterruptedException, IOException {
	    crse1.clkcheckbox();
	    crse1.clkcourse1();
	    
	}

	@When("the user clicks the second webcourse and get the details")
	public void the_user_clicks_the_second_webcourse_and_get_the_details() throws IOException, InterruptedException {
		crse2.clkcourse2();
		//crse2.switchwindow();
	}


	

}
