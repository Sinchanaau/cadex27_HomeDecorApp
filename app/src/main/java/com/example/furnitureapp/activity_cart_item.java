package com.example.furnitureapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_cart_item extends AppCompatActivity {
 ImageView add,minus;
 TextView res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_item);
        add=findViewById(R.id.imageButton);
        minus=findViewById(R.id.imageView12);
        res=findViewById(R.id.textView16);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter;
                counter=Integer.parseInt(res.getText().toString());
                counter++;
                res.setText(counter+"");

            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int counter;
                counter=Integer.parseInt(res.getText().toString());
                counter--;
                if(counter<1){
                    counter=1;
                }
                res.setText(counter+"");
            }
        });
    }
}