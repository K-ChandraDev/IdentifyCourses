package StepDefenition;

import java.io.IOException;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.languagelearn;
import pageobjects.webcrse2;

public class languagecourses {
	webcrse2 crse2;
	languagelearn lan;
	
	@Given("the user is on the homepage")
	public void  the_user_is_on_the_homepage() {
		crse2 = new webcrse2(BaseClass.getDriver());
	}
	
	@When("the user searches for language learning courses")
	public void  the_user_searches_for_language_learning_courses() throws InterruptedException   {
		lan = new languagelearn(BaseClass.getDriver());
		lan.entersearchbox2("language learning");
	}
	
	@When("they extract all available languages and their total counts")
	public void  they_extract_all_available_languages_and_their_total_counts() throws IOException, InterruptedException   {
		lan.showlanguages();
	}
	
	@When("they extract all different levels and their total counts")
	public void they_extract_all_different_levels_and_their_total_counts() throws IOException, InterruptedException {
		lan.levels();
	}

}
