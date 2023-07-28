package ru.stda.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {


    @Test
    public void testContactModification() throws Exception {
        app.getContactHelper().gotoHomePage();
        if (app.getContactHelper().IsElementPresent(By.name("selected[]")) == false) {
            app.getContactHelper().gotoContactAdditionPage();
            app.getContactHelper().fillContactForm(new ContactData(
                    "Контакт", "Контактович", "Законтачен", "cont",
                    "Умник", "Bee", "NY", "11111", "22222", "33333", "44444",
                    "email", "email2", "email3", "adf.ru", "1", "August", "2000",
                    "1", "July", "1980", "111", "sdgsdg", "5555555", "hdf", null /*"https://w.forfun.com/fetch/35/3568329d72ef7092e7b421ab42961710.jpeg")*/
            ));
            app.getContactHelper().submitContactCreation();
            app.getContactHelper().gotoHomePage();
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().editContactModification();
        ContactData contact = new ContactData(before.get(0).getId(), "ReКонтакт", "ReКонтактович", "ReЗаконтачен", "cont",
                "Умник", "Bee", "ReNY", "11111", "22222", "33333", "44444",
                "Reemail", "Reemail2", "Reemail3", "Readf.ru", "1", "June", "1980",
                "1", "July", "1980", null, "sdgsdg", "5555555", "hdf", null /*"https://w.forfun.com/fetch/35/3568329d72ef7092e7b421ab42961710.jpeg")*/
        );
        app.getContactHelper().fillContactForm(contact);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(0);
        before.add(contact);
        Comparator<? super ContactData> byId = Comparator.comparingInt(ContactData::getId);
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);
    }}
