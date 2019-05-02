package FirebaseIslem.firebaseVeriSilme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class TableDelete implements firebaseDeteleData {

    @Override
    public void firebaseDelete(HashMap MapHash) {

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference(MapHash.get("CafeId").toString()).child("tables");
        myRef.child(MapHash.get("SilincekVeri").toString()).removeValue();
    }
}
