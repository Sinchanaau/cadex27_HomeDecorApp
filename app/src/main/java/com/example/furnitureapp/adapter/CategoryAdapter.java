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
import com.example.furnitureapp.activity_homedecor;
import com.example.furnitureapp.activity_table;
import com.example.furnitureapp.model.Category;
import com.example.furnitureapp.product_description2;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ProductViewHolder> {
    Context context;
    List<Category> categoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.context = context;
        this.categoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.activity_category,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ProductViewHolder holder, int position) {
        Category item=categoryList.get(position);
        holder.img1.setImageResource(categoryList.get(position).getImage1());
        holder.text1.setText(categoryList.get(position).getFur_type1());
        holder.img2.setImageResource(categoryList.get(position).getImage2());
        holder.text2.setText(categoryList.get(position).getFur_typ2());
        holder.img1.setOnClickListener(view -> {
            Intent intent = new Intent(context, activity_table.class);
            context.startActivity(intent);
        });
        holder.img2.setOnClickListener(view -> {
            Intent intent = new Intent(context, activity_homedecor.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }
    public static final class ProductViewHolder extends RecyclerView.ViewHolder{
        ImageView img1,img2;
        TextView text1,text2;
        public ProductViewHolder(@NonNull View itemView){
            super(itemView);
            img1=itemView.findViewById(R.id.imageView13);
            text1=itemView.findViewById(R.id.textView17);
            img2=itemView.findViewById(R.id.imageView14);
            text2=itemView.findViewById(R.id.textView18);
        }
    }
}
