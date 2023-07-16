package ru.stda.pft.addressbook.tests;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stda.pft.addressbook.appmanager.ApplicationManager;

import static org.openqa.selenium.remote.Browser.CHROME;

public class TestBase {

    protected final  ApplicationManager app = new ApplicationManager(CHROME.browserName());

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }
    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();  }



    public ApplicationManager getApp() {
        return app;
    }




}
