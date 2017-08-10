package com.epam.webFields;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Button extends AbstractElement {
    public Button(WebElement webElement) {
        super(webElement);
    }

    public void clickOnButton(){
        webElement.click();
    }

    public void actionClick(){

    }

}
