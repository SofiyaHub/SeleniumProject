package com.epam.bissnesObj;

import com.epam.model.Message;
import com.epam.model.User;
import com.epam.pageObj.GmailPage;
import com.epam.pageObj.LoginPage;
import com.epam.utils.Driver;

public class GmailBO {
    GmailPage gmailPage = new GmailPage();

    public void writeLetterAndClose(Message message) {
        gmailPage.openComposeButton();
        gmailPage.fillFieldsMessage(message.getTo(), message.getSubject(), message.getMessage());
        gmailPage.closeLetter();
    }

    public String sendMessageFromDraftFolder() {
        gmailPage.openDraftsFolder();
        gmailPage.openLetterFromDrafts();
        String messageFromDrafts = gmailPage.takeMessageFromField();
        gmailPage.sendMessage();
        return messageFromDrafts;
    }

}
