package ru.stda.pft.addressbook;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String photo;
    private final String title;
    private final String company;
    private final String address;
    private final String homePhone;
    private final String mobilePhone;
    private final String workPhone;
    private final String fax;
    private final String email;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final String bday;
    private final String bmonth;
    private final String byear;
    private final String aday;
    private final String amonth;
    private final String ayear;
    private final String new_group;
    private final String address2;
    private final String phone2;
    private final String notes;


    public ContactData(String firstname, String middlename, String lastname, String nickname,  String title, String company, String address, String homePhone, String mobilePhone, String workPhone, String fax, String email, String email2, String email3, String homepage, String bday, String bmonth, String byear, String aday, String amonth, String ayear, String new_group, String address2, String phone2, String notes, String photo)
    {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.photo = photo;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homePhone = homePhone;
        this.mobilePhone = mobilePhone;
        this.workPhone = workPhone;
        this.fax = fax;
        this.email = email;
        this. email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
        this.bday = bday;
        this.bmonth = bmonth;
        this.byear = byear;
        this.aday = aday;
        this.amonth = amonth ;
        this.ayear = ayear ;
        this.new_group = new_group;
        this.address2 = address2;
        this.phone2 = phone2;
        this.notes = notes;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
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

    public String getTitle() {return title; }
    public String getCompany() {return company; }
    public String getAddress() {return address; }

    public String getHomePhone() {return homePhone;}
    public String getMobilePhone() {return mobilePhone;}
    public String getWorkPhone() {return workPhone;}
    public String getFax() {return fax;}
    public String getEmail() {return email;}
    public String getEmail2() {return email2;}
    public String getEmail3() {return email3;}
    public String getHomepage() {return homepage;}
    public String getBday() {return bday;}
    public String getBmonth() {return bmonth;}
    public String getByear() {return byear;}
    public String getAday() {return aday;}
    public String getAmonth() {return amonth;}
    public String getAyear() {return ayear;}
    public String getNew_group() {return new_group;}
    public String getAddress2() {return address2;}
    public String getPhone2() {return phone2;}
    public String getNotes() {return notes;}
}
