package utils;

import com.aventstack.extentreports.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.time.LocalDateTime;
import utils.DataDrivenLoginTest;

public class Listeners implements ITestListener {
	ExtentReports extent = ExtentManager.createInstance();
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getThrowable());
		String screenshotPath = takeScreenshot(result.getMethod().getMethodName());
		test.addScreenCaptureFromPath(screenshotPath);
	}
	public String takeScreenshot(String methodName) {
		String path = System.getProperty("user.dir") + "/screenshots/" + methodName + "_" + LocalDateTime.now() + ".png";
		File src = ((TakesScreenshot) DataDrivenLoginTest.driver.get()).getScreenshotAs(OutputType.FILE);
		try {
			Files.createDirectories(new File(System.getProperty("user.dir") + "/screenshot").toPath());
			Files.copy(src.toPath(), new File(path).toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
