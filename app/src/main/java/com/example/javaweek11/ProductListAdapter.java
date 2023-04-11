package com.example.javaweek11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.ArrayList;

public class ProductListAdapter extends RecyclerView.Adapter<ProductViewHolder> {


    private Context context;

    private ArrayList<Product> products = new ArrayList<>();

    public ProductListAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductViewHolder(LayoutInflater.from(context).inflate(R.layout.productview, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        holder.ProductName.setText(products.get(position).getName());
        holder.ProductInfo.setText(products.get(position).getInfo());
        holder.editProduct.setText(products.get(position).getName());
        holder.editProductInformation.setText(products.get(position).getInfo());

        holder.removeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                ProductStorage.getInstance().removeProduct(products.get(pos).getId());
                notifyItemRemoved(pos);
            }
        });

        holder.editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if(holder.editProduct.getVisibility() == View.VISIBLE){
                    Product product = ProductStorage.getInstance().getProductById(pos);
                    product.setProductName(holder.editProduct.getText().toString());
                    product.setProductInformation(holder.editProductInformation.getText().toString());
                    holder.editProduct.setVisibility(View.GONE);
                    holder.editProductInformation.setVisibility(View.GONE);
                    notifyDataSetChanged();
                }

                else{
                    holder.editProduct.setVisibility(View.VISIBLE);
                    holder.editProductInformation.setVisibility(View.VISIBLE);
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }


}
