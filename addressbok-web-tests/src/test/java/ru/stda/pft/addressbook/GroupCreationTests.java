package ru.stda.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends  TestBase {

  @Test
  public void testGroupCreation() throws Exception {

    gotoGroupPage();
    initGroupCretion();
    fillGroupForm(new GroupData("test", "test1", "test2"));
    submitGroupCreation();
    retuneToGroupPage();

  }


}
