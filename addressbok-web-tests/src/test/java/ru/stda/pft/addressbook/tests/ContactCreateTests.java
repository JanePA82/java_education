package ru.stda.pft.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.hamcrest.CoreMatchers;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.ContactData;
import ru.stda.pft.addressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ContactCreateTests extends TestBase {

    //////////////////XML//////////////////
    @DataProvider
    public Iterator<Object[]> validGroupsXML() throws IOException {
        File file = new File("src/test/resources/contacts.xml");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{ContactData.class});
        xStream.processAnnotations(ContactData.class);
        List<ContactData> groups = (List <ContactData>) xStream.fromXML(xml);
        return groups.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    //////////////////JSON//////////////////
    @DataProvider
    public Iterator<Object[]> validGroupsJSON() throws IOException {
        File file = new File("src/test/resources/contacts.json");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<ContactData> groups = gson.fromJson (json, new TypeToken<List<ContactData>>(){}.getType());
        return groups.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
    @Test(dataProvider = "validGroupsJSON")
    public void testContactCreate(ContactData contact) throws Exception {
        app.goTo().homePage();
        Contacts before = (Contacts) app.contact().all();
        int id = app.contact().nextId();
        app.contact().clickAdd();
/*        String firstN = RandomStringUtils.randomAlphabetic(5);
        String middlN = RandomStringUtils.randomAlphabetic(5);
        String lastN = RandomStringUtils.randomAlphabetic(5);
        String nickN = RandomStringUtils.randomAlphabetic(3);
        File photo = new File("src/test/resources/photo.png");
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
                .withEmail3("adaf@fds")
                .withPhoto(photo);*/

        app.contact().create(contact);
        assertThat(app.contact().count(), CoreMatchers.equalTo(before.size() + 1));
        Contacts after = (Contacts) app.contact().all();

  /*    before.add(contact);
                сравнение элементов в множестве по ID
                contact.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
                Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
                сравнение элементов в упорядоченном сортировкой множестве по ID
                Comparator<? super ContactData> byId= Comparator.comparingInt(ContactData::getId);
                before.sort(byId);
                after.sort(byId);
                System.out.println(before);System.out.println(after);*/
        assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

/*    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/photo.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());

    }
*/
}
