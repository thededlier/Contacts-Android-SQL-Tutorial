package com.example.rohan.contactssqlexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView contactCount;
    TextView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        contactCount    = (TextView)findViewById(R.id.contactCount);
        contactList     = (TextView) findViewById(R.id.contactList);


        int count = db.getContactsCount();
        contactCount.setText("Contacts : " + count);

        String list = "";
        List<Contact> contacts = db.getAllContacts();
        for(Contact cn : contacts) {
            list += "Id : " + cn.getID() + " Name : " + cn.getName() + " Phone Number : " + cn.getPhoneNumber();
        }

        contactList.setText(list);
    }
}
