package com.example.mehmet.cafemmm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import FirebaseIslem.firebaseVeriEkleme.AdminAdd;
import IslemlerGenel.CreateToast;
import IslemlerGenel.Thread.AdminGirisThread;
import Login.Login;
import Login.UserNameLogin;

public class CafeSignln extends AppCompatActivity {
    private Button backButton;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cafe_sign_in);

        CreateToast.setContext(this);

        backButton = (Button) findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CafeSignln.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }


    public String[] kayitBilgi() // kayıt olmada EditText'lerden bilgileri alıp geriye dizi şeklinde gönderiyor.
    {
        EditText kullaniciAd = findViewById(R.id.kullaniciAdi);
        EditText password = findViewById(R.id.sifre);
        String[] veriler = new String[2];
        veriler[0] = kullaniciAd.getText().toString();
        veriler[1] = password.getText().toString();
        return veriler;
    }

    public void kayitOl(View view) // firebase kayit olma işlevi
    {

        String[] veriler = this.kayitBilgi();
        if (veriler[0].length() > 10 && veriler[1].length() >= 7) {

            AdminAdd add = new AdminAdd();
            add.adminAdd(this.kayitBilgi()[0], this.kayitBilgi()[1], this);

            AdminGirisThread adminGirisThread = new AdminGirisThread(CafeSignln.this, getWindowManager().getDefaultDisplay());
            adminGirisThread.threatBaslat(this, 'K');
        } else
            CreateToast.makeToast("Sifre ve kullanici adinizi uzun gir");
    }

    public String[] adminGirisBilgi() // admin girisinde EditText'lerden bilgileri alıp geriye dizi şeklinde gönderiyor.
    {
        EditText kullaniciAd = findViewById(R.id.kullaniciAdi);
        EditText password = findViewById(R.id.sifre);
        String[] veriler = new String[2];
        veriler[0] = kullaniciAd.getText().toString();
        veriler[1] = password.getText().toString();

        return veriler;
    }

    public void adminGiris(View view)// firebase admin giris işlevi
    {
        String[] veriler = this.adminGirisBilgi();
        if (veriler[0].length() > 10 && veriler[1].length() >= 7) {
            Login login = new Login();
            login.login(new UserNameLogin(), veriler[0], veriler[1], this);

            AdminGirisThread adminGirisThread = new AdminGirisThread(CafeSignln.this, getWindowManager().getDefaultDisplay());
            adminGirisThread.threatBaslat(this, 'A');
        } else
            CreateToast.makeToast("Sifre ve kullanici adinizi uzun gir");
    }

    public void yonlendirme() // firebase admin giris sonucu
    {
        Intent i = new Intent(CafeSignln.this, CafeManagment.class);
        startActivity(i);
        finish();
    }
}
