package com.epam.webFields;

import org.openqa.selenium.WebElement;

public class Input extends AbstractElement {
    public Input(WebElement webElement) {
        super(webElement);
    }

    public String getText(){
        return webElement.getText();
    }

    public void fillField(String input){
        webElement.sendKeys(input);
    }

    public boolean clear(){
        webElement.clear();
        return (webElement.getText()=="");
    }
}
