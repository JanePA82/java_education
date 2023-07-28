package ru.stda.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTests extends TestBase {


    @Test
    public void testContactDelete() throws Exception {
        app.getContactHelper().gotoHomePage();
        if (app.getContactHelper().IsElementPresent(By.name("selected[]")) == false) {

            app.getContactHelper().gotoContactAdditionPage();
            app.getContactHelper().fillContactForm(new ContactData("Контакт", "Контактович", "Законтачен", "cont",
                    "Умник", "Bee", "NY", "11111", "22222", "33333", "44444",
                    "email", "email2", "email3", "adf.ru", "1", "August", "2000",
                    "1", "July", "1980", "111", "sdgsdg", "5555555", "hdf", null /*"https://w.forfun.com/fetch/35/3568329d72ef7092e7b421ab42961710.jpeg")*/
            ));
            app.getContactHelper().submitContactCreation();
            app.getContactHelper().gotoHomePage();
        }

        List<ContactData> before = app.getContactHelper().getContactList();
        app.getContactHelper().selectContact();
        app.getContactHelper().submitContactDelete();
        app.getContactHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), (before.size() - 1));
    }
}
