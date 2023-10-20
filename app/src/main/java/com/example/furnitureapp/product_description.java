package com.example.furnitureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class product_description extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description);
        TextView productname=findViewById(R.id.furniture_name);
        TextView productprice=findViewById(R.id.furniture_price);
        ImageView productimage=findViewById(R.id.furniture1);
        ImageView add=findViewById(R.id.imageView9);
        ImageView minus=findViewById(R.id.imageView8);
        TextView result=findViewById(R.id.textView3);
        ImageView back=findViewById(R.id.backbutton);
        ImageView image=findViewById(R.id.furniture1);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Home_page.class);
                startActivity(intent);
            }
        });
        Button addtocart=findViewById(R.id.button);
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), activity_cart.class);
                startActivity(intent);
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter;
                counter=Integer.parseInt(result.getText().toString());
                counter++;
                result.setText(counter+"");

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter;
                counter=Integer.parseInt(result.getText().toString());
                counter--;
                if(counter<1){
                    counter=1;
                }
                result.setText(counter+"");
            }
        });
        Intent intent=getIntent();
        int imageurl=intent.getIntExtra("imageUrl",0);
        String product_name=intent.getStringExtra("productName");
        String product_price=intent.getStringExtra("productprice");
        productname.setText(product_name);
        productprice.setText(product_price);
        productimage.setImageResource(imageurl);

    }
}