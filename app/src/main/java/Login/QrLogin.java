package Login;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import Kullanici.Musteri;
import IslemlerGenel.FirebaseBoolean;

public class QrLogin implements QrLoginSystem {
    private String IdMasa;
    private String CafeId;
    @Override
    public void login(final String cafeId, String MasaID) {
        FirebaseBoolean.setLoginAddFonksiyonaGirisKontrol(true);
        FirebaseBoolean.setLoginAddIslemSonucKontrol(false);
        this.IdMasa = MasaID;
        this.CafeId = cafeId;

        Query query = FirebaseDatabase.getInstance().getReference(CafeId).child("tables");
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot key : dataSnapshot.getChildren())

                if(key.getKey().equals(IdMasa))
                {
                    FirebaseBoolean.setLoginAddIslemSonucKontrol(true);
                    Musteri.getObjeck().setOyTarihi(key.child("voteTime").getValue().toString());
                    Musteri.getObjeck().setCafeId(CafeId);
                    Musteri.getObjeck().setTableId(IdMasa);
                    Musteri.getObjeck().createList();
                }
                FirebaseBoolean.setLoginAddFonksiyonaGirisKontrol(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
