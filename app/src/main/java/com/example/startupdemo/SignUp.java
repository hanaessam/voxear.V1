package com.example.startupdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.DefaultTaskExecutor;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.BreakIterator;

public class SignUp extends AppCompatActivity {

    EditText email, password, repassword;
    Button signin, signup;
    DBHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        SQLiteDatabase MyDB;
        email=(EditText) findViewById(R.id.email);
        password=(EditText) findViewById(R.id.pass);
        repassword = (EditText) findViewById(R.id.editTextTextPassword);
        signin=(Button)findViewById(R.id.SignIn);
        signup=(Button)findViewById(R.id.buttonSignUp);
        DB= new DBHelper(this);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String emailTXT = email.getText().toString();
                String passTXT = password.getText().toString();
                String repassTXT = repassword.getText().toString();

                if(emailTXT.equals("")|| passTXT.equals("")||repassTXT.equals("")){
                    Toast.makeText(SignUp.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(passTXT.equals(repassTXT)){
                        Boolean checkemail = DB.checkemail(emailTXT);

                        if(checkemail == false){
                            Boolean insertData = DB.insertData(emailTXT, passTXT);
                            if(insertData == true){
                                Toast.makeText(SignUp.this, "Register Successfull", Toast.LENGTH_SHORT).show();
                                openSignInActivity();
                            } else {
                                Toast.makeText(SignUp.this, "Register Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else {
                            Toast.makeText(SignUp.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(SignUp.this, "Password Not Match", Toast.LENGTH_SHORT).show();
                    }
                }
                openSignInActivity();
            }
        });


        signin.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openSignInActivity();
            }
        });


    }


    public void openMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void openSignInActivity() {
        Intent intent = new Intent(getApplicationContext(), SignIn.class);
        startActivity(intent);
    }
}
