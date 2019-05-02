package IslemlerGenel.HideShowElement;

import android.widget.Button;

public class ButtonlarHideShow {
    public void buttonlariGizle(Button button[])
    {
        HideShow hide = new HideShow();
        for(Button a : button)
        {
            hide.hide(a);
        }
    }

    public void buttonlariGoster(Button button[])
    {
        HideShow show = new HideShow();
        for(Button a : button)
        {
            show.show(a);
        }
    }
}
