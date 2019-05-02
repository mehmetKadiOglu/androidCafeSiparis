package com.example.mehmet.cafemmm;

import android.app.Activity;
import android.app.Dialog;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Örnek kullanım:
 *
 View pView = LayoutInflater.from(this).inflate(R.layout.popup_change_user_name, null);
 final MyPopup myPopup = new MyPopup(this, pView, MyPopup.SM, MyPopup.WRAP_CONTENT, R.style.MyPopupTheme);
 Button cancelButton = pView.findViewById(R.id.cancelButton);
 cancelButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
myPopup.cancel();
}
});
 myPopup.show();
 *
 *
 *  Örnek style:
 *
 <style name="MyPopupTheme" parent="Theme.AppCompat.Light.NoActionBar">
 <item name="android:windowBackground">@android:color/transparent</item>
 <item name="android:windowIsFloating">true</item>
 <item name="android:backgroundDimEnabled">true</item>
 <item name="android:windowCloseOnTouchOutside">true</item>
 </style>
 *
 *  */
public class MyPopup {

    public static int MATCH_PARENT = WindowManager.LayoutParams.MATCH_PARENT;
    public static int WRAP_CONTENT = WindowManager.LayoutParams.WRAP_CONTENT;
    public static double XS = 0.80f;
    public static double SM = 0.90f;
    public static double MD = 1.00f;
    private static final String TAG = "MyPopup";
    private Activity activity;
    private int width;
    private int height;
    private Dialog dialog;

    private MyPopup(Activity activity) {
        this.activity = activity;
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        width = dm.widthPixels;
        height = dm.widthPixels;
    }

    public MyPopup(Activity activity, View view, int width, int height, int style) {
        this(activity);
        dialog = new Dialog(activity, style);
        dialog.setContentView(view);
        dialog.getWindow().setLayout(width, height);
    }

    public MyPopup(Activity activity, View view, double w, double h, int style) {
        this(activity);
        dialog = new Dialog(activity, style);
        dialog.setContentView(view);
        dialog.getWindow().setLayout((int)(width * w), (int)(height * h));
    }

    public MyPopup(Activity activity, View view, double w, int height, int style) {
        this(activity);
        dialog = new Dialog(activity, style);
        dialog.setContentView(view);
        dialog.getWindow().setLayout((int)(width * w), height);
    }

    public MyPopup(Activity activity, View view, int width, double h, int style) {
        this(activity);
        dialog = new Dialog(activity, style);
        dialog.setContentView(view);
        dialog.getWindow().setLayout(width, (int)(height * h));
    }



    public void show() {
        if(dialog != null){dialog.show();}
    }

    public void cancel() {
        if(dialog != null){dialog.cancel();};
    }

}