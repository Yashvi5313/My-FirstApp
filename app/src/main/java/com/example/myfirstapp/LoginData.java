package com.example.myfirstapp;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.net.PasswordAuthentication;

public class LoginData extends AppCompatActivity {

    TextView txtEmail, txtPass, txtName, txtEmail1, txtContact, txtGender, txtPass1;
    Button btnClose;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_data);

         txtEmail = (TextView) findViewById(R.id.txtEmail);
         txtPass = (TextView) findViewById(R.id.txtPass);
         btnClose = (Button) findViewById(R.id.btnClose);

         txtName = (TextView) findViewById(R.id.txtName);
         txtEmail1 = (TextView) findViewById(R.id.txtEmail1);
         txtContact = (TextView) findViewById(R.id.txtContact);
         txtPass1 = (TextView) findViewById(R.id.txtPass1);


        Intent i = getIntent();
        // Receive Data
        String Email = i.getStringExtra("edtemail");
        String Password = i.getStringExtra("edtpass");
        String Name = i.getStringExtra("Name");
        String Email1 = i.getStringExtra("EmailID");
        String Contact = i.getStringExtra("ContactNo");
        String Password1 = i.getStringExtra("Password");

        Log.e("Second Screen", Email + "." + Password + "." + Name + "." + Email1 + "." + Contact + "." + Password1);

        // Displaying data
        txtEmail.setText(Email);
        txtPass.setText(Password);
        txtName.setText(Name);
        txtEmail1.setText(Email1);
        txtContact.setText(Contact);
        txtPass1.setText(Password1);

        btnClose.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                finish();
            }
        });

    }
}