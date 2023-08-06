package ru.stda.pft.addressbook.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;
import ru.stda.pft.addressbook.model.Groups;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
   //     int id = app.group().getIndexGroup();
        String nameGR = RandomStringUtils.randomAlphabetic(5);
        GroupData group = new GroupData().withName(nameGR);//.withId(id);
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()+1));

        Groups after = app.group().all();
        assertEquals(after.size(), before.size() + 1);

//        group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
//        before.add(group);
/*        Comparator<? super GroupData> byId= Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);*/
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
   }


    @Test
    public void testBadGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("nameGR'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }

}
