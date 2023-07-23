package ru.stda.pft.addressbook.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation() throws Exception {
        app.getNavigationHelper().gotoGroupPage();
        List<GroupData> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().initGroupCretion();
        String nameGR = RandomStringUtils.randomAlphabetic(5);
        GroupData group = new GroupData(nameGR, null, null);
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupCreation();
        app.getGroupHelper().retuneToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.setId(after.stream().max(Comparator.comparingInt(GroupData::getId)).get().getId());
        before.add(group);
        Comparator<? super GroupData> byId= (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }


}
