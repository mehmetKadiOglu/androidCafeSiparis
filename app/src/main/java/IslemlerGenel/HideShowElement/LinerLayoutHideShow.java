package IslemlerGenel.HideShowElement;

import android.view.View;
import android.widget.LinearLayout;

public class LinerLayoutHideShow {

    public static void LinerLayoutGizle(LinearLayout linearLayout) {
        linearLayout.setVisibility(View.GONE);
    }

    public static void LinerLayoutGoster(LinearLayout linearLayout) {
        linearLayout.setVisibility(View.VISIBLE);
    }
}
