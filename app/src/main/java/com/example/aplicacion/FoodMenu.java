package com.example.aplicacion;

import android.content.Intent;
import android.os.Bundle;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;

public class FoodMenu extends AppCompatActivity {
    private int tarjeta = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CardView cvFonda = findViewById(R.id.cVm1);
        CardView cvPizza = findViewById(R.id.cVm2);
        CardView cvBebida = findViewById(R.id.cVm3);
        CardView cvRepo = findViewById(R.id.cVm4);
        cvFonda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarjeta = 1;
                openAct(tarjeta);
            }
        });
        cvPizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarjeta = 2;
                openAct(tarjeta);
            }
        });
        cvBebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarjeta = 3;
                openAct(tarjeta);
            }
        });
        cvRepo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tarjeta = 4;
                openAct(tarjeta);
            }
        });

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
    public void openAct(Integer op){
        Intent intent = new Intent(this, FondasMenu.class);

        if (op == 1){
            startActivity(intent);
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

}
