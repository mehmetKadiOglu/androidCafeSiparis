package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class TableAdd implements firebaseAddData {

    @Override
    public void firebaseAdd(HashMap MapHash) {
        //Username cafe ıd
        // Password masa no
        DatabaseReference mysef = FirebaseDatabase.getInstance().getReference(MapHash.get("CafeId").toString()).child("tables").push();
        mysef.child("Number").setValue(MapHash.get("EklencekVeri").toString()); // masa no
        mysef.child("voteTime").setValue(0); // oy kullanma zamanı. Her 4dkda bir oy kullanılabilir.


    }
}
