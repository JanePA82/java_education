package ru.stda.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (!app.contact().isThereAContact()) {
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
        List<ContactData> before = app.contact().list();
        int index = before.size()-1;
        app.contact().edit(String.valueOf(before.get(index).getId()));

        ContactData contact = new ContactData()
                .withId(before.get(index).getId())
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
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(contact);

        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }
}
