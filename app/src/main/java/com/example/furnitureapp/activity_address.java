package com.example.furnitureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activity_address extends AppCompatActivity {
    TextView name,address;
    Button order;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        name=findViewById(R.id.textView19);
        address=findViewById(R.id.textView22);
        order=findViewById(R.id.button3);
        Intent intent=getIntent();
        String p_name=intent.getStringExtra("name");
        String address1=intent.getStringExtra("address");
        name.setText(p_name);
        address.setText(address1);
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), activity_thankyou.class);
                startActivity(intent);
            }
        });
    }
}