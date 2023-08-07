package ru.stda.pft.addressbook.model;


import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactData> {
    private Set<ContactData> delegate;

    public Contacts(Contacts contacs){
        this.delegate = new HashSet<>(contacs.delegate);
    }


    public Contacts(){
        this.delegate= new HashSet<>();
    }

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacts withAdded (ContactData contact){
        Contacts contacs = new Contacts(this);
        contacs.add(contact);
        return  contacs;
    }

    public Contacts without (ContactData contac){
        Contacts contacs = new Contacts(this);
        contacs.remove(contac);
        return  contacs;
    }
}
