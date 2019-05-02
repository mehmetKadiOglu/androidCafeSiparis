package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ChangeVote implements firebaseAddData {
        @Override
    public void firebaseAdd(HashMap hashMap) {
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(hashMap.get("CafeId").toString()).child("tables").child(hashMap.get("TableId").toString());
        myref.child("voteTime").setValue(hashMap.get("oyZamani").toString());
    }
}
