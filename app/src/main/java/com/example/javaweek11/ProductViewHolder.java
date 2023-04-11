package com.example.javaweek11;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    TextView ProductName, ProductInfo;

    ImageView removeImage, editImage;

    EditText editProduct, editProductInformation;




    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        ProductName = itemView.findViewById(R.id.textProduct);
        ProductInfo = itemView.findViewById(R.id.textInfo);
        removeImage = itemView.findViewById(R.id.deleteImageView);
        editImage = itemView.findViewById(R.id.editImageView);
        editProduct = itemView.findViewById(R.id.editProduct);
        editProductInformation = itemView.findViewById(R.id.editProductInfoEdit);
    }
}
