package com.example.furnitureapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.furnitureapp.adapter.ProductAdapter2;
import com.example.furnitureapp.adapter.ProductAdapter;
import com.example.furnitureapp.model.Products;
import com.example.furnitureapp.model.Products2;
import java.util.ArrayList;
import java.util.List;
public class Home_page extends AppCompatActivity {
    RecyclerView prodItemrecycler,category2;
    ProductAdapter productAdapter1;
    ProductAdapter2 productAdapter2;
    ImageView home,wish,cart,profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        home=findViewById(R.id.home);
        wish=findViewById(R.id.imageView4);
        cart=findViewById(R.id.imageView5);
        profile=findViewById(R.id.imageView6);
        wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_page.this, activity_wishlist.class));
            }
        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_page.this, activity_cart.class));
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Home_page.this, activity_profile.class));
            }
        });

        List<Products> productsList=new ArrayList<>();
        productsList.add(new Products(1,"Classic Chair","$57.00",R.drawable.furniture1));
        productsList.add(new Products(2,"Resting Chair","$117.00",R.drawable.furniture2));
        productsList.add(new Products(3,"Outdoor Table","$157.00",R.drawable.furniture3));
        productsList.add(new Products(4,"Study Table","$199.00",R.drawable.furniture4));
        productsList.add(new Products(5,"Sofa Chair","$99.99",R.drawable.furniture5));

        setProdItemrecycler(productsList);

        List<Products2> products2List=new ArrayList<>();
        products2List.add(new Products2("Modern Sofa","$89.00",R.drawable.f1,1));
        products2List.add(new Products2("Modern Sofa","$89.00",R.drawable.f2,1));
        products2List.add(new Products2("Modern Sofa","$89.00",R.drawable.f3,1));
        products2List.add(new Products2("Modern Sofa","$89.00",R.drawable.f4,1));
        products2List.add(new Products2("Modern Sofa","$89.00",R.drawable.f5,1));
        setCategory2(products2List);
    }

    private void setProdItemrecycler(List<Products> productsList){
        prodItemrecycler =findViewById(R.id.productrecyclerview);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        prodItemrecycler.setLayoutManager(layoutManager);
        productAdapter1=new ProductAdapter(this,productsList);
        prodItemrecycler.setAdapter(productAdapter1);
    }
    private void setCategory2(List<Products2> products2List){
        category2 =findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        category2.setLayoutManager(layoutManager);
        productAdapter2=new ProductAdapter2(this,products2List);
        category2.setAdapter(productAdapter2);
    }


}