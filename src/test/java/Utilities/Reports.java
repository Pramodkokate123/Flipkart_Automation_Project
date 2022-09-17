package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports
{

    public static ExtentSparkReporter reporter;
    public static ExtentReports extent;

    public Reports()
    {
        String path = System.getProperty("user.dir")+"\\pk_reports\\pk.html";

        reporter = new ExtentSparkReporter(path);
        reporter.config().setDocumentTitle("pk_document");
        reporter.config().setReportName("pk_report");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("tested_by","pk");

    }
}
