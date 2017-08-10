package com.epam.pageObj;

import com.epam.decorator.CustomFieldDecorator;
import com.epam.utils.Driver;
import com.epam.webFields.Button;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailPage extends PageObject{
    @FindBy(xpath = "//div[@class=\"z0\"]/div")
    private Button buttonWriteLetter;

    @FindBy(xpath = "//textarea[@name=\"to\"]")
    private WebElement to;

    @FindBy(name = "subjectbox")
    private WebElement subject;

    @FindBy(xpath = "//td[@class=\"Ap\"]/div[2]/div")
    private WebElement messageField;

    @FindBy(xpath = "//td[@class=\"Hm\"]/img[@class=\"Ha\"]")
    private WebElement close;

    @FindBy(xpath = "//div[@class=\"LrBjie\"]/div/div[4]")
    private WebElement draftsFolder;

    @FindBy(xpath = "//div[@class=\"BltHke nH oy8Mbf\"]//tr[1]/td[@class=\"yX xY \"]")
    private WebElement lastLetter;

    @FindBy(xpath = "//td[@class=\"gU Up\"]/div[1]/div[2] ")
    private WebElement buttonSend;

    public GmailPage() {
        super();
    }

    public void openComposeButton(){
        buttonWriteLetter.clickOnButton();
    }

    public void fillFieldsMessage(String to, String subject, String message){
        setWaitDriverByCssSelector(30, "div>h2.a3E");
        this.to.sendKeys(to);
        this.subject.sendKeys(subject);
        messageField.sendKeys(message);
    }

    public void closeLetter(){
        this.close.click();
    }

    public void openDraftsFolder(){
        this.draftsFolder.click();
    }

    public void openLetterFromDrafts(){
        lastLetter.click();
    }

    public void sendMessage(){
        this.buttonSend.click();
    }
    public String takeMessageFromField(){
        return messageField.getText();
    }
}