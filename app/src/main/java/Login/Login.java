package Login;

import android.app.Activity;

public class Login {


    public void login(QrLoginSystem Qr, String CafeId, String MasaId)
    {
        Qr.login(CafeId, MasaId);
    }
    public void login(UserPasswordLoginSystem UserLogin, String UserName, String Password, Activity activity){

        UserLogin.login(UserName, Password, activity);
    }

}
