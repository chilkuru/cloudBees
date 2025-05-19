package cloudBees.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cloudBees.resources.Base;
import cloudBees.utilities.SeleniumUtilities;

public class HomePage extends Base {

	public WebDriver driver;
	private SeleniumUtilities selUtil;
	
	private By products = By.xpath("//button[@data-toggle='collapse' and text()='Products']");
	private By cloudBeesCDRO = By.xpath("//a[text() = 'CloudBees CD/RO']");
	private By resources = By.xpath("//div[@data-test='navbar.menus']//button[text() = 'Resources']");
	private By documentation = By.xpath("//a[@aria-label='Documentation' and text() = 'Documentation']");



	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub

		this.driver = driver;
		selUtil = new SeleniumUtilities(this.driver);

	}

	public void openCloudBeesCDROPage() throws InterruptedException {
		selUtil.waitForPageLoad(driver);
		// Thread.sleep(5000);

		selUtil.waitForElementTobeClickable(products, 10, 500);
		selUtil.moveToElementAndClick(products);
		
		selUtil.waitForElementTobeClickable(cloudBeesCDRO, 10, 500);
		selUtil.moveToElementAndClick(cloudBeesCDRO);
	}
	
	public void openDocumentation() throws InterruptedException {
		selUtil.waitForPageLoad(driver);
	

		selUtil.waitForElementTobeClickable(resources, 10, 500);
		selUtil.moveToElementAndClick(resources);
		
		selUtil.waitForElementTobeClickable(documentation, 10, 500);
		selUtil.moveToElementAndClick(documentation);
		
		//Switch to new window which gets opened
		selUtil.switchtoNewWindowHandleOpened(driver.getWindowHandle());
	}
	
	
	public By getProducts() {
		return products;
	}

	public void setProducts(By products) {
		this.products = products;
	}

	public By getCloudBeesCDRO() {
		return cloudBeesCDRO;
	}

	public void setCloudBeesCDRO(By cloudBeesCDRO) {
		this.cloudBeesCDRO = cloudBeesCDRO;
	}


	public By getResources() {
		return resources;
	}

	public void setResources(By resources) {
		this.resources = resources;
	}

	public By getDocumentation() {
		return documentation;
	}

	public void setDocumentation(By documentation) {
		this.documentation = documentation;
	}



}
