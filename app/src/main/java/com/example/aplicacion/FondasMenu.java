package com.example.aplicacion;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class FondasMenu extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerFondasAdapter recyclerFondasAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fondas_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyFonda);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerFondasAdapter = new RecyclerFondasAdapter(getModel());
        recyclerView.setAdapter(recyclerFondasAdapter);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }
    public List<NegocioModel> getModel() {
        List<NegocioModel> models = new ArrayList<>();
        for(int x = 0; x<20; x++){
            models.add(new NegocioModel("Nombre X", "XX", "S", R.drawable.noimg, 0, 0, 1,1));
        }
        return models;
    }
    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

}
