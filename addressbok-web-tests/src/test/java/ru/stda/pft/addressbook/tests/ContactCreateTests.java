package ru.stda.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

public class ContactCreateTests extends  TestBase{


  @Test
  public void testContactCreate() throws Exception {

    app.getContactHelper().gotoContactAdditionPage();
    app.getContactHelper().fillContactForm(new ContactData(
            "Контакт", "Контактович", "Законтачен", "cont",
            "Умник","Bee", "NY","11111", "22222", "33333", "44444",
            "email", "email2", "email3", "adf.ru","1","August","2000",
            "1","July","1980", "111", "sdgsdg", "5555555","hdf", null /*"https://w.forfun.com/fetch/35/3568329d72ef7092e7b421ab42961710.jpeg")*/
    ));


    app.getContactHelper().submitContactCreation();
    app.getContactHelper().gotoHomePage();

  }


}
