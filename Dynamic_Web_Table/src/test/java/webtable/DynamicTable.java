package webtable;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DynamicTable {
	public WebDriver driver;
  @Test
  public void example() {
	  //column size
	  List<WebElement>cols=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/thead/tr/th"));
	  int col_size=cols.size();
	  System.out.println("Column size "+col_size);
	  
	  //row size
	  List<WebElement>rows=driver.findElements(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr"));
	  int rows_size=rows.size();
	  System.out.println("row size "+rows_size);
	  
	  //value of third and fourth column
	  WebElement d=driver.findElement(By.xpath("//*[@id=\"leftcontainer\"]/table/tbody/tr[3]/td[4]"));
	  System.out.println("value of  3rd row and 4th column "+d.getText());
	  
	  //print all values of web table
	  for(int i=0;i<rows_size;i++)
	  {
		  List<WebElement>currentrow=rows.get(i).findElements(By.tagName("td"));
		  for(int j=0;j<col_size;j++)
		  {
			  String readdata=currentrow.get(j).getText();
			  System.out.println("Value is "+readdata);
		  }
	  }
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\dell\\Desktop\\chromedriver latest\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.get("http://demo.guru99.com/test/web-table-element.php");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
