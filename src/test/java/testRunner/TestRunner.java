package testRunner;

//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
					features= {".//features/"},
					//features= {".//Features/Login.feature"},
					//features= {".//Features/LoginDDTExcel.feature"},
					//features= {".//Features/Login.feature",".//Features/Registration.feature"},
					//features= {"@target/rerun.txt"},
					glue="StepDefenition",
					plugin= {"pretty", "html:reports/myreport.html", 
							  "rerun:target/rerun.txt",
							  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							},
							
					dryRun=false,    // checks mapping between scenario steps and step definition methods
					monochrome=true,    // to avoid junk characters in output
					publish=true ,  // to publish report in cucumber server
					//tags="@smoke"  // this will execute scenarios tagged with @sanity
					//tags="@regression"
					//tags="@smoke and @regression" //Scenarios tagged with both @sanity and @regression
					//tags="@smoke and not @regression" //Scenarios tagged with @sanity but not tagged with @regression
					//tags="@smoke or @regression" //Scenarios tagged with either @sanity or @regression
					tags="not @smoke and not @regression"
		)
public class TestRunner extends AbstractTestNGCucumberTests{

		}
