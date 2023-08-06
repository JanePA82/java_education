package ru.stda.pft.addressbook.tests;


import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;
import ru.stda.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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

        Groups before = app.group().all();
        GroupData modificationGroup = before.iterator().next();
//        int index = before.size() - 1;
        GroupData group = new GroupData()
                .withId(modificationGroup.getId())
                .withName("retest")
                .withFooter("retest1")
                .withHeader("retest2");
        app.group().modify(group);
        assertThat(app.group().count(), Matchers.equalTo(before.size()));
        Groups after = app.group().all();
/*        before.remove(modificationGroup);
        before.add(group);
        Assert.assertEquals(before, after);*/
        assertThat(after, equalTo(before.without(modificationGroup).withAdded(group)));
    }
}