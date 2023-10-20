package com.example.furnitureapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furnitureapp.R;
import com.example.furnitureapp.model.Products;
import com.example.furnitureapp.model.Products2;
import com.example.furnitureapp.product_description;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    Context context;
    List<Products> productsList;

    public ProductAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_category_item,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Products item=productsList.get(position);
        holder.prodImage.setImageResource(productsList.get(position).getImageUrl());
        holder.prodName.setText(productsList.get(position).getProductName());
        holder.prodPrice.setText(productsList.get(position).getProductPrice());
        holder.itemView.setOnClickListener(view -> {
            Intent intent=new Intent(context, product_description.class);
            intent.putExtra("imageUrl",item.getImageUrl());
            intent.putExtra("productName",item.getProductName());
            intent.putExtra("productprice",item.getProductPrice());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView prodImage;
        TextView prodName,prodPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            prodImage=itemView.findViewById(R.id.furniture1);
            prodName=itemView.findViewById(R.id.furniture_name);
            prodPrice=itemView.findViewById(R.id.furniture_price);
        }
    }
}
