package com.example.aplicacion;

import com.google.firebase.database.FirebaseDatabase;

public class MyFirebase extends android.app.Application{
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}