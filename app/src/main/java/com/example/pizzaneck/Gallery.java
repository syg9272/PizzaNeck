package com.example.pizzaneck;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.navigation.NavigationView;

import java.io.InputStream;

public class Gallery extends AppCompatActivity {

    LinearLayout album1_btn, album2_btn, album3_btn, album4_btn, album5_btn, album6_btn, album7_btn, album8_btn, album9_btn;

    DrawerLayout drawerLayout;
    NavigationView navView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gallery);
        setToolbar();

        album1_btn = (LinearLayout)findViewById(R.id.album1);
        album2_btn = (LinearLayout)findViewById(R.id.album2);
        album3_btn = (LinearLayout)findViewById(R.id.album3);
        album4_btn = (LinearLayout)findViewById(R.id.album4);
        album5_btn = (LinearLayout)findViewById(R.id.album5);
        album6_btn = (LinearLayout)findViewById(R.id.album6);
        album7_btn = (LinearLayout)findViewById(R.id.album7);
        album8_btn = (LinearLayout)findViewById(R.id.album8);
        album9_btn = (LinearLayout)findViewById(R.id.album9);

        album1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, Photo.class);
                startActivity(intent);
            }
        });

        album2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, Photo.class);
                startActivity(intent);
            }
        });

        album3_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, Photo.class);
                startActivity(intent);
            }
        });

        album4_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, Photo.class);
                startActivity(intent);
            }
        });

        album5_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, Photo.class);
                startActivity(intent);
            }
        });

        album6_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, Photo.class);
                startActivity(intent);
            }
        });

        album7_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, Photo.class);
                startActivity(intent);
            }
        });

        album8_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, Photo.class);
                startActivity(intent);
            }
        });

        album9_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Gallery.this, Photo.class);
                startActivity(intent);
            }
        });
    }

    /* ?????? ??? ???????????? ?????? ??????.
     * onCreate?????? ??????
     * ????????? ??? DrawerLayout drawerLayout; NavigationView navView; Toolbar toolbar; ?????? ??????
     */
    protected void setToolbar(){
        //?????? ??????
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);    //?????? title ?????????
        actionBar.setDisplayHomeAsUpEnabled(true);      //???????????? ?????? ??????. ??? ????????? ????????? ???????????? ??????
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu); //???????????? ?????? ????????? -> ?????? ????????? ??????


        drawerLayout = findViewById(R.id.drawer_layout);
        navView = findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                menuItem.setChecked(true);
                drawerLayout.closeDrawers();

                int id = menuItem.getItemId();

                if(id == R.id.home){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //???????????? ???????????? -> ??????????????? ???????????? ????????? ?????? ??????????????? ?????? ?????? ?????????.
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                else if(id == R.id.realtime){
                    Intent intent = new Intent(getApplicationContext(), Realtime.class);
                    startActivity(intent);
                }
                else if(id == R.id.gallery){
                    Intent intent = new Intent(getApplicationContext(), Gallery.class);
                    startActivity(intent);

                }
                else if(id == R.id.stretching){
                    Intent intent = new Intent(getApplicationContext(), Stretching.class);
                    startActivity(intent);
                }
                else if(id == R.id.graph){
                    Intent intent = new Intent(getApplicationContext(), Gallery.class);
                    startActivity(intent);
                }

                menuItem.setChecked(false);
                return true;
            }
        });
    }
    //?????? ????????? ?????? ?????? (????????????)
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.toolbar_option_btn, menu);
        return true;
    }

    //????????? ?????? ?????? ???
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            //????????????????????????
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            //????????????
            case R.id.setting:
                Intent intent = new Intent(getApplicationContext(), Setting.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    //??????????????? ??????????????? ??????????????? ?????? ??????
    @Override
    public void onBackPressed(){
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }
    }
}
