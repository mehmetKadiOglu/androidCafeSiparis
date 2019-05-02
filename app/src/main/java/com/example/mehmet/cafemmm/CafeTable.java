package com.example.mehmet.cafemmm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.HashMap;

import Adapters.Fasat;
import FirebaseDataList.FirebaseList;
import FirebaseIslem.firebaseVeriEkleme.TableAdd;
import Kullanici.Admin;

public class CafeTable extends AppCompatActivity {
    ListView tableList;
    EditText qrKod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_table);
        tanimla();
        Fasat.getNesne().tableAdapter(tableList, this);
        tableList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                qrKod.setText(Admin.getObject().getCafeId()+"ü"+FirebaseList.getTableList().getFirebaseKey(i));
            }
        });
    }
    public void tanimla()
    {
        tableList = findViewById(R.id.tableListId);
        qrKod = findViewById(R.id.MasaQrKod);
    }
    public HashMap<String, String> MapTanimlama(String EklenecekVeri) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("CafeId", Admin.getObject().getCafeId());
        hashMap.put("EklencekVeri", EklenecekVeri);
        return hashMap;
    }

    public void tableAdd(View view) {

        EditText tableName = findViewById(R.id.tableNameId);
        Admin.getObject().getProcess().firebaseAdd(new TableAdd(), MapTanimlama( tableName.getText().toString() ));
        tableName.setText("");
    }
}
