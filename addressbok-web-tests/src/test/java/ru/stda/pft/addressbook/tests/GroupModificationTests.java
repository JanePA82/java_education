package ru.stda.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {
    @Test
    public void testGroupModification() {
        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("retest", "retest1", "retest2"));

        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().retuneToGroupPage();
    }
}
