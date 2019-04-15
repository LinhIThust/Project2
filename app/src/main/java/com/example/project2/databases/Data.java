package com.example.project2.databases;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.project2.model.DonHang;
import com.example.project2.model.LichSuThay;
import com.example.project2.model.SanPham;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


import static com.example.project2.GeneralProperties.databaseHoaDon;
import static com.example.project2.GeneralProperties.databaseLichSuThay;
import static com.example.project2.GeneralProperties.databaseSanPham;

public class Data {
    public static List<SanPham> getDataSP() {
        final List<SanPham> listSP = new ArrayList<>();
        databaseSanPham.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listSP.clear();
                Log.d("a", "onDataChange: " + dataSnapshot);
                for (DataSnapshot sanPhamSnapshot : dataSnapshot.getChildren()) {
                    SanPham sanPham = sanPhamSnapshot.getValue(SanPham.class);
                    listSP.add(sanPham);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("a", "onCancelled: " + databaseError.getDetails());
            }
        });
        return listSP;
    }


    public static List<DonHang> getDataDonHang() {
        final List<DonHang> donHangList = new ArrayList<>();
        databaseHoaDon.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                donHangList.clear();
                for (DataSnapshot hoaDonSnapshot : dataSnapshot.getChildren()) {
                    DonHang donHang = hoaDonSnapshot.getValue(DonHang.class);
                    donHangList.add(donHang);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("a", "onCancelled: " + databaseError.getDetails());
            }
        });
        return donHangList;
    }

    public static List<LichSuThay> getLichSuThay() {
        final List<LichSuThay> lichSuThays = new ArrayList<>();
        databaseLichSuThay.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                lichSuThays.clear();
                for (DataSnapshot hoaDonSnapshot : dataSnapshot.getChildren()) {
                    LichSuThay lichSuThay = hoaDonSnapshot.getValue(LichSuThay.class);
                    lichSuThays.add(lichSuThay);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("aaa", "onCreate: " + databaseError.getDetails());
            }
        });
        return lichSuThays;
    }
}
