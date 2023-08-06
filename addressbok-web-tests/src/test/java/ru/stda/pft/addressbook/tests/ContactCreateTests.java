package ru.stda.pft.addressbook.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreateTests extends  TestBase{
  @Test
  public void testContactCreate() throws Exception {
    app.goTo().homePage();
    List<ContactData> before = app.contact().list();
    int id = app.contact().nextId();
    app.contact().clickAdd();
    String firstN = RandomStringUtils.randomAlphabetic(5);
//    String middlN = RandomStringUtils.randomAlphabetic(5);
    String lastN = RandomStringUtils.randomAlphabetic(5);
//    String nickN = RandomStringUtils.randomAlphabetic(3);
    ContactData contact = new ContactData()
            .withId(id)
            .withLastname(lastN)
            .withFirstname(firstN)
            .withAddress("Старые Петушки")
            .withMobilePhone("+77777")
            .withWorkPhone("(555)555")
            .withHomePhone("78 78 78")
            .withEmail("ddfa@ddf")
            .withEmail2("adf@df")
            .withEmail3("adaf@fds");
        app.contact().create(contact);
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size()+1 );
    before.add(contact);

// сравнение элементов в множестве по ID
/*    contact.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));*/

// сравнение элементов в упорядоченном сортировкой множестве по ID
    Comparator<? super ContactData> byId= Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
