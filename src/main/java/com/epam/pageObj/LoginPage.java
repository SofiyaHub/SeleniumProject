package com.epam.pageObj;

import com.epam.decorator.CustomFieldDecorator;
import com.epam.utils.Driver;
import com.epam.webFields.Button;
import com.epam.webFields.Input;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends PageObject{

    @FindBy(name="identifier")
    private Input loginName;

    @FindBy(name="password")
    private Input passwordField;

    @FindBy(id="identifierNext")
    private Button buttonLoginNext;

    @FindBy(id="passwordNext")
    private Button buttonPasswordNext;

    public LoginPage() {
        super();
    }

    public void typeLoginAndSubmit(String login){
        System.out.println(Thread.currentThread().getId() + " login" + login);
        loginName.fillField(login);
        buttonLoginNext.clickOnButton();
    }
    public void enterPasswordAndSubmit(String password){
        setWaitDriverByName(30, "password");
        passwordField.fillField(password);
        buttonPasswordNext.clickOnButton();
    }
}
