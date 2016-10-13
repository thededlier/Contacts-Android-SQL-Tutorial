package com.example.rohan.contactssqlexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    EditText contactId;
    EditText contactName;
    EditText contactPhone;

    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        final DatabaseHandler db = new DatabaseHandler(this);

        contactId = (EditText)findViewById(R.id.contactId);
        contactName = (EditText)findViewById(R.id.contactName);
        contactPhone = (EditText)findViewById(R.id.contactPhone);

        btnUpdate = (Button)findViewById(R.id.btnUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(contactId.length() > 0) {
                    int id = Integer.parseInt(contactId.getText().toString());
                    db.updateContact(new Contact(id, contactName.getText().toString(), contactPhone.getText().toString()));

                    Toast.makeText(getApplicationContext(), "Updated", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(getApplicationContext(), "Enter id", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
