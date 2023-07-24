package ru.stda.pft.addressbook.tests;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stda.pft.addressbook.appmanager.ApplicationManager;

import static org.openqa.selenium.remote.Browser.CHROME;

public class TestBase {

    protected static final  ApplicationManager app = new ApplicationManager(CHROME.browserName());

    @BeforeSuite(alwaysRun = true)
    public void setUp() throws Exception {
        app.init();
    }
    @AfterSuite(alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();  }



    public ApplicationManager getApp() {
        return app;
    }




}
