package com.example.project2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.example.project2.R;
import com.example.project2.adapter.BoLocAdapter;
import com.example.project2.model.LichSuThay;

import java.util.ArrayList;
import java.util.List;

import static com.example.project2.GeneralProperties.hanDungKangaroo;
import static com.example.project2.GeneralProperties.lichSuThayList;

public class HienThiBoLoc extends AppCompatActivity {
    private RecyclerView rvBoLoc;
    private BoLocAdapter boLocAdapter;
    private List<String> thuTu;
    private List<String> ngayThay;
    private List<LichSuThay> lichSuThays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hien_thi_bo_loc);
        thuTu = new ArrayList<>();
        ngayThay = new ArrayList<>();
        lichSuThays = new ArrayList<>();
        Intent intent = getIntent();
        String hangSp = intent.getStringExtra("hang");
        String maHD = intent.getStringExtra("maHD");
        rvBoLoc = findViewById(R.id.rv_bo_loc);

        int n = lichSuThayList.size();
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                if (lichSuThayList.get(i).getMaHD().contains(maHD)) {
                    thuTu = fitlerData(lichSuThayList.get(i).getThuTuBoLoc());
                    ngayThay = fitlerData(lichSuThayList.get(i).getNgayThayGanNhat());
                    for (int j = 0; j < thuTu.size(); j++) {
                        lichSuThays.add(new LichSuThay(
                                thuTu.get(j),
                                ngayThay.get(j),
                                hanDungKangaroo.get(Integer.parseInt(thuTu.get(j)) - 1)
                        ));
                    }
                }
            }
        }
        boLocAdapter = new BoLocAdapter(lichSuThays);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        rvBoLoc.setLayoutManager(gridLayoutManager);
        rvBoLoc.setAdapter(boLocAdapter);
    }

    public List<String> fitlerData(String s) {
        List<String> list = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ',') {
                list.add(s.substring(k, i));
                k = i + 1;
            }
        }
        list.add(s.substring(k));
        return list;
    }

}
