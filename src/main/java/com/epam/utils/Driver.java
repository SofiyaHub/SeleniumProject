package com.epam.utils;

import com.epam.ProjectProperty;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver = null;

    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<WebDriver>();
    static ProjectProperty property;

/*
    static {
        System.setProperty(property.getKey(), property.getValue());
    }*/

    public static WebDriver getDriver() {
        System.out.println(Thread.currentThread().getId()+" get driver");
        if (drivers.get() == null) {
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            drivers.set(driver);
        }
        return drivers.get();
    }

    public static void setImplicitlyWait(long time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void openUrl(String url) {
        getDriver().get(url);
    }

    public static void closeBrowser() {
        if (drivers.get() != null) {
            drivers.get().quit();
            drivers.remove();
        }
    }
}
