package com.example.rohan.contactssqlexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    EditText newName;
    EditText newPhoneNumber;

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final DatabaseHandler db = new DatabaseHandler(this);

        newName = (EditText)findViewById(R.id.newName);
        newPhoneNumber = (EditText)findViewById(R.id.newPhoneNumber);

        btnAdd = (Button)findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.addContact(new Contact(newName.getText().toString(), newPhoneNumber.getText().toString()));
                Toast.makeText(getApplicationContext(), "Successfully added new conact", Toast.LENGTH_LONG).show();

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
