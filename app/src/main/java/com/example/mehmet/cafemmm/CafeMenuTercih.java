package com.example.mehmet.cafemmm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class CafeMenuTercih extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_menu_tercih);


    }
    public void menuGecis(View view) {

        Intent i = new Intent(CafeMenuTercih.this, CafeMenuGroup.class);
        startActivity(i);


    }


    public void MenuGrupEkle(View view) {

        Intent i = new Intent(CafeMenuTercih.this, CafeMenuFiyatDegistirme.class);
        startActivity(i);

    }
}
