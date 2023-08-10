package ru.stda.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPropertiesTest extends TestBase {
    @Test
    public void testContactProperties()

    {
        app.goTo().homePage();
        ContactData contact =  app.contact().all().iterator().next();
        ContactData contactInfoFromEditorForm  =  app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditorForm)));
        assertThat(contact.getAllEmails(), equalTo(mergeEmail(contactInfoFromEditorForm)));
        assertThat(contact.getAddress(), equalTo(contactInfoFromEditorForm.getAddress()));
    }

    public  String mergePhones(ContactData contact) {
       return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s)->!s.equals(""))
                .map(ContactPropertiesTest::cleanedPhone)
                .collect(Collectors.joining("\n"));
    }

    public static String cleanedPhone(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

    public  String mergeEmail(ContactData contact) {
        return Arrays.asList(contact.getEmail(),contact.getEmail2(), contact.getEmail3())
                .stream().filter((s)->!s.equals(""))
                .collect(Collectors.joining("\n"));
    }
}