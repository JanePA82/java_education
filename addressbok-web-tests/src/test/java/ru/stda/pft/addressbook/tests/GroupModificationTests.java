package ru.stda.pft.addressbook.tests;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {

        app.getNavigationHelper().gotoGroupPage();
        if (app.getContactHelper().IsElementPresent(By.name("selected[]"))) {
            List<GroupData> before = app.getGroupHelper().getGroupList();
            app.getGroupHelper().selectGroup(before.size() - 1);
            app.getGroupHelper().initGroupModification();
            GroupData group = new GroupData(before.get((before.size() - 1)).getId(),"retest", "retest1", "retest2");
            app.getGroupHelper().fillGroupForm(group);
            app.getGroupHelper().submitGroupModification();
            app.getGroupHelper().retuneToGroupPage();
            List<GroupData> after = app.getGroupHelper().getGroupList();
            Assert.assertEquals(after.size(), before.size());
            before.remove(before.size() - 1);
            before.add(group);

            Comparator<? super GroupData> byId= Comparator.comparingInt(GroupData::getId);
            before.sort(byId);
            after.sort(byId);
            Assert.assertEquals(before, after);

//            Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
        } else {
            app.getNavigationHelper().gotoGroupPage();
            app.getGroupHelper().initGroupCretion();
            app.getGroupHelper().fillGroupForm(new GroupData("111", null, null));
            app.getGroupHelper().submitGroupCreation();
            app.getGroupHelper().retuneToGroupPage();
            app.getGroupHelper().initGroupModification();
            app.getGroupHelper().fillGroupForm(new GroupData("retest", "retest1", "retest2"));
            app.getGroupHelper().submitGroupModification();
            app.getGroupHelper().retuneToGroupPage();
            int after = app.getGroupHelper().getGroupCount();
            Assert.assertEquals(after, 1);
        }
    }
}
