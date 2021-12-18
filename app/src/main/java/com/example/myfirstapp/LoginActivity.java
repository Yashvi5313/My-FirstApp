package com.example.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

        public class LoginActivity extends AppCompatActivity {

            EditText inputEmail;
            EditText inputPassword;
            Button btnlogin;
            String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
            String passwordPattern = ("^" +"(?=.*[@#$%^&+=])" + "(?=\\S+$)" + ".{4,}" + "$");

            //boolean isAllFieldsChecked = false;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.login);

                inputEmail = (EditText) findViewById(R.id.edtemail);
                inputPassword = (EditText) findViewById(R.id.edtpass);
                btnlogin = (Button) findViewById(R.id.btnlogin);

                btnlogin.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View arg0) {
//                      isAllFieldsChecked = CheckAllFields();
//                        if (isAllFieldsChecked) {
//                            Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
//                            startActivity(i);
//                        }

                        //Send data one page to another page
                        Intent login = new Intent(getApplicationContext(),LoginData.class);
                        login.putExtra("edtemail", inputEmail.getText().toString());
                        login.putExtra("edtpass", inputPassword.getText().toString());

                        Log.e("n",inputEmail.getText()+"."+ inputPassword.getText());
                        startActivity(login);



                        //Validation
                        if(inputEmail.getText().toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(),"Enter email address",Toast.LENGTH_SHORT).show();
                        }else {
                            if (inputEmail.getText().toString().trim().matches(emailPattern)) {
                                Toast.makeText(getApplicationContext(),"Valid email address",Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(),"Invalid email address", Toast.LENGTH_SHORT).show();
                            }
                        }

                        if(inputPassword.getText().toString().isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
                        }else{
                            if (inputPassword.getText().toString().trim().matches(passwordPattern)) {
                                Toast.makeText(getApplicationContext(),"Valid password", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(),"Invalid password", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

                TextView t1 = (TextView) findViewById(R.id.txtdont);
                t1.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                        startActivity(i);
                    }
                });

                TextView t2 = (TextView) findViewById(R.id.forgot);
                t2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i1 = new Intent(getApplicationContext(), ForgotPasswordActivity.class);
                        startActivity(i1);
                    }
                });
            }


//            boolean CheckAllFields() {
//
//                if (edtemail.length() == 0) {
//                    edtemail.setError("Email is required");
//                    return false;
//                }
//
//                if (edtpass.length() == 0) {
//                    edtpass.setError("Password is required");
//                    return false;
//                } else if (edtpass.length() < 8) {
//                    edtpass.setError("Password must be minimum 8 characters");
//                    return false;
//                }
//                return true;
//            }
        }




