package cloudBees.tests;

import java.io.IOException;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import cloudBees.pageObjects.CloudBeesCDROPage;
import cloudBees.pageObjects.DocumentationPage;
import cloudBees.pageObjects.HomePage;
import cloudBees.resources.Base;



/**
 * @author Ragunath Chilkuru
 *
 */
public class TestCase1 extends Base {
	public WebDriver driver;
	private HomePage homePage;
	private CloudBeesCDROPage cloudBeesCDROPage;
	private DocumentationPage documentationPage;



	/**
	 * Initialize Driver and Page Objects
	 * 
	 * @throws IOException
	 */
	@BeforeMethod
	public void initialize() throws IOException {

		driver = initializeDriver();
		driver.get(getURL());
		homePage = new HomePage(driver);
	    cloudBeesCDROPage = new CloudBeesCDROPage(driver);
	    documentationPage = new DocumentationPage(driver);


	}

	
	/**
	 * Open the application
	 *  Click the link Products on top > Click CloudBees CD/RO under Other Products 
	 *  Verify that Cost Savings has a value of $2m 
	 *  Scroll down,click Auditors / Security 
	 *  Verify the text under Release Governance (Generate single-click audit reports) 
	 *  Click the link Resources on top > Click Documentation 
	 *  Verify that it opens a new tab 
	 *  Click in the text field Search all CloudBees Resources 
	 *  Verify that a new page is opened in this tab 
	 *  Search for the word "Installation" 
	 *  Verify that we have pagination options at bottom
	 */


	@Test

	public void testCloudBeesAssesment() throws IOException, InterruptedException {
		
		/*
		 * Open the application Click the link Products on top > Click CloudBees CD/RO
		 * under Other Products
		 */
		 
		homePage.openCloudBeesCDROPage();	
		
		
		/*
		 * Verify that Cost Savings has a value of $2m Scroll down,click Auditors /
		 * Security Verify the text under Release Governance (Generate single-click audit reports)
		 */
		 
		cloudBeesCDROPage.validateCostSavingsAndReleaseGovernance(getValueFromJSONFile("costSavings"),  getValueFromJSONFile("releaseGoveranceText"));
		
		/*
		 * Click the link Resources on top > Click Documentation 
		 * Verify that it opens a new tab 
		 * Click in the text field Search all CloudBees Resources 
		 * Verify that a new page is opened in this tab 
		 * Search for the word "Installation"
		 * Verify that we have pagination options at bottom
		 */
		homePage.openDocumentation();
		documentationPage.verifyPaginationExists(getValueFromJSONFile("searchString"));
		
	}

	@AfterMethod
	public void teardown() {

		driver.quit();

	}



}
