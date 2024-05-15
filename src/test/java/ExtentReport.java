import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

    public static void main(String[] args) {
        ExtentReports extentReports= new ExtentReports();
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("C:\\Users\\Laxman Gole\\OneDrive\\Documents\\Report\\AutomationAagain\\Report\\report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
        extentReports.attachReporter(sparkReporter);
//        extentReports.createTest("Test1");
        ExtentTest test = extentReports.createTest("Test1");
        test.pass("The test is pass");


        test.log(Status.SKIP,"This test is skip");
        test.log(Status.FAIL,"This Test is fail");

        extentReports.flush();

    }


}
