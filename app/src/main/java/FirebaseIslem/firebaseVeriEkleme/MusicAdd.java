package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MusicAdd implements firebaseAddData {
    @Override
    public void firebaseAdd(HashMap MapHash) {
        //Username cafe id
        //Password music name
        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(MapHash.get("CafeId").toString()).child("musics").push();
        myref.child("musicName").setValue(MapHash.get("EklencekVeri").toString());
        myref.child("vote").setValue(0);

    }
}
