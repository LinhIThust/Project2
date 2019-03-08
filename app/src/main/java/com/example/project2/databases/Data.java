package com.example.project2.databases;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.project2.model.SanPham;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


import static com.example.project2.GeneralProperties.databaseSanPham;

public class Data {

    public static List<SanPham> getDataSP() {
        final List<SanPham> listSP = new ArrayList<>();
        databaseSanPham.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.d("a", "onDataChange: " + dataSnapshot);
                for (DataSnapshot sanPhamSnapshot : dataSnapshot.getChildren()) {
                    SanPham sanPham = sanPhamSnapshot.getValue(SanPham.class);
                    listSP.add(sanPham);
                }
                Log.d("a", "onDataChange: " + listSP.toString());
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("a", "onCancelled: " + databaseError.getDetails());
            }
        });
        return listSP;
    }

}
