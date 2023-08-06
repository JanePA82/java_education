package ru.stda.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size()==0) {
            app.contact().create(new ContactData(
                    "Контакт", "Контактович", "Законтачен", "cont",
                    "Умник", "Bee", "NY", "11111", "22222", "33333", "44444",
                    "email", "email2", "email3", "adf.ru", "1", "August", "2000",
                    "1", "July", "1980", "111", "sdgsdg", "5555555", "hdf", null /*"https://w.forfun.com/fetch/35/3568329d72ef7092e7b421ab42961710.jpeg")*/
            ));
        }
    }
    @Test
    public void testContactDelete()  {
        List<ContactData> before = app.contact().list();
        app.contact().delete();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), (before.size() - 1));
    }


}
