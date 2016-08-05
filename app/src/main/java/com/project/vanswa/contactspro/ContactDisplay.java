package com.project.vanswa.contactspro;


import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.project.vanswa.contactdao.*;
import java.util.ArrayList;
import java.util.List;


public class ContactDisplay extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //if I use a list activity for my main thread I lose support for application tools such as setSupportActionBar(toolbar) which doesnt allow me to easily set the application name
        //since I am new to Android and with my limited time I am not sure how to go about adding it back in.

        ContactDaoImpl contactDao = new ContactDaoImpl();
        List<Contact> contacts = contactDao.getAllContacts();
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<String> phone = new ArrayList<String>();
        for(int i =0; i<contacts.size();i++){
            names.add(contacts.get(i).getName());
            phone.add(contacts.get(i).getWorkPhone());
        }


        SmallListAdapter adapter = new SmallListAdapter (this,names,phone);
        setListAdapter(adapter);
        setContentView(R.layout.activity_contact_display);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
    }
}
