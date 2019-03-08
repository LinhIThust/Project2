package com.example.project2.activities;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.project2.R;
import com.example.project2.account.Login;
import com.example.project2.model.KhachHang;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;


import static com.example.project2.GeneralProperties.AUFIREBASE;
import static com.example.project2.GeneralProperties.databaseKhachHang;


public class Home extends AppCompatActivity implements View.OnClickListener {
    TextView tvNameUser, tvSDT, tvDiaChi, tvHoaDon;
    Button btThietBi, btCuaHang, btHoTro, btDangXuat;
    String maHoaDon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        setEvent();
    }
    @Override
    public void onBackPressed(){
        finish();
    }
    private void initView() {
        tvNameUser = findViewById(R.id.tv_name);
        tvSDT = findViewById(R.id.tv_sdt);
        tvDiaChi = findViewById(R.id.tv_dia_chi);
        tvHoaDon = findViewById(R.id.tv_hoa_don);


        btThietBi = findViewById(R.id.bt_thiet_bi);
        btCuaHang = findViewById(R.id.bt_cua_hang);
        btHoTro = findViewById(R.id.bt_ho_tro);
        btDangXuat = findViewById(R.id.bt_dang_xuat);
    }

    private void setEvent() {
        btThietBi.setOnClickListener(this);
        btCuaHang.setOnClickListener(this);
        btHoTro.setOnClickListener(this);
        btDangXuat.setOnClickListener(this);

        databaseKhachHang.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot khachHangSnapshot : dataSnapshot.getChildren()) {
                    KhachHang khachHangNow = khachHangSnapshot.getValue(KhachHang.class);
                    if (khachHangNow.getSdtKH().equals(AUFIREBASE.getCurrentUser().getEmail())) {
                        tvNameUser.append(khachHangNow.getNameKH());
                        tvSDT.append(khachHangNow.getSdtKH().replace("@gmail.com", ""));
                        tvDiaChi.append(khachHangNow.getDiaChiKH());
                        maHoaDon = khachHangNow.getMaDonHang();
                        tvHoaDon.append(maHoaDon);
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_thiet_bi:
                Intent intentThietBi = new Intent(Home.this, ThietBi.class);
                intentThietBi.putExtra("mahoadon", maHoaDon);
                startActivity(intentThietBi);
                break;
            case R.id.bt_cua_hang:
                startActivity(new Intent(Home.this, CuaHang.class));
                break;
            case R.id.bt_ho_tro:
                Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/cuahangquanglinh"));
                startActivity(Getintent);

                break;
            case R.id.bt_dang_xuat:
                AUFIREBASE.signOut();
                startActivity(new Intent(Home.this, Login.class));
                break;
        }

    }

}
