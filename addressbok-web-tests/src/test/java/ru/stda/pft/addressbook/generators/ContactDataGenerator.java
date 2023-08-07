package ru.stda.pft.addressbook.generators;


import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.stda.pft.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    @Parameter(names ="-c", description = "Contact count")
    public int count;
    @Parameter (names ="-f", description = "Target count")
    public String file;

    public static void main(String[] args) throws IOException {
        ContactDataGenerator generator = new ContactDataGenerator();
        JCommander jCommander =  new JCommander(generator);
        try {
            jCommander.parse(args);
        } catch (ParameterException ex){
            jCommander.usage();
            return;
        }
        generator.run();

    }
    public void run() throws IOException {
        List<ContactData> contacts = generateContacts(count);
        save(contacts, new File(file));
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact:contacts){
            writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s\n",  contact.getLastname(),contact.getFirstname(),
                    contact.getAddress(), contact.getMobilePhone(),contact.getWorkPhone(), contact.getHomePhone(),
                    contact.getEmail(),contact.getEmail2(), contact.getEmail3(),contact.getPhoto()));
        }
        writer.close();
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
