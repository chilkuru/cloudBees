package cloudBees.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cloudBees.resources.Base;
import cloudBees.utilities.SeleniumUtilities;

public class CloudBeesCDROPage extends Base {

	public WebDriver driver;
	private SeleniumUtilities selUtil;
	
	private By costSavingsElement = By.xpath("//p[text()='Cost Savings']/following::span[1]");
	private By auditorsSecurity = By.xpath("//span[text() = 'Auditors / Security']");
	private By releaseGoverananceText = By.xpath("//p[text() = 'Release Governance']/./following::h4[1]");



	public CloudBeesCDROPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		selUtil = new SeleniumUtilities(this.driver);

	}

	public void validateCostSavingsAndReleaseGovernance(String costSavings, String releaseGovernance) throws InterruptedException {
		selUtil.waitForPageLoad(driver);
		

		selUtil.scrolltoElement(driver.findElement(costSavingsElement));
		Assert.assertEquals(driver.findElement(costSavingsElement).getText(), costSavings);
		
		selUtil.scrolltoElement(driver.findElement(auditorsSecurity));
		selUtil.waitForElementTobeClickable(auditorsSecurity, 10, 500);
		selUtil.javaScriptExecutorClickAction(driver.findElement(auditorsSecurity));
		selUtil.waitForPageLoad(driver);
		
		
		
		selUtil.scrolltoElement(driver.findElement(releaseGoverananceText));
		Assert.assertEquals(driver.findElement(releaseGoverananceText).getText(), releaseGovernance);
		

	}
	
	


	public By getCostSavings() {
		return costSavingsElement;
	}

	public void setCostSavings(By costSavings) {
		this.costSavingsElement = costSavings;
	}

	public By getAudtorsSecurity() {
		return auditorsSecurity;
	}

	public void setAudtorsSecurity(By audtorsSecurity) {
		this.auditorsSecurity = audtorsSecurity;
	}






}
