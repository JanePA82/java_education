package ru.stda.pft.addressbook.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;
import ru.stda.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreateTests extends  TestBase{


  @Test
  public void testContactCreate() throws Exception {
    List<GroupData> before = app.getGroupHelper().getGroupList();

    app.getContactHelper().gotoContactAdditionPage();

    String firstN = RandomStringUtils.randomAlphabetic(5);

    String middlN = RandomStringUtils.randomAlphabetic(5);
    String lastN = RandomStringUtils.randomAlphabetic(5);
    String nickN = RandomStringUtils.randomAlphabetic(3);
    app.getContactHelper().fillContactForm(new ContactData(firstN, middlN, lastN, nickN,
            "Умник","Bee", "NY","11111", "22222", "33333", "44444",
            "email", "email2", "email3", "adf.ru","1","August","2000",
            "1","July","1980", "111", "sdgsdg", "5555555","hdf", null)
    );
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().gotoHomePage();

  }


}
