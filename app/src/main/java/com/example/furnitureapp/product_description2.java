package com.example.furnitureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class product_description2 extends AppCompatActivity {
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_description2);
        TextView productname=findViewById(R.id.furniture_name);
        TextView productprice=findViewById(R.id.furniture_price);
        TextView result=findViewById(R.id.textView3);
        ImageView productimage=findViewById(R.id.furniture1);
        Button addtocart=findViewById(R.id.button);
        ImageView add=findViewById(R.id.imageView9);
        ImageView minus=findViewById(R.id.imageView8);
        ImageView back=findViewById(R.id.backbutton);
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
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(), Home_page.class);
                startActivity(intent);
            }
        });
        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(product_description2.this,activity_cart.class);
                intent.putExtra("p_name",productname.getText().toString());
                intent.putExtra("p_price",productprice.getText().toString());
                intent.putExtra("image",R.drawable.f1);
                startActivity(intent);
            }
        });



    }
}