package IslemlerGenel.Thread;

import android.content.Context;
import android.view.Display;
import android.widget.Button;

import IslemlerGenel.FirebaseBoolean;
import IslemlerGenel.HideShowElement.ButtonlarHideShow;

public class AdminDataThread extends ToastLoad {
    public AdminDataThread(Context context, Display display) {
        super(context, display);
    }
    public void firebaseThread(Button button[]) // firebaseden gelen verilerin gecikmesini kontrol ediyor.
    {
        final ButtonlarHideShow hideShow = new ButtonlarHideShow();
        final Button buttonlar[] = button;

        hideShow.buttonlariGizle(buttonlar);
        this.showLt("Veriler Cekiliyor");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                while (FirebaseBoolean.getMenuFonksiyonaGirisKontrol()
                        ||
                        FirebaseBoolean.getTablesFonksiyonaGirisKontrol()
                        ||
                        FirebaseBoolean.getMusicsFonksiyonaGirisKontrol()
                        ) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                runOnUiThread(new Runnable() {
                    public void run() {
                        hideLt();
                        hideShow.buttonlariGoster(buttonlar);
                    }
                });

            }
        });

        thread.start();
    }
}
