package com.project.vanswa.contactdao;

import java.util.List;

/**
 * Created by vonstuben on 11/13/2015.
 */
public interface ContactDAO {
    public List<Contact> getAllContacts();
    public Contact getContact(int employeeId);
    public void updateContact(Contact contact);
    public void deleteContact(Contact contact);
 }
