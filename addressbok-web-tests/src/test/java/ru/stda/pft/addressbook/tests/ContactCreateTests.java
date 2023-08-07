package ru.stda.pft.addressbook.tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.Contacts;
import ru.stda.pft.addressbook.model.ContactData;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreateTests extends  TestBase{
  @Test
  public void testContactCreate() throws Exception {
    app.goTo().homePage();
    Contacts before = (Contacts) app.contact().all();

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
    assertThat(app.contact().count(), CoreMatchers.equalTo(before.size()+1));
    Contacts after = (Contacts) app.contact().all();

//    before.add(contact);

// сравнение элементов в множестве по ID
/*    contact.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));*/

// сравнение элементов в упорядоченном сортировкой множестве по ID
/*    Comparator<? super ContactData> byId= Comparator.comparingInt(ContactData::getId);
    before.sort(byId);
    after.sort(byId);*/
//    System.out.println(before);System.out.println(after);
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }
}
