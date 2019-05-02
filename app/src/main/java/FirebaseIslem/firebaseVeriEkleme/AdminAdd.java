package FirebaseIslem.firebaseVeriEkleme;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import Kullanici.Admin;
import IslemlerGenel.FirebaseBoolean;

public class AdminAdd {
    public static boolean fonksiyonaGirisKontrol;
    public static boolean girisKontrol;

    public void adminAdd(String UserName, String Password, final Activity activity) {

        FirebaseBoolean.setLoginAddFonksiyonaGirisKontrol(true);
        FirebaseBoolean.setLoginAddIslemSonucKontrol(false);

        final FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(UserName, Password)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                           Admin.getObject().setCafeId(auth.getUid());
                           Admin.getObject().createList();
                            FirebaseBoolean.setLoginAddIslemSonucKontrol(true);
                        }

                        FirebaseBoolean.setLoginAddFonksiyonaGirisKontrol(false);
                    }
                });

    }
}
