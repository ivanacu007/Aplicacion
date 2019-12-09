package com.example.aplicacion;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.view.inputmethod.InputMethodManager;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ViewPager vp;
    private int tarjeta = 0;
    private FlipperLayout flipperLayout;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int img [] = {R.drawable.hamburguer, R.drawable.excavadora, R.drawable.cake, R.drawable.promo, R.drawable.monta, R.drawable.monta2};

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        setActionBarTitle("Aplicacion");
        flipperLayout = findViewById(R.id.flipper);
        iniciarFirebase();

        for(int i = 0; i < img.length; i++){
            FlipperView flipperView = new FlipperView(getBaseContext());
            flipperView.setImageDrawable(img[i]);
            flipperLayout.addFlipperView(flipperView);
        }


        CardView card = findViewById(R.id.cardFood);
        CardView cardServ = findViewById(R.id.cardServices);
        CardView cardTax = findViewById(R.id.cardTaxi);
        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarjeta = 1;
                openActivities(tarjeta);
            }
        });
        cardServ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarjeta = 2;
                openActivities(tarjeta);
            }
        });
        cardTax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarjeta = 3;
                openActivities(tarjeta);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    public void openActivities(Integer valor) {

        Intent intent = new Intent(this, FoodMenu.class);
        Intent intent2 = new Intent(this, ServicesMenu.class);
        Intent intent3 = new Intent(this, CarriageMenu.class);

        if(valor == 1){
            startActivity(intent);
        }
        if(valor == 2){
            startActivity(intent2);
        }
        if(valor == 3){
            startActivity(intent3);
        }

    }

    public void iniciarFirebase(){
        FirebaseApp.initializeApp(this);
        database = FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
    }
    public void closeKeyB(){
        try {
            InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.content);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//        // Set title
//        getSupportActionBar().setTitle("Aplicacion");
//    }
}
