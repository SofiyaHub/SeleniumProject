package com.epam.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomListener implements ITestListener {

    private static Logger logger=Logger.getLogger(CustomListener.class);
    private Date date=new Date();
    private DateFormat dateFormat=new SimpleDateFormat();

    public void onTestStart(ITestResult iTestResult) {
        logger.info("Method " +iTestResult.getMethod().getMethodName()+" starts in "+dateFormat.format(date));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        logger.info("Method "+iTestResult.getMethod().getMethodName()+"finished successefull");
    }

    public void onTestFailure(ITestResult iTestResult) {
        logger.info("Method "+iTestResult.getMethod().getMethodName()+" failed in"+dateFormat.format(date));
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
