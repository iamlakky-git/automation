package FirstTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Demo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
//        driver.findElement(By.id("email")).sendKeys("9866066718");
//        Thread.sleep(3000);
//        driver.findElement(By.name("pass")).sendKeys("password");
//        Thread.sleep(2000);
//        driver.findElement(By.name("login")).click();
        WebElement createAccountLink = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        createAccountLink.click();
        Thread.sleep(2000);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.name("firstname")).sendKeys("laxman");

        driver.findElement(By.name("lastname")).sendKeys("Gole");
        driver.findElement(By.name("reg_email__")).sendKeys("facebook123@gmail.com");
        driver.findElement(By.name("reg_passwd__")).sendKeys("facebook");

        WebElement element = driver.findElement(By.xpath("//select[@id='day']"));
        Select select = new Select(element);
        select.selectByIndex(1);







//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));

//
//        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname")));
//        firstNameInput.sendKeys("YourFirstName");
//        Thread.sleep(5000);

      //  driver.quit();





    }
    }



//
//    }
//
//}
