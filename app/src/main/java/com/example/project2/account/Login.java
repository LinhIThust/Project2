package com.example.project2.account;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.project2.activities.Home;
import com.example.project2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;

import static com.example.project2.GeneralProperties.AUFIREBASE;
import static com.example.project2.GeneralProperties.PROGRESSDIALOG;

public class Login extends AppCompatActivity implements View.OnClickListener {
    Button btLogin, btSupport, btCreate;
    EditText edPhone, edPass;
    TextView tvQuenPass;
    private static long back_pressed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = AUFIREBASE.getCurrentUser();
        if (currentUser != null) {
            Intent intent = new Intent(Login.this, Home.class);
            startActivity(intent);
            finish();
        } else {
            initView();
            setUI();
        }
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()) {
            this.finish();
        } else
            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }

    public void initView() {
        btLogin = findViewById(R.id.bt_login);
        tvQuenPass = findViewById(R.id.tv_quen_mk);
        tvQuenPass.setPaintFlags(tvQuenPass.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        btCreate = findViewById(R.id.bt_create);
        btSupport = findViewById(R.id.bt_support);

        edPass = findViewById(R.id.ed_pass_sign_up);
        edPhone = findViewById(R.id.ed_re_phone);


        PROGRESSDIALOG = new ProgressDialog(this);
    }

    public void setUI() {
        btLogin.setOnClickListener(this);
        tvQuenPass.setOnClickListener(this);
        btCreate.setOnClickListener(this);
        btSupport.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_login:
                String phone = edPhone.getText().toString().concat("@gmail.com");
                String pass = edPass.getText().toString();
                if (phone.length() < 11) {
                    Toast.makeText(Login.this, "Vui lòng điền số điện thoại!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(Login.this, "Vui lòng điền mật khẩu!", Toast.LENGTH_SHORT).show();
                    return;
                }
                PROGRESSDIALOG.setMessage("Vui lòng chờ!");
                PROGRESSDIALOG.show();
                AUFIREBASE.signInWithEmailAndPassword(phone, pass)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                PROGRESSDIALOG.hide();
                                if (!task.isSuccessful()) {
                                    Toast.makeText(Login.this, "Số điện thoại hoặc mật khẩu sai!", Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(Login.this, Home.class));
                                    finish();
                                }
                            }
                        });
                break;

            case R.id.tv_quen_mk:
                startActivity(new Intent(Login.this, RePassWord.class));
                break;

            case R.id.bt_create:
                startActivity(new Intent(Login.this, SignUp.class));
                break;

            case R.id.bt_support:
                Intent Getintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/cuahangquanglinh"));
                startActivity(Getintent);
                break;
        }

    }
}

