package com.example.project2.activities;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.project2.R;
import com.example.project2.adapter.SanPhamAdapter;
import static com.example.project2.GeneralProperties.sanPhamList;

public class CuaHang extends AppCompatActivity {
    RecyclerView recyclerView;
    SanPhamAdapter sanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cua_hang);
        recyclerView = findViewById(R.id.rv_cua_hang);
        sanPhamAdapter = new SanPhamAdapter(sanPhamList);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(sanPhamAdapter);

    }
}
