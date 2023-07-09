package ru.stda.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;

public class GroupCreationTests extends  TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    app.gotoGroupPage();
    app.getGroupHelper().initGroupCretion();
    app.getGroupHelper().fillGroupForm(new GroupData("test", "test1", "test2"));
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().retuneToGroupPage();

  }


}