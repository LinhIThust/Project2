package com.example.project2;

import android.app.ProgressDialog;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class GeneralProperties {
    public static final FirebaseAuth AUFIREBASE =FirebaseAuth.getInstance();
    public static final FirebaseDatabase FIREBASE_DATABASE = FirebaseDatabase.getInstance();
    private static final String TAG = "GeneralProperties";
    public static  ProgressDialog PROGRESSDIALOG;
}

