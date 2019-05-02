package IslemlerGenel.Thread;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.view.Display;

import net.steamcrafted.loadtoast.LoadToast;

public class ToastLoad extends AppCompatActivity {

    private LoadToast lt;
    private  Context context;
    public ToastLoad(Context context, Display display)
    {
        this.setContext(context);
        this.defineLt(display);
    }

    protected Context getContext() {
        return context;
    }

    protected void setContext(Context context) {
        this.context = context;
    }

    private void defineLt(Display display)  // LoadToast tanımlama
    {

        lt = new LoadToast(this.getContext());
        lt.setTranslationY(this.findHeight(display) / 2);
        lt.setTextColor(Color.WHITE).setBackgroundColor(Color.GRAY).setProgressColor(Color.WHITE);

    }
    protected void showLt(String text)
    {

        lt.setText(text);
        lt.show();
    }
    protected void hideLt()
    {
        lt.hide();
    }
    private int findHeight(Display display) // LoadToast'ın telefon ekranında tam ortada gözükmesi icin telefonun height' özelliği bulunuyor
    {
        Point size = new Point();
        display.getSize(size);
        int height = size.y;
        return height;
    }
}
