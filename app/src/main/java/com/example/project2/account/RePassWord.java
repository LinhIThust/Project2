package com.example.project2.account;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.project2.R;

public class RePassWord extends AppCompatActivity implements View.OnClickListener {
    Button btOk;
    EditText edPhone,edPass,edRePass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_pass_word);
        initView();
        setUI();
    }
    public void initView(){
        btOk = findViewById(R.id.bt_re_ok);

        edPhone =findViewById(R.id.ed_re_phone);
        edPass = findViewById(R.id.ed_re_pass);
        edRePass = findViewById(R.id.ed_pass_sign_up);
    }
    public  void setUI(){
        btOk.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.bt_re_ok){
            startActivity(new Intent(RePassWord.this,Login.class));
        }
    }
}
