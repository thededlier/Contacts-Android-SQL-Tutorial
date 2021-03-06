package com.example.rohan.contactssqlexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView contactCount;
    TextView contactList;

    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        contactCount    = (TextView)findViewById(R.id.contactCount);
        contactList     = (TextView) findViewById(R.id.contactList);


        btnAdd = (Button)findViewById(R.id.btnAdd);
        btnRemove = (Button)findViewById(R.id.btnRemove);
        btnUpdate = (Button)findViewById(R.id.btnUpdate);

        int count = db.getContactsCount();
        contactCount.setText("Contacts : " + count);

        String list = "";
        List<Contact> contacts = db.getAllContacts();
        for(Contact cn : contacts) {
            list += "Id : " + cn.getID() + " Name : " + cn.getName() + " Phone Number : " + cn.getPhoneNumber() + "\n";
        }
        contactList.setText(list);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddActivity.class));
            }
        });

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RemoveActivity.class));
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UpdateActivity.class));
            }
        });
    }
}
