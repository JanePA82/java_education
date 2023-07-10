package ru.stda.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactDataModify;

public class ContactModificationTests extends  TestBase{


  @Test
  public void testContactModification() throws Exception {
    app.getContactHelper().gotoHomePage();
//    app.getContactHelper().selectContact();
    app.getContactHelper().editContactModification();
    app.getContactHelper().fillContactFormModify (new ContactDataModify(
            "ReКонтакт", "ReКонтактович", "ReЗаконтачен", "cont",
            "Умник","Bee", "ReNY","11111", "22222", "33333", "44444",
            "Reemail", "Reemail2", "Reemail3", "Readf.ru","1","June","1980",
            "1","July","1980", "sdgsdg", "5555555","hdf", null /*"https://w.forfun.com/fetch/35/3568329d72ef7092e7b421ab42961710.jpeg")*/
    ));


    app.getContactHelper().submitContactModification();
    app.getContactHelper().gotoHomePage();

  }


}
