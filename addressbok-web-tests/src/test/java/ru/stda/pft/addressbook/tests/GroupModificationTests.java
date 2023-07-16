package ru.stda.pft.addressbook.tests;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {

        app.getNavigationHelper().gotoGroupPage();
        if (app.getContactHelper().IsElementPresent(By.name("selected[]"))) {
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("retest", "retest1", "retest2"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().retuneToGroupPage();}
        else {
            app.getNavigationHelper().gotoGroupPage();
            app.getGroupHelper().initGroupCretion();
            app.getGroupHelper().fillGroupForm(new GroupData("111", null, null));
            app.getGroupHelper().submitGroupCreation();
            app.getGroupHelper().retuneToGroupPage();
            app.getGroupHelper().selectGroup();
            app.getGroupHelper().initGroupModification();
            app.getGroupHelper().fillGroupForm(new GroupData("retest", "retest1", "retest2"));
            app.getGroupHelper().submitGroupModification();
            app.getGroupHelper().retuneToGroupPage();
    }
}}
