package com.example.furnitureapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseAuthException;

import java.util.Objects;

public class Login_page extends AppCompatActivity {
    EditText lemail;
    EditText lpassword;
    Button login;
    TextView forgotpassword, register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        lemail = findViewById(R.id.emaileditText);
        lpassword = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.login);
        forgotpassword = findViewById(R.id.forgot_password);
        register = findViewById(R.id.registertextView);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validateEmail() | !validatePassword()) {
                    Toast.makeText(Login_page.this,"Please fill the required field",Toast.LENGTH_SHORT).show();
                } else {
                    checkUser();
                    startActivity(new Intent(Login_page.this, Home_page.class));
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login_page.this, Registration_page.class));
            }
        });
    }

    public Boolean validateEmail() {
        String val = lemail.getText().toString();
        if (val.isEmpty()) {
            lemail.setError("Email cannot be empty");
            return false;
        } else {
            lemail.setError(null);
            return true;
        }
    }

    public Boolean validatePassword() {
        String val = lpassword.getText().toString();
        if (val.isEmpty()) {
            lpassword.setError("Password cannot be empty");
            return false;
        } else {
            lpassword.setError(null);
            return true;
        }
    }

    public void checkUser() {
        String useremail = lemail.getText().toString().trim();
        String userpassword = lpassword.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("email").equalTo(useremail);
        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    lemail.setError(null);
                    String passwordDB = snapshot.child(useremail).child("password").getValue(String.class);

                    if (!Objects.equals(passwordDB,userpassword)) {
                        lemail.setError(null);

                    } else {
                        lpassword.setError("Invalid Credentials");
                        lpassword.requestFocus();
                    }
                } else {
                    lemail.setError("User does not exist");
                    lemail.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}