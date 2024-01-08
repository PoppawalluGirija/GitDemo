import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LogIn {

	public static void main(String[] args) throws InterruptedException {
		

		WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(3000) ;
        driver.manage().window().maximize();
        WebElement Home = driver.findElement(By.cssSelector(".btn.btn-primary"));
        Home.click();
	    Thread.sleep(3000);
	    driver.navigate().back();
	    //driver.navigate().forward();
	   // driver.navigate().refresh();
	   // driver.navigate().to("https://www.amazon.ca/");
	    WebElement enter_name = driver.findElement(By.name("enter-name"));
	    enter_name.click();
	    enter_name.sendKeys("Girija");
	    WebElement radio_button = driver.findElement(By.xpath("//input[@value='radio2']"));
	    radio_button.click();
	   Select dropDown = new Select(driver.findElement(By.id("dropdown-class-example")));
	   dropDown.selectByIndex(1);
	   Thread.sleep(3000);
	   dropDown.selectByValue("option2");
	   Thread.sleep(3000);
	   dropDown.selectByVisibleText("Option3");
	   Thread.sleep(3000);
	   WebElement checkBox = driver.findElement(By.name("checkBoxOption1"));
	   checkBox.click();
	   Thread.sleep(3000);
	   WebElement getIndex = driver.findElement(By.xpath("//div[@id=Radio Button Example']//legend"));
	   String radioExample = getIndex.getText();
	   System.out.println(radioExample);
	   Thread.sleep(3000);
       WebElement alterButton = driver.findElement(By.id("alterbtn"));
       alterButton.click();
       Thread.sleep(3000);

       driver.switchTo().alert().accept();
       WebElement confirmButton = driver.findElement(By.id("confirmation"));
       confirmButton.click();
       Thread.sleep(3000);
 driver.switchTo().alert().dismiss();

	   
	   
	   driver.quit();
	 
	}

}
