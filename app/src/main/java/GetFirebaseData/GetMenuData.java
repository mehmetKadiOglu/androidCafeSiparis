package GetFirebaseData;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Iterator;

import Adapters.Fasat;
import FirebaseDataList.FirebaseList;
import IslemlerGenel.FirebaseBoolean;

public class GetMenuData implements getFirebaseData {
    @Override
    public void firbaseData(String CafeId) {

        FirebaseList.getMenuList().setMenu(); // menu hasmap listesi, new ile bellekte yer ayrımı yapılıyor
        FirebaseList.getMenuList().setMenuHashMapKey(); // Hasmap key listesi, new ile bellekye yer ayrımı yapılıyor

        FirebaseBoolean.setMenuFonksiyonaGirisKontrol(true);

        DatabaseReference myref = FirebaseDatabase.getInstance().getReference(CafeId).child("Menu");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                FirebaseList.getMenuList().clearMenuHashMapKey();
                Iterator<DataSnapshot> items = dataSnapshot.getChildren().iterator();
                while (items.hasNext())
                {
                    DataSnapshot key = items.next();
                    FirebaseList.getMenuList().setMenuHashMapKey(key.getKey()); // Hasmap key listesine, key eklemesi
                    FirebaseList.getMenuList().setMenuNewElement(key.getKey()); // Hasmap listesinde örnğin soğuk icecekler tanımlanıyor
                    FirebaseList.getMenuList().setUrunFiyatList(key.getKey()); // Hasmap listesinde örneğin soğuk icecekler icin, fiyat listesi tanımlanıyor(new)
                    FirebaseList.getMenuList().setUrunIsimList(key.getKey());// Hasmap listesinde örneğin soğuk icecekler icin, urun isim listesi tanımlanıyor(new)
                    FirebaseList.getMenuList().setUrunKeyList(key.getKey());

                    for (DataSnapshot key2 : key.getChildren())
                    {
                        FirebaseList.getMenuList().setUrunIsimList(key.getKey(), key2.child("Urun").getValue().toString());
                        try{
                            FirebaseList.getMenuList().setUrunFiyatList(key.getKey(), key2.child("Fiyat").getValue().toString());
                        }catch (Exception e){}

                        FirebaseList.getMenuList().setUrunKeyList(key.getKey(),key2.getKey());
                    }
                }
                FirebaseBoolean.setMenuFonksiyonaGirisKontrol(false);
                if( Fasat.getNesne().getgroupAdapter() != null )
                {
                    Fasat.getNesne().getgroupAdapter().notifyDataSetChanged();
                }
                if(Fasat.getNesne().getAdminMenuAdapter() != null)
                {
                    Fasat.getNesne().getAdminMenuAdapter().notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
