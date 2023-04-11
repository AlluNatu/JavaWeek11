package com.example.javaweek11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;

import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    private ProductStorage storage;

    private RecyclerView recyclerView;

    private ProductListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = ProductStorage.getInstance();

        recyclerView = findViewById(R.id.productRV);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductListAdapter(getApplicationContext(), storage.getProducts());
        recyclerView.setAdapter(adapter);
    }

    public void Alphabetic(View View){
        Collections.sort(ProductStorage.getInstance().getProducts(), Product.productComparatorAlpabet);
        adapter.notifyDataSetChanged();
    }

    public void IDcompare(View View){
        Collections.sort(ProductStorage.getInstance().getProducts(), Product.productComparatorID);
        adapter.notifyDataSetChanged();
    }


    public void switchToProductAdd(View view) {
        Intent intent = new Intent(this, productAddActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}