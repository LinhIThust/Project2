package com.example.project2.activities;

        import android.app.AlarmManager;
        import android.app.PendingIntent;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.net.Uri;
        import android.support.annotation.NonNull;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.example.project2.Notification;
        import com.example.project2.R;
        import com.example.project2.account.Login;
        import com.example.project2.model.KhachHang;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.ValueEventListener;


        import java.util.Calendar;
        import static com.example.project2.GeneralProperties.AUFIREBASE;
        import static com.example.project2.GeneralProperties.checkLogOut;
        import static com.example.project2.GeneralProperties.databaseKhachHang;
        import static com.example.project2.GeneralProperties.donHangList;

        import static com.example.project2.GeneralProperties.lichSuThayList;
        import static com.example.project2.GeneralProperties.ngayThayBoLoc;
        import static com.example.project2.GeneralProperties.sanPhamList;

        import static com.example.project2.databases.Data.getDataDonHang;
        import static com.example.project2.databases.Data.getDataSP;
        import static com.example.project2.databases.Data.getLichSuThay;


public class Home extends AppCompatActivity implements View.OnClickListener {
    TextView tvNameUser, tvSDT, tvDiaChi, tvHoaDon;
    Button btThietBi, btCuaHang, btHoTro, btDangXuat;
    String maHoaDon;
    private static long back_pressed;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sanPhamList = getDataSP();
        donHangList = getDataDonHang();
        lichSuThayList = getLichSuThay();
        sharedPreferences = getSharedPreferences("test", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        initView();
        setEvent();


        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(Home.this, Notification.class);
        Log.d("a", "onClick: " + "ok");
        PendingIntent pendingIntent = PendingIntent.getService(
                Home.this,
                0,
                intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        Log.d("a", "onClick: " + "123");

        alarmManager.setRepeating(
                AlarmManager.RTC_WAKEUP,
                Calendar.getInstance().getTimeInMillis(),
                AlarmManager.INTERVAL_DAY,
                pendingIntent
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        int n = ngayThayBoLoc.size();
        Log.d("aa", "onResume: " + "da vao day:" + n);

        if (n > 0) {
            editor.putInt("soLuong", n);
            for (int i = 0; i < n; i++) {
                editor.putLong("time" + i, ngayThayBoLoc.get(i));
            }
            editor.commit();
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
                        tvNameUser.setText(khachHangNow.getNameKH());
                        tvSDT.setText(khachHangNow.getSdtKH().replace("@gmail.com", ""));
                        tvDiaChi.setText(khachHangNow.getDiaChiKH());
                        maHoaDon = khachHangNow.getMaDonHang();
                        tvHoaDon.setText(maHoaDon);
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
                checkLogOut = true;
                ngayThayBoLoc.clear();
                AUFIREBASE.signOut();
                startActivity(new Intent(Home.this, Login.class));
                break;
        }

    }

}
