package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageobjects.webcrse1;


public class TC1webdevcourses extends Baseclass  {
	static webcrse1 obj;
	
	@Test(priority=1,groups= {"sanity","regression"})
	public void homepage() {
		logger.info("------enters web courses  --------");
		obj = new webcrse1(driver);
		obj.enterSearchbox("Web development courses");
		logger.info("------shows web devolpment courses  --------");	
	}
	
	@Test(priority=2,groups= {"regression"})
	public void filter() throws InterruptedException {
		logger.info("------clicking the checkboxes--------");
		obj = new webcrse1(driver);
		obj.clkcheckbox();
		logger.info("------filtered courses is shown -------");
}
    @Test(priority=3,groups= {"sanity","regression"})
    public void courses() throws IOException, InterruptedException {
    	logger.info("------getting the title of webcourse 1--------");
    	obj = new webcrse1(driver);
    	obj.clkcourse1();
    	logger.info("------prints the info of webcourse1-------");
    }
    
}
