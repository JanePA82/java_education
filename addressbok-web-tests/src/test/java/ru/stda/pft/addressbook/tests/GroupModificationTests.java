package ru.stda.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size()==0) {
            app.group().create(new GroupData().withName("111"));
        }
    }

    @Test
    public void testGroupModification() {

        Set<GroupData> before = app.group().all();
        GroupData modificationGroup = before.iterator().next();
//        int index = before.size() - 1;
        GroupData group = new GroupData()
                .withId(modificationGroup.getId())
                .withName("retest")
                .withFooter("retest1")
                .withHeader("retest2");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modificationGroup);
        before.add(group);

        Assert.assertEquals(before, after);
    }
}