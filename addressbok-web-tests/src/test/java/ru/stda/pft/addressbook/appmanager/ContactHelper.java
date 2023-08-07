package ru.stda.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import ru.stda.pft.addressbook.model.Contacts;
import ru.stda.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {


    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void filling(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("middlename"), contactData.getMiddlename());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("nickname"), contactData.getNickname());
        type(By.name("title"), contactData.getTitle());
        type(By.name("company"), contactData.getCompany());
        type(By.name("address"), contactData.getAddress());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("mobile"), contactData.getMobilePhone());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("fax"), contactData.getFax());
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("homepage"), contactData.getHomepage());
        chois(By.name("bday"), contactData.getBday());
        chois(By.name("bmonth"), contactData.getBmonth());
        type(By.name("byear"), contactData.getByear());
        chois(By.name("aday"), contactData.getAday());
        chois(By.name("amonth"), contactData.getAmonth());
        type(By.name("ayear"), contactData.getAyear());
        if (isElementPresent(By.name("new_group"))) {
            chois(By.name("new_group"), contactData.getNew_group());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
        type(By.name("address2"), contactData.getAddress2());
        type(By.name("phone2"), contactData.getPhone2());
        type(By.name("notes"), contactData.getNotes());


  /*    public void testUntitledTestCase() throws Exception {
        wd.get("http://localhost:8080/addressbook/edit.php");
        wd.findElement(By.name("photo")).click();
        wd.findElement(By.name("photo")).clear();
        wd.findElement(By.name("photo")).sendKeys(contactData.getPhoto());
      }*/

    }

    public void clickAdd() {
        click(By.linkText("add new"));
    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[1]"));
    }

    public void selectContact() {
        if (isElementPresent(By.name("selected[]"))) {
            click(By.name("selected[]"));
        }
    }
    public void selectContactById(int id) {
        if (isElementPresent(By.name("selected[]"))) {
                wd.findElement(By.cssSelector("input[value='"+id+"']")).click();
        }
    }


    public void submitContactDelete() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
//        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));

    }

    public void edit(String index) {
        click(By.cssSelector(String.format("a[href='edit.php?id=%s']", index)));
    }


    public void submitChange() {
        click(By.name("update"));
    }



    public int nextId() {
        List<WebElement> elements = wd.findElements(By.name("entry"));
        int nextId = 0;
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")) + 1;
            if (id > nextId) {
                nextId = id;
            }
        }
        return nextId;
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public void create(ContactData contact) {
        clickAdd();
        filling(contact);
        submitContactCreation();
        NavigationHelper.homePage();
    }

    public void delete() {
        selectContact();
        submitContactDelete();
        NavigationHelper.homePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        submitContactDelete();
        NavigationHelper.homePage();
    }
    private Contacts contacCache=null;


    public Set<ContactData> all() {
        if (contacCache!=null) {return new Contacts(contacCache);}
        Contacts contacCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
//        System.out.println (elements);
        for (WebElement element : elements) {
            List<WebElement> els = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(els.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firstname = els.get(2).getText();
            String lastname = els.get(1).getText();
            String address = els.get(3).getText();
            String allPhones = els.get(5).getText();
            String allEmails = els.get(4).getText();

            contacCache.add(new ContactData()
                    .withId(id)
                    .withLastname(lastname)
                    .withFirstname(firstname)
                    .withAddress(address)
                    .withAllPhones (allPhones)
                    .withAllEmails (allEmails)

/*                    .withHomePhone(phones [0])
                    .withMobilePhone(phones [1])
                    .withWorkPhone(phones [2])
                    .withEmail(emails[0])
                    .withEmail2(emails[1])
                    .withEmail3(emails[2])*/
            );
        }
        return contacCache;
    }
    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
//        System.out.println (elements);
        for (WebElement element : elements) {
            List<WebElement> els = element.findElements(By.tagName("td"));
            int id = Integer.parseInt(els.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firstname = els.get(2).getText();
            String lastname = els.get(1).getText();
            String address = els.get(3).getText();
            ContactData contact = new ContactData()
                    .withId(id)
                    .withLastname(lastname)
                    .withFirstname(firstname)
                    .withAddress(address);
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        return new ContactData().withId(contact.getId())
                .withFirstname(firstname)
                .withLastname(lastname)
                .withAddress(address)
                .withHomePhone(home)
                .withMobilePhone(mobile)
                .withWorkPhone(work)
                .withEmail(email)
                .withEmail2(email2)
                .withEmail3(email3)
                ;
            }

    public void initContactModificationById (int id) {
/*        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
        WebElement row = checkbox.findElement(By.xpath("./../../"));
        List <WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();*/
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

   /* public void fillContactFormModify(ContactData contactDataModify) {
        type(By.name("firstname"), contactDataModify.getFirstname());
        type(By.name("middlename"), contactDataModify.getMiddlename());
        type(By.name("lastname"), contactDataModify.getLastname());
        type(By.name("nickname"), contactDataModify.getNickname());
        type(By.name("title"), contactDataModify.getTitle());
        type(By.name("company"), contactDataModify.getCompany());
        type(By.name("address"), contactDataModify.getAddress());
        type(By.name("home"), contactDataModify.getHomePhone());
        type(By.name("mobile"), contactDataModify.getMobilePhone());
        type(By.name("work"), contactDataModify.getWorkPhone());
        type(By.name("fax"), contactDataModify.getFax());
        type(By.name("email"), contactDataModify.getEmail());
        type(By.name("email2"), contactDataModify.getEmail2());
        type(By.name("email3"), contactDataModify.getEmail3());
        type(By.name("homepage"), contactDataModify.getHomepage());
        chois(By.name("bday"), contactDataModify.getBday());
        chois(By.name("bmonth"), contactDataModify.getBmonth());
        type(By.name("byear"), contactDataModify.getByear());
        chois(By.name("aday"), contactDataModify.getAday());
        chois(By.name("amonth"), contactDataModify.getAmonth());
        type(By.name("ayear"), contactDataModify.getAyear());
        type(By.name("address2"), contactDataModify.getAddress2());
        type(By.name("phone2"), contactDataModify.getPhone2());
        type(By.name("notes"), contactDataModify.getNotes());


    }*/
}
