package FirebaseIslem.firebaseVeriSilme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MenuDelete {

    public void firebaseDelete(String CafeId, String MenuKatagori, String SilincekVeri) {
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(CafeId).child("Menu").child(MenuKatagori);
        myref.child(SilincekVeri).removeValue();
    }
}
