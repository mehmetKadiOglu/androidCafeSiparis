package IslemlerGenel.HideShowElement;

import android.view.View;
import android.widget.RelativeLayout;

public class RelativLayoutHideShow {
    public static void RelativLayoutGizle(RelativeLayout relativeLayout) {
        relativeLayout.setVisibility(View.GONE);
    }

    public static void RelativLayoutGoster(RelativeLayout relativeLayout) {
        relativeLayout.setVisibility(View.VISIBLE);
    }
}
