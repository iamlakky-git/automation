package Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;

public class handling_tabs {

     public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.yatra.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);

        String parentTab = driver.getWindowHandle();
        System.out.println("The id  of parent window =="+parentTab);
        driver.findElement(By.xpath("//span[normalize-space()='Visa']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        ArrayList<String> childtab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(childtab.get(1));
        Thread.sleep(3000);
        driver.close();
        driver.switchTo().window(childtab.get(0));



    }

    }






//    public void setup() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://www.yatra.com/");
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Thread.sleep(5000);
//    }
//
//    public  void go_to_visa_tab(){
//        driver.findElement(By.xpath("//span[contains(text(),'Visa')]")).click();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//    }
//
//    public void switch_to_tab() throws InterruptedException {
//        ((JavascriptExecutor)driver).executeAsyncScript("window.open");
//        ArrayList<String>tabs = new ArrayList<>(driver.getWindowHandles());
//        driver.switchTo().window((tabs.get(1)));
//        Thread.sleep(5000);
//
//        driver.switchTo().window(tabs.get(0));
//        Thread.sleep(3000);
//        driver.close();
//
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        new handling_tabs().setup();
//        new handling_tabs().go_to_visa_tab();
//        new handling_tabs().switch_to_tab();
//    }
//}
