package com.example.furnitureapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.furnitureapp.R;
import com.example.furnitureapp.model.Products2;
import com.example.furnitureapp.product_description;
import com.example.furnitureapp.product_description2;

import java.util.List;

public class ProductAdapter2  extends RecyclerView.Adapter<ProductAdapter2.ProductViewHolder>{
    Context context;
    List<Products2> products2List;
    public ProductAdapter2(Context context,List<Products2> products2List){
        this.context=context;
        this.products2List=products2List;
    }

    @NonNull
    @Override
    public ProductAdapter2.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_category2,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter2.ProductViewHolder holder, int position) {
        Products2 item=products2List.get(position);
        holder.productimage.setImageResource(products2List.get(position).getImage());
        holder.prodName.setText(products2List.get(position).getProduct_name());
        holder.productprice.setText(products2List.get(position).getProduct_price());
        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(context, product_description2.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return products2List.size();
    }
    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView productimage;
        TextView prodName,productprice;
        public ProductViewHolder(@NonNull View itemView){
            super(itemView);
            productimage=itemView.findViewById(R.id.furniture1);
            prodName=itemView.findViewById(R.id.furniture_name);
            productprice=itemView.findViewById(R.id.furniture_price);
        }
    }
}
