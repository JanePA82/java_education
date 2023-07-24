package ru.stda.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class DeleteGroupTests extends TestBase {
    @Test
    public void testDeleteGroupTests() throws Exception {
        app.getNavigationHelper().gotoGroupPage();

        if (app.getContactHelper().IsElementPresent(By.name("selected[]"))) {
            List<GroupData> before = app.getGroupHelper().getGroupList();
            app.getGroupHelper().selectGroup(before.size() -1 );
            app.getGroupHelper().deleteSelectionGroup();
            app.getGroupHelper().retuneToGroupPage();
            List<GroupData> after = app.getGroupHelper().getGroupList();
            Assert.assertEquals(after.size(), before.size()-1);

            before.remove (before.size() -1);
            Comparator<? super GroupData> byId= Comparator.comparingInt(GroupData::getId);
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);
        } else {
            app.getNavigationHelper().gotoGroupPage();
            app.getGroupHelper().initGroupCretion();
            app.getGroupHelper().fillGroupForm(new GroupData("111", null, null));
            app.getGroupHelper().submitGroupCreation();
            app.getGroupHelper().retuneToGroupPage();
            app.getGroupHelper().selectGroup(0);
            app.getGroupHelper().deleteSelectionGroup();
            app.getGroupHelper().retuneToGroupPage();
            int after = app.getGroupHelper().getGroupCount();
            Assert.assertEquals(after, 0);
        }
    }
}
