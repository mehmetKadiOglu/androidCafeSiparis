package com.example.mehmet.cafemmm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.HashMap;

import Adapters.Fasat;
import FirebaseIslem.firebaseVeriEkleme.MusicAdd;
import Kullanici.Admin;

public class CafeMusic extends AppCompatActivity {
    ListView musicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_music);

        Fasat.getNesne().musicAdapter((ListView)findViewById(R.id.musicListId), this);


    }


    public HashMap<String, String> MapTanimlama(String EklenecekVeri) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("CafeId", Admin.getObject().getCafeId());
        hashMap.put("EklencekVeri", EklenecekVeri);
        return hashMap;
    }

    public void muzikKayit(View view) {

        EditText musicName = findViewById(R.id.musicNameId);
        Admin.getObject().getProcess().firebaseAdd(new MusicAdd(), MapTanimlama(musicName.getText().toString()));
        musicName.setText("");
    }



}
