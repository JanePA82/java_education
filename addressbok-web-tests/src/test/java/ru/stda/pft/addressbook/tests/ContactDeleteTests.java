package ru.stda.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeleteTests extends TestBase {

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
    public void testContactDelete()  {
        Set<ContactData> before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), (before.size() - 1));
        before.remove(deletedContact);
        Assert.assertEquals(before, after);

    }


}
