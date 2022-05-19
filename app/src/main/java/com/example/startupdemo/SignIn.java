package com.example.startupdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignIn extends AppCompatActivity {

    EditText  email, password;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        Button signIn = (Button) findViewById(R.id.buttonSignIn);
        Button signUp = (Button) findViewById(R.id.buttonSignUp);
        DB = new DBHelper(this);
        email=(EditText) findViewById(R.id.editTextTextEmailAddress);
        password=(EditText) findViewById(R.id.editTextTextPassword);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailTXT = email.getText().toString();
                String passTXT = password.getText().toString();
                if(emailTXT.equals("")||passTXT.equals(""))
                    Toast.makeText(SignIn.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkusernamepassword = DB.checkusernamepassword(emailTXT, passTXT);
                    if(checkusernamepassword){
                        Toast.makeText(SignIn.this, "Sign In Successful", Toast.LENGTH_SHORT).show();
                        openMainActivity();
                    }else{
                        Toast.makeText(SignIn.this, "Invalid", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpActivity();
            }
        });
    }
    public void openSignUpActivity() {
        Intent intent2 = new Intent(this, SignUp.class);
        startActivity(intent2);
    }

    public void openMainActivity() {
        Intent intent3 = new Intent(this, MainActivity.class);

        startActivity(intent3);
    }
}
