package com.example.project2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.project2.account.Login;
import com.example.project2.adapter.SanPhamAdapter;
import com.example.project2.model.SanPham;

import java.util.ArrayList;
import java.util.List;

import static com.example.project2.GeneralProperties.AUFIREBASE;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    RecyclerView recyclerView;
    List<SanPham> listSanPham;
    SanPhamAdapter sanPhamAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_thietbi) {
        } else if (id == R.id.nav_muahang) {
           setView();
        } else if (id == R.id.nav_dichvu) {

        } else if (id == R.id.nav_hotro) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_dangxuat) {
            AUFIREBASE.signOut();
            startActivity(new Intent(MainActivity.this, Login.class));


        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void setView(){

        listSanPham = new ArrayList<>();
        SanPham s1 = new SanPham("kagaroo1","150$","https://www.upsieutoc.com/images/2019/03/01/kangaroo2.jpg");
        SanPham s2 = new SanPham("kagaroo2","250$","https://www.upsieutoc.com/images/2019/03/01/karofi2.png");
        SanPham s3 = new SanPham("kagaroo3","350$","https://www.upsieutoc.com/images/2019/03/01/karofi.jpg");
        SanPham s4 = new SanPham("kagaroo4","50$","https://www.upsieutoc.com/images/2019/03/01/karofi3.jpg");
        SanPham s5 = new SanPham("kagaroo11","10$","https://www.upsieutoc.com/images/2019/03/01/kangaroo1.jpg");
        SanPham s6 = new SanPham("kagaroo22","1505$","https://www.upsieutoc.com/images/2019/03/01/fuij.jpg");
        listSanPham.add(s1);
        listSanPham.add(s4);
        listSanPham.add(s3);
        listSanPham.add(s2);
        listSanPham.add(s5);
        listSanPham.add(s6);

        sanPhamAdapter = new SanPhamAdapter(listSanPham);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(sanPhamAdapter);
    }
}
