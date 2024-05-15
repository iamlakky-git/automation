package FirstTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class learnAutomation {
     WebDriver driver;

     public void  openBrowser(){
         WebDriverManager.chromedriver().setup();
         driver = new ChromeDriver();
         driver.get("https://www.facebook.com");
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     }
     public void createAccount() throws InterruptedException {
         WebElement createAccountLink = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
         createAccountLink.click();
         Thread.sleep(2000);
      }

      public void register(){
          driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
          driver.findElement(By.name("firstname")).sendKeys("laxman");

          driver.findElement(By.name("lastname")).sendKeys("Gole");
          driver.findElement(By.name("reg_email__")).sendKeys("facebook123@gmail.com");
          driver.findElement(By.name("reg_passwd__")).sendKeys("facebook");
      }

      public void handlingDropDown(){
          WebElement element =driver.findElement(By.xpath("//select[@id='month']"));
          Select select = new Select(element);
          select.selectByIndex(5);
      }

    public static void main(String[] args) throws InterruptedException {
        learnAutomation  learnAutomation = new learnAutomation();
        learnAutomation.openBrowser();
        learnAutomation.createAccount();
        learnAutomation.register();
        learnAutomation.handlingDropDown();

    }
}
