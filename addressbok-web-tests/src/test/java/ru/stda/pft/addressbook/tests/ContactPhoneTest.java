package ru.stda.pft.addressbook.tests;


import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase {
    @Test
    public void testContactPhones()

    {
        app.goTo().homePage();
        ContactData contact =  app.contact().all().iterator().next();
        ContactData contactInfoFromEditorForm  =  app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditorForm)));
/*        assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditorForm.getMobilePhone())));
        assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditorForm.getWorkPhone())));*/


    }

    public  String mergePhones(ContactData contact) {
       return Arrays.asList(contact.getHomePhone(),contact.getMobilePhone(), contact.getWorkPhone())
                .stream().filter((s)->!s.equals(""))
                .map(ContactPhoneTest::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone){
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}