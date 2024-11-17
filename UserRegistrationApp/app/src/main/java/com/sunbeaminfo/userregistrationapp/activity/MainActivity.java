package com.sunbeaminfo.userregistrationapp.activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.sunbeaminfo.userregistrationapp.R;
import com.sunbeaminfo.userregistrationapp.adapter.ProductAdapter;
import com.sunbeaminfo.userregistrationapp.entity.Product;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Toolbar toolBar;
    ListView listView;
    List<Product> productList;
    ProductAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolBar=findViewById(R.id.toolBar);
        listView=findViewById(R.id.listView);
        setSupportActionBar(toolBar);

    }
}