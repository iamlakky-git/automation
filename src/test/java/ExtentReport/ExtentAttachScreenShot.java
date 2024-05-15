package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ExtentAttachScreenShot {

    static WebDriver driver;

    public static  String captureScreenShot(String filnename){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./ScreenShots/"+filnename);
        try{
            FileUtils.copyFile(sourceFile,destFile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Screenshot was taken successfully");
        return destFile.getAbsolutePath();
    }

    public  static String captureScreenSHot1(){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String base64Code = String.valueOf(takesScreenshot.getScreenshotAs(OutputType.BASE64));
        System.out.println("Screenshot  was taken without path");
        return base64Code;
    }

    public static void main(String[] args) {
        ExtentReports extentReports = new ExtentReports();
        File file = new File("report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.yatra.com/");
        driver.manage().window().maximize();

        String base64code = captureScreenSHot1();
        String pathScreenshot = captureScreenShot("yatra.png");

        extentReports
                .createTest("ScreenTest1","This screenshot was  attached in a test level")
                .info("This is an info message")
                .addScreenCaptureFromBase64String(base64code,"Yatra Home page");

        extentReports
                .createTest("This is test 1","This is a category level")
                    .assignAuthor("Laxman")
                          .assignDevice("Chrome 120")
                                .assignCategory("smoke Test ");

        extentReports
                .createTest("This is test 2 ","Category level of  testing")
                        .assignAuthor("Richa")
                                .assignCategory("Regression test");

        extentReports
                .createTest("ScreenTest 2","This screenshot was  attached in a test level")
                .info("This is an info message")
                .addScreenCaptureFromBase64String(base64code,"Yatra Home page");

        extentReports
                .createTest("ScreenTest 3","This is for attaching screenshot")
                .info("This is an info message")
                .addScreenCaptureFromBase64String(pathScreenshot);

        extentReports.flush();
        driver.quit();




    }

}
