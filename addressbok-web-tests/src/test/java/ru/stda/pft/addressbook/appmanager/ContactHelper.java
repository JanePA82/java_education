package ru.stda.pft.addressbook.appmanager;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stda.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{
    ;

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstname() );
        type(By.name("middlename"),contactData.getMiddlename() );
        type(By.name("lastname"),contactData.getLastname() );
        type(By.name("nickname"),contactData.getNickname() );
        type(By.name("title"),contactData.getTitle() );
        type(By.name("company"),contactData.getCompany() );
        type(By.name("address"),contactData.getAddress() );
        type(By.name("home"),contactData.getHomePhone() );
        type(By.name("mobile"),contactData.getMobilePhone() );
        type(By.name("work"),contactData.getWorkPhone() );
        type(By.name("fax"),contactData.getFax() );
        type(By.name("email"),contactData.getEmail() );
        type(By.name("email2"),contactData.getEmail2() );
        type(By.name("email3"),contactData.getEmail3() );
        type(By.name("homepage"),contactData.getHomepage() );
        chois(By.name("bday"),contactData.getBday() );
        chois(By.name("bmonth"),contactData.getBmonth() );
        type(By.name("byear"),contactData.getByear() );
        chois(By.name("aday"),contactData.getAday() );
        chois(By.name("amonth"),contactData.getAmonth() );
        type(By.name("ayear"),contactData.getAyear() );
        chois(By.name("new_group"),contactData.getNew_group() );

        type(By.name("address2"),contactData.getAddress2() );
        type(By.name("phone2"),contactData.getPhone2() );
        type(By.name("notes"),contactData.getNotes() );


  /*    public void testUntitledTestCase() throws Exception {
        wd.get("http://localhost:8080/addressbook/edit.php");
        wd.findElement(By.name("photo")).click();
        wd.findElement(By.name("photo")).clear();
        wd.findElement(By.name("photo")).sendKeys(contactData.getPhoto());
      }*/

    }
    public void gotoContactAdiitionPage() {
       click(By.linkText("add new"));

    }

    public void submitContactCreation() {
        click(By.xpath("//div[@id='content']/form/input[21]"));


}}
