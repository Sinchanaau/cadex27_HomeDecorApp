package com.example.furnitureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration_page extends AppCompatActivity {
EditText registername,register_email,register_password;
Button register;
TextView login;
FirebaseDatabase database;
DatabaseReference reference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        registername=findViewById(R.id.name);
        register_email=findViewById(R.id.email);
        register_password=findViewById(R.id.Password);
        register=findViewById(R.id.signup);
        login=findViewById(R.id.logintextView);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database=FirebaseDatabase.getInstance();
                reference=database.getReference("users");
                String name=registername.getText().toString();
                String email=register_email.getText().toString();
                String password=register_password.getText().toString();

                HelperClass helperClass=new HelperClass(name,email,password);
                reference.child(name).setValue(helperClass);

                Toast.makeText(Registration_page.this, "You have registered successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Registration_page.this, Login_page.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Registration_page.this, Login_page.class));
            }
        });
    }
}