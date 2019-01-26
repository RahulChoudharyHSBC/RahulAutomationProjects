package com.tester.rahul;

import java.awt.Robot;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



public class Codes {
	
	static WebDriver driver=new ChromeDriver();
	
		@BeforeClass
		public static void beforeclass() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rahul\\eclipse-workspace\\RahulAutomationProjects\\src\\com\\tester\\rahul\\chromedriver.exe");	
		
		driver.get("http://demo.guru99.com/test/table.html");
		driver.manage().window().maximize();
		Thread.sleep(6000);
	}
	
	
		
		
		@Test
		public void test() throws InterruptedException {		

			WebElement mytable = driver.findElement(By.xpath("/html/body/table/tbody"));
	    	//To locate rows of table. 
	    	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
	    	//To calculate no of rows In table.
	    	int rows_count = rows_table.size();
	    	//Loop will execute till the last row of table.
	    	for (int row = 0; row < rows_count; row++) {
	    	    //To locate columns(cells) of that specific row.
	    	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
	    	    //To calculate no of columns (cells). In that specific row.
	    	    int columns_count = Columns_row.size();
	    	    System.out.println("Number of cells In Row " + row + " are " + columns_count);
	    	    //Loop will execute till the last cell of that specific row.
	    	    for (int column = 0; column < columns_count; column++) {
	    	        // To retrieve text from that specific cell.
	    	    	Thread.sleep(2000);
	    	    	JavascriptExecutor js = (JavascriptExecutor) driver;
					 js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", Columns_row.get(column));
	    	    	
	    	        String celtext = Columns_row.get(column).getText();
	    	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
	    	    }
	    	    System.out.println("-------------------------------------------------- ");
	    	}
			
			
			
				 
			}
			
			
		
		
		@AfterClass
		public static void aftercalss() {
			driver.close();
		}
		
		

	//}

}
