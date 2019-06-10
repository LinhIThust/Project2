package com.example.project2;

import android.app.ProgressDialog;


import com.example.project2.model.DonHang;
import com.example.project2.model.LichSuThay;
import com.example.project2.model.SanPham;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GeneralProperties {
    public static int indexKH = 0;
    public static boolean checkLogOut =false;
    public static final FirebaseAuth AUFIREBASE = FirebaseAuth.getInstance();
    public static final FirebaseDatabase FIREBASE_DATABASE = FirebaseDatabase.getInstance();

    public static final DatabaseReference databaseKhachHang = FIREBASE_DATABASE.getReference("KhachHang");
    public static final DatabaseReference databaseSanPham = FIREBASE_DATABASE.getReference("SanPham");
    public static final DatabaseReference databaseHoaDon = FIREBASE_DATABASE.getReference("HoaDon");
    public static  final DatabaseReference databaseLichSuThay = FIREBASE_DATABASE.getReference("LichSuThay");

    public static  List<SanPham> sanPhamList = new ArrayList<>();
    public static List<LichSuThay> lichSuThayList = new ArrayList<>();
    public static  List<DonHang> donHangList = new ArrayList<>();

    public static  List<String> hanDungKangaroo = Arrays.asList(new String[]{"3,6","6,9","9,12","24,36","17,18","12,16","23,24","10,12"});
    public static  List<String> hanDungKarofi = Arrays.asList(new String[]{"3,6","6,9","9,12","24,36","17,18","12,16","23,24","10,12"});

    public static  List<Long> ngayThayBoLoc = new ArrayList<>();
    public static ProgressDialog PROGRESSDIALOG;

}

