package com.example.furnitureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.furnitureapp.adapter.CartAdapter;
import com.example.furnitureapp.model.Cart;

import java.util.ArrayList;
import java.util.List;

public class activity_cart extends AppCompatActivity {

    RecyclerView cartrecycler;
    CartAdapter cartAdapter;
    ImageView image;
    TextView name,price;
    Button buynow;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        buynow=findViewById(R.id.button);
        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_cart.this, activity_order.class));
            }
        });
        List<Cart> cartList = new ArrayList<>();
        cartList.add(new Cart("Classic Chair", "$57.00", R.drawable.f1));
        cartList.add(new Cart("Classic Chair", "$57.00", R.drawable.f2));
        cartList.add(new Cart("Classic Chair", "$57.00", R.drawable.f3));
        setcartrecycler(cartList);
    }
    private void setcartrecycler(List<Cart> cartList){
        cartrecycler=findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        cartrecycler.setLayoutManager(layoutManager);
        cartAdapter=new CartAdapter(this,cartList);
        cartrecycler.setAdapter(cartAdapter);
    }

}