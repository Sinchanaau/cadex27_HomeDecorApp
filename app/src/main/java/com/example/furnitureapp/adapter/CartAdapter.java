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
import com.example.furnitureapp.activity_cart;
import com.example.furnitureapp.model.Cart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ProductViewHolder>{
    Context context;
    List<Cart> cartList;

    public CartAdapter(Context context, List<Cart> cartList) {
        this.context = context;
        this.cartList = cartList;
    }

    @NonNull
    @Override
    public CartAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_cart_item,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ProductViewHolder holder, int position) {
        Cart item=cartList.get(position);
        holder.pimage.setImageResource(cartList.get(position).getImagedata());
        holder.p_price.setText(cartList.get(position).getProdprice());
        holder.pname.setText(cartList.get(position).getProdname());
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }
    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView pimage;
        TextView pname,p_price;
        public ProductViewHolder(@NonNull View itemView){
            super(itemView);
            pimage=itemView.findViewById(R.id.furniture1);
            pname=itemView.findViewById(R.id.furniture_name);
            p_price=itemView.findViewById(R.id.furniture_price);
        }
    }
}
