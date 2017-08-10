package com.epam.bissnesObj;

import com.epam.model.User;
import com.epam.pageObj.LoginPage;
import com.epam.utils.Driver;

public class LoginBO {
    LoginPage loginPage = new LoginPage();

    public void loginToGmail(User user) {
        System.out.println(Thread.currentThread().getId()+" user.getLogin"+user.getLogin());
        loginPage.typeLoginAndSubmit(user.getLogin());
        loginPage.enterPasswordAndSubmit(user.getPassword());
    }
}
