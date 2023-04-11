package com.example.javaweek11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;

public class productAddActivity extends AppCompatActivity {
    static Integer ID = 0;
    private EditText productName;

    private EditText productInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add);

        productName = findViewById(R.id.editProductName);
        productInfo = findViewById(R.id.editProductInfo);
    }

    public void addProduct(View view) {
        ProductStorage Storage = ProductStorage.getInstance();
        Product product = new Product(productName.getText().toString(), productInfo.getText().toString(), ID.toString());
        Storage.addProduct(product);
        ID++;
    }
}