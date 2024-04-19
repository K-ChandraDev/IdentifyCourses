package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageobjects.Enterprises;

public class TC4enterprises extends Baseclass {
	static Enterprises obj5;
	
	@Test(priority=1,groups= {"sanity"})
	public void forEnterprise() {
		obj5 = new Enterprises(driver);
           obj5.clkEnterprises();
           logger.info("----- forEnterprises method runs succesful------");
	}
	
	@Test(priority=2)
	public void submitForm() throws IOException {
		obj5 = new Enterprises(driver);
		obj5.filltheform();
		obj5.errormsg();
		logger.info("------error message is shown------");
	}

}
