package pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import util.BrowserFactory;

public class ToDoListPage extends BasePage{

	WebDriver driver;
	String options;
	
	public ToDoListPage (WebDriver driver) {
		this.driver = driver;
	}	
	  
	    @FindBy(how= How.NAME,using="categorydata") WebElement CategoryElement;
	    @FindBy(how= How.CSS,using="input[value='Add category']") WebElement AddCategoryButtonElement;
	    @FindBy(how= How.XPATH,using="//span[contains(text( ), 'Sport')]") WebElement SportCategoryListElement;
	    @FindBy(how= How.XPATH,using="//body/a[1]") WebElement YesElement;
	    @FindBy(how= How.XPATH,using="//body/a[2]") WebElement NevermindElement;
//	    @FindBy(how= How.XPATH,using="//body/text()[1]") WebElement CategoryExistsMessageElement;
	    @FindBy(how= How.XPATH,using="//body") WebElement BodyElement;
	    @FindBy(how= How.XPATH,using="//select[@name='due_month']") WebElement DueMonthElement;
	    
	    public void insertSportCategory() {
	    	CategoryElement.sendKeys("Sport");
	    }
	    
	    public void clickAddCategoryButton() {
	    	AddCategoryButtonElement.click();
	    }
	    
	    public void validateInsertedSportCategory() {
//	    	if (FirstCategoryListElement.isDisplayed()) {
//	    		System.out.println("First category is displayed.");
//	    	}else {
//	    		System.out.println("First category is not displayed!");
//	    	}
	    	Assert.assertTrue(SportCategoryListElement.isDisplayed(), "Sport Catogory list is not displayed!!");
	    }
	    
	    public void deleteSportCategory() {
	    	SportCategoryListElement.click();
	    	YesElement.click();
	    }
	    
	    public void getCategoryAlreadyExistsMessage() {
           Assert.assertTrue(BodyElement.getText().contains("The category you want to add already exists:"));
           NevermindElement.click();
        }
	    
	    public void getAllOptionsFromMonthDropdown() {
	    	Select sel = new Select(DueMonthElement);
	
	    	options = "";
	    	 java.util.List<WebElement> op = sel.getOptions();
		      int size = op.size();
		      for(int i =0; i<size ; i++){
		         options = options+ " " + op.get(i).getText();
		         System.out.println(options);
		      }
	    	}
	    
	    public void validateMonthDropdownHasAllMonths() {
	    	Assert.assertTrue(options.contains("Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec" ));
	    	}
	    
	    
	    
	    
	    
	    
}