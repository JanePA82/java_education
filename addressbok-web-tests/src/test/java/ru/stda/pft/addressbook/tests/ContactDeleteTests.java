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
    public void testContactDelete()  {
        List<ContactData> before = app.contact().list();
        app.contact().delete();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), (before.size() - 1));
    }


}
