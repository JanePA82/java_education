package ru.stda.pft.addressbook.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
   //     int id = app.group().getIndexGroup();
        String nameGR = RandomStringUtils.randomAlphabetic(5);
        GroupData group = new GroupData().withName(nameGR);//.withId(id);
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt());
        before.add(group);
/*        Comparator<? super GroupData> byId= Comparator.comparingInt(GroupData::getId);
        before.sort(byId);
        after.sort(byId);*/
        Assert.assertEquals(before, after);


    }


}
