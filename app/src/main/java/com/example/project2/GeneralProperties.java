package com.example.project2;

import android.app.ProgressDialog;

import com.example.project2.model.SanPham;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class GeneralProperties {
    public static int indexKH = 0;
    public static final FirebaseAuth AUFIREBASE = FirebaseAuth.getInstance();
    public static final FirebaseDatabase FIREBASE_DATABASE = FirebaseDatabase.getInstance();

    //public  static  List<SanPham> listSanPham =new ArrayList<>();
   // public  static final DatabaseReference databaseKhachHang =FIREBASE_DATABASE.getReference("KhachHang");
    public  static final DatabaseReference databaseSanPham =FIREBASE_DATABASE.getReference("SanPham");

    private static final String TAG = "GeneralProperties";
    public static ProgressDialog PROGRESSDIALOG;
}

