package IslemlerGenel.Thread;

import android.content.Context;
import android.view.Display;

import com.example.mehmet.cafemmm.CafeSignln;

import IslemlerGenel.CreateToast;
import IslemlerGenel.FirebaseBoolean;

public class AdminGirisThread extends ToastLoad {
    public AdminGirisThread(Context context, Display display) {
        super(context, display);
    }

    public void threatBaslat(CafeSignln cafeSignln, char Secenek) // firebase gecikmesini kontrol eden thread
    {
        this.showLt("Giris Yapılıyor");
        final CafeSignln signlnCafe = cafeSignln;
        final char secenek = Secenek;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while (FirebaseBoolean.getLoginAddFonksiyonaGirisKontrol()) {
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        runOnUiThread(new Runnable() {
                            public void run() {
                                hideLt();
                                if (secenek == 'A')
                                    adminSonuc(signlnCafe);
                                else if (secenek == 'K')
                                    kayitSonuc();

                            }
                        });
                    }
                });

                thread.start();
            }
        });

        thread.start();
    }

    private void adminSonuc(CafeSignln signlnCafe) // firebase admin giris sonucu
    {

        if (FirebaseBoolean.getLoginAddIslemSonucKontrol()) {
            signlnCafe.yonlendirme();
        } else {
            CreateToast.makeToast("Şifre veya kullanıcı adi yanlış");
        }

    }

    private void kayitSonuc() {
        if (FirebaseBoolean.getLoginAddIslemSonucKontrol())
            CreateToast.makeToast("Kayıt Basarılı. Lütfen giris yapınız");
        else
            CreateToast.makeToast("Kayit olamadı");
    }
}
