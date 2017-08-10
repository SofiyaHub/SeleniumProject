package com.epam.tests;

import com.epam.ProjectProperty;
import com.epam.bissnesObj.GmailBO;
import com.epam.bissnesObj.LoginBO;
import com.epam.data.parsers.ParseXLSXFile;
import com.epam.listener.CustomListener;
import com.epam.model.Message;
import com.epam.model.User;
import com.epam.utils.Driver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.uncommons.reportng.HTMLReporter;

import java.util.List;

@Listeners({HTMLReporter.class, CustomListener.class})
public class TestWithXlSXData {

    ParseXLSXFile parser=new ParseXLSXFile();
    private ProjectProperty property = new ProjectProperty();
    String url= property.getUrl();
    Message message=new Message(property.getLogin(), property.getSubject(), property.getText());

    List<User> userList=parser.parseUsers("users.xlsx");
    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @BeforeMethod
    public void open(){
        Driver.openUrl(url);
    }

    /*@DataProvider(parallel = false)
    public Object[] login1() {
        Object[] testData;

        return testData=userList.toArray();
    }*/


    /*@Test(dataProvider = "login1")*/

    @Test
    public void saveLetterToDraftAndSendTest() {
        /*Driver.openUrl(url);*/
        LoginBO loginBO = new LoginBO();
        loginBO.loginToGmail(new User("sofiia.mailfortesting@gmail.com", "hellow1987"));

        GmailBO gmailBO = new GmailBO();
        gmailBO.writeLetterAndClose(message);
        String actual = gmailBO.sendMessageFromDraftFolder();
    /*    Driver.closeBrowser();*/
        Assert.assertTrue(actual.contains("test"));
    }

    @AfterMethod
    public void quit(){
        Driver.closeBrowser();
    }

}
