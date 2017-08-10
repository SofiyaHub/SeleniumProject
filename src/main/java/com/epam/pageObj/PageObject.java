package com.epam.pageObj;

import com.epam.decorator.CustomFieldDecorator;
import com.epam.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    protected WebDriver driver;

    public PageObject() {
        this.driver = Driver.getDriver();
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
    }

    public void setWaitDriverByName(long time, String element) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(By.name(element)));
    }

    public void setWaitDriverByXpath(long time, String element) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
    }

    public void setWaitDriverByCssSelector(long time, String element) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(element)));
    }
}
