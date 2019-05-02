package IslemlerGenel.HideShowElement;

import android.support.constraint.ConstraintLayout;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class HideShow {

    public void hide(Button button){ButtonHideShow.ButtonGizle(button);}
    public void hide(LinearLayout linearLayout){LinerLayoutHideShow.LinerLayoutGizle(linearLayout);}
    public void hide(ConstraintLayout constraintLayout){ConstraintLayoutHideShow.ConstraintLayoutGizle(constraintLayout);}
    public void hide(RelativeLayout relativeLayout){RelativLayoutHideShow.RelativLayoutGizle(relativeLayout);}

    public void show(Button button){ButtonHideShow.ButtonGoster(button);}
    public void show(LinearLayout linearLayout){LinerLayoutHideShow.LinerLayoutGoster(linearLayout);}
    public void show(ConstraintLayout constraintLayout){ConstraintLayoutHideShow.ConstraintLayoutGoster(constraintLayout);}
    public void show(RelativeLayout relativeLayout){RelativLayoutHideShow.RelativLayoutGoster(relativeLayout);}
}
