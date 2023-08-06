package ru.stda.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size()==0) {
            app.contact().create(new ContactData()
                    .withLastname("Контакт")
                    .withFirstname("Законтачен")
                    .withAddress("Старые Петушки")
                    .withMobilePhone("+77777")
                    .withWorkPhone("(555)555")
                    .withHomePhone("78 78 78")
                    .withEmail("ddfa@ddf")
                    .withEmail2("adf@df")
                    .withEmail3("adaf@fds"));
        }
    }

    @Test
    public void testContactModification() {
        Set<ContactData> before = app.contact().all();
        ContactData modificationContact = before.iterator().next();

//        int index = before.size()-1;
        app.contact().edit(String.valueOf(modificationContact.getId()));

        ContactData contact = new ContactData()
                .withId(modificationContact.getId())
                .withLastname("ReКонтакт")
                .withFirstname("ReЗаконтачен")
                .withAddress("Новые Петушки")
                .withMobilePhone("+077777")
                .withWorkPhone("(0555)555")
                .withHomePhone("078 078 78")
                .withEmail("Reddfa@ddf")
                .withEmail2("Readf@df")
                .withEmail3("Readaf@fds")

 /*       , "cont",
                "Умник", "Bee", "ReNY", "11111", "22222", "33333", "44444",
                "Reemail", "Reemail2", "Reemail3", "Readf.ru", "1", "June", "1980",
                "1", "July", "1980", null, "sdgsdg", "5555555", "hdf", null *//*"https://w.forfun.com/fetch/35/3568329d72ef7092e7b421ab42961710.jpeg")*//*
        */;
        app.contact().filling(contact);
        app.contact().submitChange();
        app.goTo().homePage();
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modificationContact);
        before.add(contact);

/*        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);*/

        Assert.assertEquals(before, after);
    }
}
