package ru.stda.pft.addressbook.generators;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thoughtworks.xstream.XStream;
import ru.stda.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names = "-c", description = "Group count")
    public int count;
    @Parameter(names = "-f", description = "Target count")
    public String file;
    @Parameter(names = "-d", description = "Data format")
    public String format;


    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander = new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex) {
            jCommander.usage();
            return;
        }
        generator.run();

    }

    public void run() throws IOException {
        List<ContactData> groups = generateContacts(count);
        if (format.equals("csv")) {
            saveAsCSV(groups, new File(file));
        } else if (format.equals("xml")) {
            saveAsXML(groups, new File(file));
        } else if (format.equals("json")) {
            saveAsJSON(groups, new File(file));
        } else {
            System.out.println("Unrecognized format: " + format);
        }
    }

    private static void saveAsCSV(List<ContactData> contacts, File file) throws IOException {
        try (Writer writer = new FileWriter(file)) {
            for (ContactData contact : contacts) {
                writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n", contact.getLastname(), contact.getFirstname(),
                        contact.getAddress(), contact.getMobilePhone(), contact.getWorkPhone(), contact.getHomePhone(),
                        contact.getEmail(), contact.getEmail2(), contact.getEmail3(), contact.getPhoto()));
            }
        }
    }

    private void saveAsJSON(List<ContactData> contacts, File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
        String json = gson.toJson(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(json);
        }
    }

    private void saveAsXML(List<ContactData> contacts, File file) throws IOException {
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        xstream.allowTypes(new Class[]{ContactData.class});
        String xml = xstream.toXML(contacts);
        try (Writer writer = new FileWriter(file)) {
            writer.write(xml);
        }
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            contacts.add(new ContactData()
                    .withLastname(String.format("Lastname %s", i))
                    .withFirstname(String.format("Firstname %s", i))
                    .withAddress(String.format("Address %s", i))
                    .withMobilePhone(String.format("MobilePhone %s", i))
                    .withWorkPhone(String.format("WorkPhone %s", i))
                    .withHomePhone(String.format("HomePhone %s", i))
                    .withEmail(String.format("Email %s", i))
                    .withEmail2(String.format("Email2 %s", i))
                    .withEmail3(String.format("Email3 %s", i))
                    .withPhoto(new File(String.format("Photo %s", i)))
            );
        }
        return contacts;
    }
}
