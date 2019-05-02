package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MenuAdd implements firebaseAddData {


    @Override
    public void firebaseAdd(HashMap MapHash) {
        String CafeId = MapHash.get("CafeId").toString();
        String MenuKatagori = MapHash.get("MenuKatagori").toString();
        String UrunAdi = MapHash.get("UrunAdi").toString();
        String Fiyat = MapHash.get("Fiyat").toString();

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(CafeId).child("Menu").child(MenuKatagori).push();
        myref.child("Urun").setValue(UrunAdi);
        myref.child("Fiyat").setValue(Fiyat);
    }
}
