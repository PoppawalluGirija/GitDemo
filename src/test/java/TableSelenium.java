import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableSelenium {

	private static final WebElement Tabledata = null;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
	Wait<WebDriver>fluentWait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait Wb = new WebDriverWait(driver,Duration.ofSeconds(10));
       
       
        WebElement Tabledata = driver.findElement(By.xpath("//table[@name='courses']//tr[6]//td[2]"));
        Wb.until(ExpectedConditions.visibilityOf(Tabledata));
	String Data=Tabledata.getText();
	System.out.println(Data);
	
	WebElement table = driver.findElement(By.name("courses"));
	List<WebElement> rows = table.findElements(By.tagName("tr"));
	
	
	for(WebElement row:rows) {
		List<WebElement> cells=row.findElements(By.tagName("td"));
		
	
	
	for(WebElement cell:cells) {
		System.out.print(cell.getText() + "\t");
	}
	System.out.println("");
	}
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("Window.scrollBy(0,1000)");
	Thread.sleep(3000);
	
	WebElement hover = driver.findElement(By.id("mousehover"));
	
	Actions actions = new Actions(driver);
	actions.moveToElement(hover).build().perform();
	Thread.sleep(5000);
	
	driver.switchTo().frame("courses-iframe");
	WebElement more = driver.findElement(By.xpath("//a[contains(text()), 'more')]"));
	more.click();
	Thread.sleep(3000);
	
	driver.switchTo().defaultContent();
	
	driver.quit();
	}

}
