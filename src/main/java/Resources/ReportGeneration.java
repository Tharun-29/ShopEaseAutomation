package Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGeneration {
  
	public static ExtentReports getReportObjects() {
		
		String path = System.getProperty("user.dir") + "//reports//report.html";
		
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Shop Ease Automated Test Report");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setEncoding("utf-8");
		reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		reporter.config().setCss(".badge-primary { background-color: #1a73e8; }");
		
		
		ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Tharun");
        extent.setSystemInfo("Environment", "QA");
        
        return extent;
		
	}
}
