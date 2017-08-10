package com.epam.webFields;

import org.openqa.selenium.WebElement;

public class Label extends AbstractElement{
    public Label(WebElement webElement) {
        super(webElement);
    }

    public String getText(){
        return webElement.getText();
    }
    public void click(){
        webElement.click();
    }
}
