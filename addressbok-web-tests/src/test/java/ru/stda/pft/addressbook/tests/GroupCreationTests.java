package ru.stda.pft.addressbook.tests;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.json.TypeToken;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stda.pft.addressbook.model.GroupData;
import ru.stda.pft.addressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class GroupCreationTests extends TestBase {
    //////////////////CSV//////////////////
@DataProvider
    public Iterator<Object[]> validGroupsCSV() throws IOException {
        List<Object[]> list = new ArrayList<Object[]>();
        File file = new File("src/test/resources/groups.csv");
        BufferedReader reader =  new BufferedReader(new FileReader(file) );
        String line = reader.readLine();
        while (line!=null){
            String[] split = line.split(";");
            list.add(new Object[] {new GroupData().withName(split[0]).withHeader(split[1]).withFooter(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }
//////////////////XML//////////////////
    @DataProvider
    public Iterator<Object[]> validGroupsXML() throws IOException {
        File file = new File("src/test/resources/groups.xml");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        XStream xStream = new XStream();
        xStream.allowTypes(new Class[]{GroupData.class});
        xStream.processAnnotations(GroupData.class);
        List<GroupData> groups = (List <GroupData>) xStream.fromXML(xml);
        return groups.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    //////////////////JSON//////////////////
    @DataProvider
    public Iterator<Object[]> validGroupsJSON() throws IOException {
        File file = new File("src/test/resources/groups.json");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String json = "";
        String line = reader.readLine();
        while (line != null) {
            json += line;
            line = reader.readLine();
        }
        Gson gson = new Gson();
        List<GroupData> groups = gson.fromJson (json, new TypeToken<List<GroupData>>(){}.getType());
        return groups.stream().map((g)-> new Object[]{g}).collect(Collectors.toList()).iterator();
    }

    @Test(dataProvider = "validGroupsJSON")
    public void testGroupCreation(GroupData group) throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size() + 1));
        Groups after = app.group().all();
        assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }


    @Test
    public void testBadGroupCreation() throws Exception {
        app.goTo().groupPage();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("nameGR'");
        app.group().create(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.group().all();
        assertThat(after, equalTo(before));
    }

}
