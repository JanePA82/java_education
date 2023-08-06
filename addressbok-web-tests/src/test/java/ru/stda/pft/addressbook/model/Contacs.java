package ru.stda.pft.addressbook.model;


import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacs extends ForwardingSet<ContactData> {
    private Set<ContactData> delegate;

    public Contacs(Contacs contacs){
        this.delegate = new HashSet<>(contacs.delegate);
    }


    public Contacs(){
        this.delegate= new HashSet<>();
    }

    @Override
    protected Set<ContactData> delegate() {
        return delegate;
    }

    public Contacs withAdded (ContactData contact){
        Contacs contacs = new Contacs(this);
        contacs.add(contact);
        return  contacs;
    }

    public Contacs without (ContactData contac){
        Contacs contacs = new Contacs(this);
        contacs.remove(contac);
        return  contacs;
    }
}
