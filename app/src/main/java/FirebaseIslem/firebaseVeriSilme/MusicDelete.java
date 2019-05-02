package FirebaseIslem.firebaseVeriSilme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MusicDelete implements firebaseDeteleData {
    @Override
    public void firebaseDelete(HashMap MapHash) {

        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference(MapHash.get("CafeId").toString()).child("musics");
        myRef.child(MapHash.get("CafeId").toString()).removeValue();
    }
}
