package ru.stda.pft.addressbook.tests;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;
import ru.stda.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupDeleteTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size()==0) {
            app.group().create(new GroupData().withName("111"));
        }
    }
    @Test
    public void testDeleteGroupTests() {
        Groups before = app.group().all();
        GroupData deletedGroup = before.iterator().next();
        app.group().delete(deletedGroup);
        assertThat(app.group().count(), Matchers.equalTo(before.size()-1));
        Groups after = app.group().all();
/*        before.remove(deletedGroup);
        Assert.assertEquals(before, after);*/
        assertThat(after, equalTo(before.without(deletedGroup)));

    }


}
