package com.example.rohan.contactssqlexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView contactCount;
    ListView contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        contactCount    = (TextView)findViewById(R.id.contactCount);
        contactList     = (ListView)findViewById(R.id.contactList);


        int count = db.getContactsCount();
        contactCount.setText("Contacts : " + count);

        List<Contact> contacts = db.getAllContacts();
        ArrayAdapter adapter = new ArrayAdapter<Contact>(this, R.layout.activity_main, contacts);
        contactList.setAdapter(adapter);
    }
}
