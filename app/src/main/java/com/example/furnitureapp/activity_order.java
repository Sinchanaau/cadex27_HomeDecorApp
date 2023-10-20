package com.example.furnitureapp;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class activity_order extends AppCompatActivity {
    private EditText nameEditText, mobileEditText, pinCodeEditText, addressEditText, localityEditText, cityEditText, stateEditText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        // Initialize the SQLite database helper
        AddressDatabaseHelper dbHelper = new AddressDatabaseHelper(this);

        // Initialize UI elements
        nameEditText = findViewById(R.id.editTextText);
        mobileEditText = findViewById(R.id.editTextText2);
        pinCodeEditText = findViewById(R.id.editTextText4);
        addressEditText = findViewById(R.id.editTextText5);
        localityEditText = findViewById(R.id.editTextText6);
        cityEditText = findViewById(R.id.editTextText7);
        stateEditText = findViewById(R.id.editTextText8);

        Button saveAddressButton = findViewById(R.id.button2);
        saveAddressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data from EditText fields
                String name = nameEditText.getText().toString();
                String mobile = mobileEditText.getText().toString();
                String pinCode = pinCodeEditText.getText().toString();
                String address = addressEditText.getText().toString();
                String locality = localityEditText.getText().toString();
                String city = cityEditText.getText().toString();
                String state = stateEditText.getText().toString();

                // Save the address to the database
                saveAddressToDatabase(dbHelper, name, mobile, pinCode, address, locality, city, state);

                // Optionally, display a success message or perform any other actions.
                Intent intent=new Intent(getApplicationContext(), activity_address.class);
                intent.putExtra("name",name);
                intent.putExtra("num",mobile);
                intent.putExtra("pin",pinCode);
                intent.putExtra("address",address);
                intent.putExtra("locality",locality);
                intent.putExtra("city",city);
                intent.putExtra("state",state);
                startActivity(intent);
            }
        });
    }

    private void saveAddressToDatabase(AddressDatabaseHelper dbHelper, String name, String mobile, String pinCode, String address, String locality, String city, String state) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("mobile", mobile);
        values.put("pin_code", pinCode);
        values.put("address", address);
        values.put("locality", locality);
        values.put("city", city);
        values.put("state", state);

        long newRowId = db.insert("addresses", null, values);

        if (newRowId != -1) {
            // Data inserted successfully
        } else {
            // Error occurred
        }

        db.close();
    }
}