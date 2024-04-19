package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageobjects.webcrse2;

public class TC2webcrse2  extends Baseclass {
	
	static webcrse2 obj1;

	@Test(priority=1,groups= {"sanity","regression"})
	public void course2() throws IOException, InterruptedException {
		logger.info("------clicking the 2nd webcourse--------");
		obj1= new webcrse2(driver);
		obj1.clkcourse2();
		logger.info("------prints the title of course2-------");
	}
    
	@Test(priority=2,groups= {"sanity","regression"})
	public void windowswitch() throws IOException {
		logger.info("------switching to the window-------");
		obj1= new webcrse2(driver);
		logger.info("------ windowswitch is done successful--------");
	}
}
