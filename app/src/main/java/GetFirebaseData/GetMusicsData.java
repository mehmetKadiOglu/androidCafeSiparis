package GetFirebaseData;



import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;

import Adapters.Fasat;
import FirebaseDataList.FirebaseList;
import IslemlerGenel.FirebaseBoolean;

public class GetMusicsData implements getFirebaseData {


    public void firbaseData(String CafeId) {
        FirebaseList.getMusicList().setVote();
        FirebaseList.getMusicList().setFirebaseKey();
        FirebaseList.getMusicList().setValueName();

        FirebaseBoolean.setMusicsFonksiyonaGirisKontrol(true);

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(CafeId).child("musics");
        myref.orderByChild("vote").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                FirebaseList.getMusicList().listClear();

                for (DataSnapshot key : dataSnapshot.getChildren()) {
                    FirebaseList.getMusicList().setValueName(key.child("musicName").getValue().toString());
                    FirebaseList.getMusicList().setFirebaseKey(key.getKey());
                    try {
                        // muzik adı oydan önce eklendiğinden, vote değeri null gelme durumu var.
                        FirebaseList.getMusicList().setVote(Integer.parseInt(key.child("vote").getValue().toString()));
                    } catch (Exception e) {
                    }
                    //
                }

                // Collections.reverse ile müzik listesi büyükten küçüğe sıralanmış oluyor.
                Collections.reverse(FirebaseList.getMusicList().getVote());
                Collections.reverse(FirebaseList.getMusicList().getFirebaseKey());
                Collections.reverse(FirebaseList.getMusicList().getValueName());
                FirebaseBoolean.setMusicsFonksiyonaGirisKontrol(false);
               if ( Fasat.getNesne().getmusicAdapter() != null ) // eğer admin girişi yapılmiş ve ilk yüklemenin ardından 2. yükleme geliyorsa gelen data setleniyor.
                {
                    Fasat.getNesne().getmusicAdapter().notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
}
