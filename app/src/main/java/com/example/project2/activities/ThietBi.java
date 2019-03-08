package com.example.project2.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project2.R;
import com.example.project2.model.DonHang;
import com.example.project2.model.SanPham;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import static com.example.project2.GeneralProperties.databaseHoaDon;
import static com.example.project2.GeneralProperties.databaseSanPham;

public class ThietBi extends AppCompatActivity {
    TextView tvMaHD, tvTenSP, tvNgayMua, tvNgayBaoHanh;
    ImageView ivSP;
    String tenThietBi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_thiet_bi);
        getSupportActionBar().hide();
        initView();
        Intent intent = getIntent();
        final String idHoaDon = intent.getStringExtra("mahoadon");
        Log.d("a", "onCreate: " + idHoaDon);
        databaseHoaDon.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot hoaDonSnapshot : dataSnapshot.getChildren()) {
                    DonHang donHang = hoaDonSnapshot.getValue(DonHang.class);
                    if (donHang.getMaHD().equals(idHoaDon)) {
                        tvMaHD.append(donHang.getMaHD());
                        tvNgayMua.append(donHang.getNgayMua());
                        tenThietBi = donHang.getThietBi();
                        tvTenSP.append(tenThietBi);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databaseSanPham.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot spSnapshot : dataSnapshot.getChildren()) {
                    SanPham sp = spSnapshot.getValue(SanPham.class);
                    if (sp.getNameSP().equals(tenThietBi)) {
                        Picasso.get().load(sp.getImageSP()).into(ivSP);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void initView() {
        tvMaHD = findViewById(R.id.tv_ma_giao_dich);
        tvTenSP = findViewById(R.id.tv_ten_sp);
        tvNgayBaoHanh = findViewById(R.id.tv_time_bh);
        tvNgayMua = findViewById(R.id.tv_time_mua);
        ivSP = findViewById(R.id.iv_thiet_bi);
    }

}
