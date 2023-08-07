package ru.stda.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddresslTest extends TestBase {
    @Test
    public void testContactAddress()

    {
        app.goTo().homePage();
        ContactData contact =  app.contact().all().iterator().next();
        ContactData contactInfoFromEditorForm  =  app.contact().infoFromEditForm(contact);
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditorForm.getAddress()));
        System.out.println(contact.getAddress());
        System.out.println(contactInfoFromEditorForm.getAddress());
    }
}