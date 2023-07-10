package ru.stda.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTests extends  TestBase{


  @Test
  public void testContactDelete() throws Exception {
    app.getContactHelper().gotoHomePage();
    app.getContactHelper().selectContact();
    app.getContactHelper().submitContactDelete();
    app.getContactHelper().gotoHomePage();
  }


}
