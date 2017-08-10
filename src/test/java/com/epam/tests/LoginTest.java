package com.epam.tests;

import com.epam.ProjectProperty;
import com.epam.bissnesObj.GmailBO;
import com.epam.bissnesObj.LoginBO;
import com.epam.model.Message;
import com.epam.model.User;
import com.epam.utils.Driver;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.*;
import org.uncommons.reportng.HTMLReporter;

import java.io.IOException;

@Listeners(HTMLReporter.class)
public class LoginTest {

    public LoginTest() throws IOException {
    }

    private Message message = new Message("sofiya.sydorenko@gmail.com", "test", "test");
    private ProjectProperty projectProperty = new ProjectProperty();
    private User user2 = new User("h.bazyliak@gmail.com", "torgan555");
    private User user3=new User("vladarchenko@gmail.com", "sittermarchenko");
    private User user4=new User("sydorenko.testmail@gmail.com", "asdasd123a");
    private User user5=new User("foreverytesting@gmail.com", "123qwertyuiop");

    String url = "http://www.gm.com";

    static {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @DataProvider(parallel = true)
    public Object[][] login1() {
        return new Object[][]{
                {user3}
        };
    }


    @Test(dataProvider = "login1")
    public void saveLetterToDraftAndSendTest(User user) {
        Driver.openUrl(url);
        LoginBO loginBO = new LoginBO();
        loginBO.loginToGmail(user);

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
