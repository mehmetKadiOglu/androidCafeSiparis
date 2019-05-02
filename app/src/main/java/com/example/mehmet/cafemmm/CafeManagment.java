package com.example.mehmet.cafemmm;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import net.steamcrafted.loadtoast.LoadToast;

import IslemlerGenel.CreateToast;
import IslemlerGenel.FirebaseBoolean;
import IslemlerGenel.Thread.AdminDataThread;

public class CafeManagment extends AppCompatActivity {
    private Button backButton;
    private Button menuButton;
    private Button orderButton;
    private Button tableButton;
    private Button musicButton;
    LoadToast lt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_managment);


        CreateToast.setContext(this);
        this.defineElement();
        AdminDataThread adminDataThread = new AdminDataThread(CafeManagment.this, getWindowManager().getDefaultDisplay());
        adminDataThread.firebaseThread(butonDizisi());


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CafeManagment.this, CafeSignln.class);
                startActivity(i);
            }
        });

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CafeManagment.this, CafeMenuTercih.class);
                startActivity(i);
            }
        });

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

        tableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CafeManagment.this, CafeTable.class);
                startActivity(i);
            }
        });

        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CafeManagment.this, CafeMusic.class);
                startActivity(i);

            }
        });

    }

    public void defineElement() {
        backButton = (Button) findViewById(R.id.backButton);
        menuButton = (Button) findViewById(R.id.menuButton);
        orderButton = (Button) findViewById(R.id.orderButton);
        tableButton = (Button) findViewById(R.id.tableButton);
        musicButton = (Button) findViewById(R.id.musicButton);
    }
    public Button[] butonDizisi()
    {
        Button [] button = new Button[5];
        button[0] = backButton;
        button[1] = menuButton;
        button[2] = orderButton;
        button[3] = tableButton;
        button[4] = musicButton;
        return button;
    }
}
