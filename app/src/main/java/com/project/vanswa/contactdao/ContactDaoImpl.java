package com.project.vanswa.contactdao;

import com.project.vanswa.jsonfactory.DataFactory;
import com.project.vanswa.jsonfactory.JData;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by vonstuben on 11/13/2015.
 */
public class ContactDaoImpl implements ContactDAO{

    //this is a psuedo database for demonstration purposes.
    List<Contact> Contacts;
    ArrayList<JData> data;

    public ContactDaoImpl() {
        Contacts = new ArrayList<Contact>();
        //create factory to parse json and send data to daoimpl
        DataFactory dataFactory = new DataFactory();
        dataFactory.create();
        data = dataFactory.getDataList();
        //create contacts for display
        for(int i = 0; i < data.size(); i++){
            JData tempData = data.get(i);
            Contact newContact = new Contact();
            newContact.setName(tempData.getData("name"));
            newContact.setWorkPhone(tempData.getData("work"));
            Contacts.add(newContact);
        }


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
