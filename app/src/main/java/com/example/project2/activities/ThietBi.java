package com.example.project2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Window;

import com.example.project2.R;

import com.example.project2.adapter.ThietBiAdapter;
import com.example.project2.model.DonHang;

import java.util.ArrayList;
import java.util.List;

import static com.example.project2.GeneralProperties.donHangList;

public class ThietBi extends AppCompatActivity {
    RecyclerView recyclerView;
    ThietBiAdapter thietBiAdapter;
    List<DonHang> listDH;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thiet_bi);
        Intent intent = getIntent();
        final String idHoaDon = intent.getStringExtra("mahoadon");
        listDH = new ArrayList<>();
        Log.d("a", "onCreate: "+donHangList.toString());
        for(int i =0;i<donHangList.size();i++){
            if(idHoaDon.contains(donHangList.get(i).getMaHD())){
                listDH.add(donHangList.get(i));
            }
        }
        Log.d("a", "onCreate: "+listDH.toString());
        recyclerView = findViewById(R.id.rv_thiet_bi);
        thietBiAdapter = new ThietBiAdapter(listDH,this);
        Log.d("a", "onCreate: "+thietBiAdapter.toString());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(thietBiAdapter);

    }


}
