package IslemlerGenel.HideShowElement;

import android.support.constraint.ConstraintLayout;
import android.view.View;

public class ConstraintLayoutHideShow {

    public static void ConstraintLayoutGizle(ConstraintLayout constraintLayout)
    {
        constraintLayout.setVisibility(View.GONE);
    }
    public static void ConstraintLayoutGoster(ConstraintLayout constraintLayout)
    {
        constraintLayout.setVisibility(View.VISIBLE);
    }
}
