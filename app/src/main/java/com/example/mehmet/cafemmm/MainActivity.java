package com.example.mehmet.cafemmm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import Login.Login;
import Login.QrLogin;
import IslemlerGenel.CreateToast;
import IslemlerGenel.Thread.MusteriGirisThread;

public class MainActivity extends AppCompatActivity {

    private Button qrButton, cafeSıngIButton;
    private TextView sonucMetin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Activity activity = this;

        CreateToast.setContext(this);

        sonucMetin = (TextView) findViewById(R.id.sonucBaslik);
        qrButton = (Button) findViewById(R.id.qrImageButton);
        cafeSıngIButton = (Button) findViewById(R.id.cafeSignInButton);

       qrButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Bu activity içinde çalıştırıyoruz.
                IntentIntegrator integrator = new IntentIntegrator(activity);
                //Sadece qr kod okumasını istiyoruz
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Masanızdaki kodu taratın");
                //telefonun kendi kamerasını kullandırıcaz
                integrator.setCameraId(0);
                //okuduğunda 'beep' sesi çıkarır
                integrator.setBeepEnabled(false);
                //okunan barkodun image dosyasını kaydediyor
                integrator.setBarcodeImageEnabled(false);
                //scan başlatılıyor
                integrator.initiateScan();
            }
        });

        cafeSıngIButton.setOnClickListener(new View.OnClickListener() { // admin panelini acıyor
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, CafeSignln.class);
                startActivity(i);
            }
        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {

            } else {
                String[] idler = result.getContents().split("ü");

                MusteriGirisThread musteriGirisThread = new MusteriGirisThread(MainActivity.this, getWindowManager().getDefaultDisplay());

                Login login = new Login();
                login.login(new QrLogin(), idler[0], idler[1]);
                musteriGirisThread.threatBaslat(this);
            }
        }
    }
    public void yonlendir()
    {
        Intent i = new Intent(MainActivity.this, Customer.class);
        startActivity(i);
    }

}
