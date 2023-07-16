package ru.stda.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;

public class DeleteGroupTests extends TestBase {


    @Test
    public void testDeleteGroupTests() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        if (app.getContactHelper().IsElementPresent(By.name("selected[]"))) {
            app.getGroupHelper().selectGroup();
            app.getGroupHelper().deleteSelectionGroup();
            app.getGroupHelper().retuneToGroupPage();
        } else {
            app.getNavigationHelper().gotoGroupPage();
            app.getGroupHelper().initGroupCretion();
            app.getGroupHelper().fillGroupForm(new GroupData("111", null, null));
            app.getGroupHelper().submitGroupCreation();
            app.getGroupHelper().retuneToGroupPage();
            app.getGroupHelper().selectGroup();
            app.getGroupHelper().deleteSelectionGroup();
            app.getGroupHelper().retuneToGroupPage();
        }
    }

}
