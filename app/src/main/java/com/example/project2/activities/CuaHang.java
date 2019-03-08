package com.example.project2.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.project2.R;
import com.example.project2.adapter.SanPhamAdapter;
import com.example.project2.model.SanPham;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static com.example.project2.GeneralProperties.databaseSanPham;
import static com.example.project2.databases.Data.getDataSP;

public class CuaHang extends AppCompatActivity {
    RecyclerView recyclerView;
    SanPhamAdapter sanPhamAdapter;
    List<SanPham> listSP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cua_hang);
        recyclerView = findViewById(R.id.rv_cua_hang);
        listSP = new ArrayList<>();

        sanPhamAdapter = new SanPhamAdapter(getDataSP());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(sanPhamAdapter);
    }
}
