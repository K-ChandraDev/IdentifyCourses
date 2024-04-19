package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import TestBase.Baseclass;
import pageobjects.languagelearn;

public class TC3Languagelearn extends Baseclass {
	
	static languagelearn obj3;
	
	@Test(priority=1,groups= {"sanity"})
	public void searchbox() throws InterruptedException {
		logger.info("------enters language learning--------");
		obj3 = new languagelearn (driver);
		obj3.entersearchbox2("language learning");
		logger.info("------ shows the language learn courses--------");
	}
	@Test(priority=2)
	public void languagescourses() throws IOException, InterruptedException {
		logger.info("------opens the list --------");
		obj3 = new languagelearn (driver);
		obj3.showlanguages();
		logger.info("------counts the list of languages------");
	}
	
	@Test(priority=3)
	public void levelcount() throws InterruptedException {
		logger.info("------scrll till levels------");
		obj3 = new languagelearn(driver);
		obj3.levels();
		logger.info("------counts the level------");
	
	}
}
