package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.ToDoListPage;
import util.BrowserFactory;

public class CategoryTest {

	WebDriver driver;
	
	@Test(priority=1)
	public void validateUserAbleToAddCategoryAndIsDisplayed() {
		
		driver = BrowserFactory.inIt();
		ToDoListPage toDoListPageObj = PageFactory.initElements(driver, ToDoListPage.class);
		
		 toDoListPageObj.insertSportCategory();
		 toDoListPageObj.clickAddCategoryButton();
		 toDoListPageObj.validateInsertedSportCategory();
		 toDoListPageObj.deleteSportCategory();
		 BrowserFactory.tearDown();
	}

	@Test(priority=2)
	public void validateUserNotAbleToAddDuplicateCategory() {
		
		driver = BrowserFactory.inIt();
		ToDoListPage toDoListPageObj = PageFactory.initElements(driver, ToDoListPage.class);
		
		toDoListPageObj.insertSportCategory();
		toDoListPageObj.clickAddCategoryButton();
        toDoListPageObj.insertSportCategory();
		toDoListPageObj.clickAddCategoryButton();
		toDoListPageObj.getCategoryAlreadyExistsMessage();
		toDoListPageObj.deleteSportCategory();
		BrowserFactory.tearDown();
	}
	
	@Test(priority=3)
	public void validateMonthDropdown() {
		
		driver = BrowserFactory.inIt();
		ToDoListPage toDoListPageObj = PageFactory.initElements(driver, ToDoListPage.class);
		toDoListPageObj.getAllOptionsFromMonthDropdown();
		toDoListPageObj.validateMonthDropdownHasAllMonths();
		BrowserFactory.tearDown();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
