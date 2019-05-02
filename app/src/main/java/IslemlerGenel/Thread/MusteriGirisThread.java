package IslemlerGenel.Thread;

import android.content.Context;
import android.view.Display;

import com.example.mehmet.cafemmm.MainActivity;

import IslemlerGenel.CreateToast;
import IslemlerGenel.FirebaseBoolean;
import IslemlerGenel.Thread.ToastLoad;

public class MusteriGirisThread extends ToastLoad {


    public MusteriGirisThread(Context context, Display display) {
        super(context, display);
    }

    public void threatBaslat(MainActivity mainActivity) // firebase gecikmesini kontrol eden thread
    {
        this.showLt("Giris Yapılıyor");
        final MainActivity Main = mainActivity;

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
                        customerLogin(Main);


                    }
                });
            }
        });

        thread.start();
    }

    private void customerLogin(MainActivity mainActivity) // firebase admin giris sonucu
    {

        if (FirebaseBoolean.getLoginAddIslemSonucKontrol()) {
            mainActivity.yonlendir();
        } else {
            CreateToast.makeToast("Şifre veya kullanıcı adi yanlış");
        }

    }
}
