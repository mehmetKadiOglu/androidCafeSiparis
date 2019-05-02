package com.example.mehmet.cafemmm;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

import Adapters.Fasat;
import FirebaseDataList.FirebaseList;
import FirebaseIslem.firebaseVeriEkleme.ChangeMenuPrice;
import IslemlerGenel.CreateToast;
import Kullanici.Admin;

public class CafeMenuFiyatDegistirme extends AppCompatActivity {
    Spinner menuGruplari;
    ListView menuList;
    TextView adminSecilenÜrün;
    int spinnerSecim;
    int listSecim;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_menu_fiyat_degistirme);
        CreateToast.setContext(this);
        tanimla();
        Fasat.getNesne().customerGroupAdapter(menuGruplari, context);

        menuGruplari.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerSecim = i;
                Fasat.getNesne().adminMenu(menuList, context, spinnerSecim);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                listSecim = i;
                String urunAdi = FirebaseList.getMenuList().getUrunIsim(spinnerSecim, listSecim);
                String urunFiyat = FirebaseList.getMenuList().getUrunFiyat(spinnerSecim, listSecim);

                adminSecilenÜrün.setText(urunAdi+ " "+ urunFiyat);
            }
        });

    }
    public void tanimla() {
        menuGruplari = findViewById(R.id.MenuGruplari);
        menuList = findViewById(R.id.MenuList);
        adminSecilenÜrün = findViewById(R.id.AdminSecilenÜrün);
    }

    public void Onayla(View view)
    {
        HashMap hashMap = hasmapHazirla();

        Admin.getObject().getProcess().firebaseAdd(new ChangeMenuPrice(),hashMap );
    }
    public HashMap hasmapHazirla()
    {
        EditText yeniFiyat = findViewById(R.id.YeniFiyat);
        yeniFiyat.setText("");
        adminSecilenÜrün.setText("");

        //String CafeId, String MenuKatagori, String KatagoriId, String YeniDeger
        HashMap <String, String > hashMap = new HashMap<String, String>();
        hashMap.put("CafeId", Admin.getObject().getCafeId());
        hashMap.put("MenuKatagori", FirebaseList.getMenuList().getMenuHashMapKey(spinnerSecim));
        hashMap.put("KatagoriId" , FirebaseList.getMenuList().getUrunKey(spinnerSecim, listSecim));
        hashMap.put("YeniDeger", yeniFiyat.getText().toString());
        return hashMap;
    }
}
