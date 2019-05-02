package GetFirebaseData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import Adapters.Fasat;
import FirebaseDataList.FirebaseList;
import IslemlerGenel.FirebaseBoolean;

public class GetTablesData implements getFirebaseData {


    public void firbaseData(String CafeId) {
        FirebaseList.getTableList().setFirebaseKey();
        FirebaseList.getTableList().setValueName();

        FirebaseBoolean.setTablesFonksiyonaGirisKontrol(true);

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference().child(CafeId).child("tables");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FirebaseList.getTableList().listClear();
                for (DataSnapshot key : dataSnapshot.getChildren()) {
                    FirebaseList.getTableList().setValueName(key.child("Number").getValue().toString()); // masa numarası.
                    FirebaseList.getTableList().setFirebaseKey(key.getKey()); // masa keyi
                }

                FirebaseBoolean.setTablesFonksiyonaGirisKontrol(false);

                if ( Fasat.getNesne().gettableAdapter() != null) //eğer admin girişi yapılmiş ve ilk yüklemenin ardından 2. yükleme geliyorsa gelen data setleniyor.
                    Fasat.getNesne().gettableAdapter().notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

