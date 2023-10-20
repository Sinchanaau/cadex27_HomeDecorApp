package com.example.furnitureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.furnitureapp.adapter.CartAdapter;
import com.example.furnitureapp.adapter.CategoryAdapter;
import com.example.furnitureapp.model.Category;

import java.util.ArrayList;
import java.util.List;

public class activity_wishlist extends AppCompatActivity {
    ImageView home,cart,profile;
    RecyclerView category;
    CategoryAdapter categoryAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishlist);
        home=findViewById(R.id.home);
        cart=findViewById(R.id.imageView5);
        profile=findViewById(R.id.imageView6);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_wishlist.this, Home_page.class));
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_wishlist.this, activity_cart.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity_wishlist.this, activity_profile.class));
            }
        });
        List<Category> categoryList=new ArrayList<>();
        categoryList.add(new Category("Tables","Home Decor",R.drawable.t4,R.drawable.homedecor));
        categoryList.add(new Category("Mirrors","Clocks",R.drawable.mirror1,R.drawable.clock1));
        categoryList.add(new Category("Chairs","Sofa",R.drawable.furniture1,R.drawable.f1));
        categoryList.add(new Category("Lights","Lamps",R.drawable.homedecor,R.drawable.homedecor));
        categoryList.add(new Category("Lights","Lamps",R.drawable.homedecor,R.drawable.homedecor));
        setCategory(categoryList);
    }
    private void setCategory(List<Category> categoryList){
        category=findViewById(R.id.categoryrecycle);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        category.setLayoutManager(layoutManager);
        categoryAdapter=new CategoryAdapter(this,categoryList);
        category.setAdapter(categoryAdapter);
    }
}