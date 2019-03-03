package com.example.project2.account;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project2.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import static com.example.project2.GeneralProperties.AUFIREBASE;
import static com.example.project2.GeneralProperties.PROGRESSDIALOG;

public class SignUp extends AppCompatActivity {
    EditText edName, edPhone, edAddr, edPass, edRePass;
    Button btOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initView();
        setUI();
    }

    private void initView() {
        edName = findViewById(R.id.ed_name);
        edPhone = findViewById(R.id.ed_re_phone);
        edAddr = findViewById(R.id.ed_addr);
        edPass = findViewById(R.id.ed_pass_sign_up);
        edRePass = findViewById(R.id.ed_rep_pass_sign_up);
        btOk = findViewById(R.id.bt_ok);
        PROGRESSDIALOG =new ProgressDialog(this);

    }

    public void setUI(){
        btOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String name = edName.getText().toString();
                String phone = edPhone.getText().toString().concat("@gmail.com");
                String addres = edAddr.getText().toString();
                String pass = edPass.getText().toString();
                String rePass = edRePass.getText().toString();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(SignUp.this,"Vui lòng điền tên của bạn!",Toast.LENGTH_SHORT).show();;
                    return;
                }
                if(TextUtils.isEmpty(phone)){
                    Toast.makeText(SignUp.this,"Vui lòng điền sô điện thoại của bạn!",Toast.LENGTH_SHORT).show();;
                    return;
                }
                if(TextUtils.isEmpty(pass)){
                    Toast.makeText(SignUp.this,"Vui lòng điền mật khẩu của bạn!",Toast.LENGTH_SHORT).show();;
                    return;
                }
                if(TextUtils.isEmpty(rePass)){
                    Toast.makeText(SignUp.this,"Vui lòng điền nhập lại mật khẩu ở trên!",Toast.LENGTH_SHORT).show();;
                    return;
                }
                if(!pass.equals(rePass)){
                    Toast.makeText(SignUp.this,"Mật khẩu không khớp!",Toast.LENGTH_SHORT).show();;
                    return;
                }

                if(pass.length() <6){
                    Toast.makeText(SignUp.this,"Mật khẩu ít nhất 6 kí tự!",Toast.LENGTH_SHORT).show();;
                    return;
                }
                PROGRESSDIALOG.setMessage("Vui lòng chờ!");
                PROGRESSDIALOG.show();
                AUFIREBASE.createUserWithEmailAndPassword(phone, pass)
                        .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                PROGRESSDIALOG.hide();
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignUp.this, "Không Thành Công", Toast.LENGTH_SHORT).show();
                                } else {
                                    AUFIREBASE.signOut();
                                    startActivity(new Intent(SignUp.this, Login.class));
                                }
                            }
                        });
            }
        });
    }
}
