package com.example.rohan.contactssqlexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView contactCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        contactCount = (TextView)findViewById(R.id.contactCount);

        int count = db.getContactsCount();
        contactCount.setText("Contacts : " + count);
        List<Contact> contacts = db.getAllContacts();

    }
}
