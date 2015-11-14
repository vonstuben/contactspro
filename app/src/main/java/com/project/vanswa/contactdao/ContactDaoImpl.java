package com.project.vanswa.contactdao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vonstuben on 11/13/2015.
 */
public class ContactDaoImpl implements ContactDAO{

    //this is a psuedo database for demonstration purposes.
    List<Contact> Contacts;

    public ContactDaoImpl() {
        Contacts = new ArrayList<Contact>();
        Contact testContact = new Contact("Jane Doe");
        // parse data from link http request?
        //  create Contacts
        //store contacts in order by position set position in contact
    }

    @Override
    public List<Contact> getAllContacts() {
        return Contacts;
    }

    @Override
    public Contact getContact(int position) {
        return Contacts.get(position);
    }

    @Override
    public void updateContact(Contact contact) {
    System.out.println(contact.getName() + " has been update");
    }

    @Override
    public void deleteContact(Contact contact) {
        Contacts.remove(contact.getPosition());
        System.out.println("Contact " + contact.getName() + " has been removed from the database");
    }
}
