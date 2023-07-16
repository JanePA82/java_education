package ru.stda.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;

public class GroupCreationTests extends  TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().initGroupCretion();
    app.getGroupHelper().fillGroupForm(new GroupData("111", null, null));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().retuneToGroupPage();

  }


}
