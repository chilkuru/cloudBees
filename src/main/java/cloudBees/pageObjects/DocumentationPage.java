package cloudBees.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cloudBees.resources.Base;
import cloudBees.utilities.SeleniumUtilities;

public class DocumentationPage extends Base {

	public WebDriver driver;

	private SeleniumUtilities selUtil;
	

	private By searchCloudBees = By.xpath("//h1[text()='CloudBees Documentation']//following::input[@placeholder='Search all CloudBees Resources']");
	private By searchInputBox = By.xpath("//input[@placeholder='Search']");
	private By pagination = By.xpath("//nav[@aria-label='Search Page Navigation']");


	public DocumentationPage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		selUtil = new SeleniumUtilities(this.driver);

	}

	public void verifyPaginationExists (String searchString) throws InterruptedException {
		selUtil.waitForPageLoad(driver);


		selUtil.scrolltoElement(driver.findElement(searchCloudBees));
		driver.findElement(searchCloudBees).sendKeys(Keys.ENTER);
		selUtil.waitForPageLoad(driver);
		
		driver.findElement(searchInputBox).sendKeys(searchString);
		driver.findElement(searchInputBox).sendKeys(Keys.ENTER);
		selUtil.waitForPageLoad(driver);
		
		
		selUtil.waitForElementTobeClickable(pagination, 10, 500);
		selUtil.scrolltoElement(driver.findElement(pagination));
		Assert.assertEquals(driver.findElement(pagination).isDisplayed(), true);
		
	}
	
	




	public By getSearchCloudBees() {
		return searchCloudBees;
	}

	public void setSearchCloudBees(By searchCloudBees) {
		this.searchCloudBees = searchCloudBees;
	}

	public By getSearchInputBox() {
		return searchInputBox;
	}

	public void setSearchInputBox(By searchInputBox) {
		this.searchInputBox = searchInputBox;
	}

	public By getPagination() {
		return pagination;
	}

	public void setPagination(By pagination) {
		this.pagination = pagination;
	}




}
