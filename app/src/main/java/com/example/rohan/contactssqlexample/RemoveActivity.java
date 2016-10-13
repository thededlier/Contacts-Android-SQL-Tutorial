package com.example.rohan.contactssqlexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RemoveActivity extends AppCompatActivity {

    EditText contactId;
    Button btnRemove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);

        final DatabaseHandler db = new DatabaseHandler(this);

        contactId = (EditText)findViewById(R.id.contactId);

        btnRemove = (Button)findViewById(R.id.btnRemove);

        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (contactId.length() > 0) {
                    int id = Integer.parseInt(contactId.getText().toString());
                    db.deleteContact(new Contact(id));

                    Toast.makeText(getApplicationContext(), "Removed Contact", Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                else
                    Toast.makeText(getApplicationContext(), "Please enter ID", Toast.LENGTH_LONG).show();

            }
        });

    }
}
