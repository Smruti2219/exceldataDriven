package smrutisamal.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import smrutisamal.AbsractClass.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	By productBy= By.cssSelector(".mb-3");
	By productSelect= By.cssSelector(".card-body button:last-of-type");
	By toastMessage= By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement invisibilityElement;
	
	public List<WebElement> getProductList() 
	{
		waitForElementToApprove(productBy);
		return products;
	}
	public WebElement getProductByName(String productName) {
		WebElement prod1 = getProductList() .stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod1;
		
	}
	public void addFirstProductToCart(String productName) {
		
		WebElement prod1 =getProductByName(productName);
		prod1.findElement(productSelect).click();
		waitForElementToApprove(toastMessage);
		waitforElementInvisibility(invisibilityElement);
	}

	public WebElement getSecondProduct(String productName2) {
		WebElement prod2= getProductList().stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName2)).findFirst().orElse(null);
		return prod2;
	}
	public void addSecondProductToCart(String productName2) {
		
		WebElement prod2 =getProductByName(productName2);
		prod2.findElement(productSelect).click();
		waitForElementToApprove(toastMessage);
		waitforElementInvisibility(invisibilityElement);
	}
	
	
}
