package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class SiparisAdd implements firebaseAddData {
    @Override
    public void firebaseAdd(HashMap MapHash) {
        Date simdikiZaman = new Date();
        DateFormat df = new SimpleDateFormat("H:m");
        String saat = df.format(simdikiZaman);

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(MapHash.get("CafeId").toString()).child("siparisler").push();
        myref.child("siparisDurum").setValue(0);
        myref.child("adet").setValue(MapHash.get("adet").toString());
        myref.child("fiyat").setValue(MapHash.get("fiyat").toString());
        myref.child("masaId").setValue(MapHash.get("masaId").toString());
        myref.child("siparis").setValue(MapHash.get("siparis").toString());
        myref.child("tarih").setValue(saat);

    }
}
