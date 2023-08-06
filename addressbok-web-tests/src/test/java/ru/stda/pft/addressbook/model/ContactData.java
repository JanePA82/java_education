package ru.stda.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private  String firstname;
    private String middlename;
    private  String lastname;
    private String nickname;
    private String photo;
    private String title;
    private String company;
    private String address;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String fax;
    private String email;
    private String email2;
    private String email3;
    private String homepage;
    private String bday;
    private String bmonth;
    private String byear;
    private String aday;
    private String amonth;
    private String ayear;
    private String new_group;
    private String address2;
    private String phone2;
    private String notes;


    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

/*    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homePhone, String mobilePhone, String workPhone, String fax, String email, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amonth, String ayear, String new_group, String address2, String phone2, String hdf, Object o) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.fax = fax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
        this.new_group = new_group;
        this.address2 = address2;
        this.phone2 = phone2;
    }

    public ContactData(int id, String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homePhone, String mobilePhone, String workPhone, String fax, String email, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amonth, String ayear, String new_group, String address2, String phone2, String hdf, Object o) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.fax = fax;
        this.email = email;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth;
        this.ayear = ayear;
        this.new_group = new_group;
        this.address2 = address2;
        this.phone2 = phone2;
    }*/



    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname) && Objects.equals(lastname, that.lastname) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, address);
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public CharSequence getPhoto() {
        return photo;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getBday() { return bday;    }

    public String getBmonth() {
        return bmonth;
    }

    public String getByear() {
        return byear;
    }

    public String getAday() {
        return aday;
    }

    public String getAmonth() {
        return amonth;
    }

    public String getAyear() {
        return ayear;
    }

    public String getNew_group() {
        return new_group;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getNotes() {
        return notes;
    }

    public int getId() { return id;}

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }


    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;

    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;

    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;

    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;

    }

    public ContactData withPhoto(String photo) {
        this.photo = photo;
        return this;

    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;

    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;

    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;

    }

    public ContactData withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;

    }

    public ContactData withMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;

    }

    public ContactData withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;

    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;

    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;

    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;

    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;

    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;

    }

    public ContactData withBday(String bday) {
        this.bday = bday;
        return this;

    }

    public ContactData withBmonth(String bmonth) {
        this.bmonth = bmonth;
        return this;

    }

    public ContactData withByear(String byear) {
        this.byear = byear;
        return this;

    }

    public ContactData withAday(String aday) {
        this.aday = aday;
        return this;

    }

    public ContactData withAmonth(String amonth) {
        this.amonth = amonth;
        return this;

    }

    public ContactData withAyear(String ayear) {
        this.ayear = ayear;
        return this;

    }

    public ContactData withNew_group(String new_group) {
        this.new_group = new_group;
        return this;

    }

    public ContactData withAddress2(String address2) {
        this.address2 = address2;
        return this;

    }

    public ContactData withPhone2(String phone2) {
        this.phone2 = phone2;
        return this;

    }

    public ContactData withNotes(String notes) {
        this.notes = notes;
        return this;

    }
}


