package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.security.acl.Group;

public class SignUpActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    String s = "";

    EditText edtname;
    EditText edtemail1;
    EditText edtcontact;
    RadioGroup radioGroup;
    RadioButton radioMale;
    RadioButton radioFemale;
    CheckBox Reading, Playing, Travelling;
    Spinner eduspinner;
    EditText edtpassword;
    Button btnsignup;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    String passwordPattern = ("^" + "(?=.*[@#$%^&+=])" + "(?=\\S+$)" + ".{4,}" + "$");


    String[] Education = {"10th", "12th", "Graduate", "PostGraduate", "Other"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        edtname = findViewById(R.id.edtname);
        edtemail1 = findViewById(R.id.edtemail1);
        edtcontact = findViewById(R.id.edtcontact);
        radioGroup = findViewById(R.id.radioGroup);
        radioMale = findViewById(R.id.radioMale);
        radioFemale = findViewById(R.id.radioFemale);
        Reading = findViewById(R.id.Reading);
        Playing = findViewById(R.id.Playing);
        Travelling = findViewById(R.id.Travelling);
        eduspinner = findViewById(R.id.eduspinner);
        edtpassword = findViewById(R.id.edtpassword);
        btnsignup = findViewById(R.id.btnsignup);


        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) group.findViewById(checkedId);
            }
        });


        TextView btn = (TextView) findViewById(R.id.txthave);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        Spinner spin = (Spinner) findViewById(R.id.eduspinner);
        spin.setOnItemSelectedListener(this);

        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Education);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(aa);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Send data one page to another page
                Intent signup = new Intent(getApplicationContext(),LoginData.class);
                signup.putExtra("Name", edtname.getText().toString());
                signup.putExtra("EmailID", edtemail1.getText().toString());
                signup.putExtra("ContactNo", edtcontact.getText().toString());
                //signup.putExtra("Gender", radioGroup.getText().toString());
                signup.putExtra("Password", edtpassword.getText().toString());

                Log.e("n",edtname.getTextDirection()+"."+ edtemail1.getTextDirection()+"."+edtcontact.getTextDirection()+"."+edtpassword.getTextDirection());
                startActivity(signup);

                if (edtname.length() == 0) {
                    edtname.setError("This field is required");
                }

                if (edtemail1.getText().toString().isEmpty()) {
                    //Toast.makeText(getApplicationContext(),"Enter email address",Toast.LENGTH_SHORT).show();
                    edtemail1.setError("Enter email address");
                } else {
                    if (edtemail1.getText().toString().trim().matches(emailPattern)) {
                        Toast.makeText(getApplicationContext(), "Valid email address", Toast.LENGTH_SHORT).show();
                    } else {
                        //Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                        edtemail1.setError("Invalid email address");
                    }
                }

                if (edtcontact.length() == 0) {
                    edtcontact.setError("This field is required");
                }

                if (edtpassword.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                } else {
                    if (edtpassword.getText().toString().trim().matches(passwordPattern)) {
                        Toast.makeText(getApplicationContext(), "Valid password", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid password", Toast.LENGTH_SHORT).show();
                    }
                }


                //radio button
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(SignUpActivity.this, "No answer has been selected", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton radioButton = (RadioButton) radioGroup.findViewById(selectedId);
                    s = "" + radioButton.getText();
                }

                //Check box
                StringBuilder result = new StringBuilder();
                //result.append("Selected Items:");
                if (Reading.isChecked()) {
                    result.append("," + "Reading");
                }
                if (Playing.isChecked()) {
                    result.append("," + "Playing");
                }
                if (Travelling.isChecked()) {
                    result.append("," + "Travelling");
                }
                s = s + result;
                Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();

                //spinner

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),Education[position] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}





