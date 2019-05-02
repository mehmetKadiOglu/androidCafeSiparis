package FirebaseIslem.firebaseVeriEkleme;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import FirebaseDataList.FirebaseList;
import FirebaseIslem.FirebaseProcess;
import Kullanici.Musteri;
import IslemlerGenel.CreateToast;
import IslemlerGenel.HasmapHazirla;

public class OyKullan {
    public void oyKullan(int Index) {   // index muzik dizisindeki id. Bu id listieve tıklanmada gelicek

        Date simdikiZaman = new Date();
        System.out.println(simdikiZaman.toString());
        DateFormat df = new SimpleDateFormat("H:m");
        String sistemSaat = df.format(simdikiZaman);

        int fark = saatIslem(sistemSaat);
        if (fark>=4) // true olması oy kullanılabilir demektir.
        {
            int oy = FirebaseList.getMusicList().getVote(Index) + 1;
            String cafeId = Musteri.getObjeck().getCafeId();
            String musicId = FirebaseList.getMusicList().getFirebaseKey(Index);
            DatabaseReference myref = FirebaseDatabase.getInstance().getReference(cafeId).child("musics").child(musicId);
            myref.child("vote").setValue(oy);

            Musteri.getObjeck().setOyTarihi(sistemSaat);
            masaSaatDegis();

        } else
        {
            int oyKullanmaZamanı = 4-fark;
            CreateToast.makeToast(oyKullanmaZamanı+ " Dakka Sonra Oy Kullana Bilirsiniz");
        }


    }

    private void masaSaatDegis()
    {
        FirebaseProcess firebaseProcess = new FirebaseProcess();
        HasmapHazirla hasmapHazirla = new HasmapHazirla();

        HashMap hashMap = hasmapHazirla.oyverHashmap(Musteri.getObjeck().getCafeId(), Musteri.getObjeck().getTableId(), Musteri.getObjeck().getOyTarihi());

        firebaseProcess.firebaseAdd(new ChangeVote(), hashMap);
    }

    private int saatIslem(String saatSistem) {

        String[] sistemSaat = saatSistem.split(":"); //0 saat 1 değeri dakkadır
        String[] musteriSaat = Musteri.getObjeck().getOyTarihi().split(":"); //0 saat 1 değeri dakkadır

           return saatFarki(sistemSaatConvert(sistemSaat), musteriSaatConvert(musteriSaat));

    }

    private int saatFarki(int[] sistemSaatInteger, int[] musteriSaatInteger) {
        int saatFarki = ((sistemSaatInteger[0] - musteriSaatInteger[0]) * 60) + (sistemSaatInteger[1] - musteriSaatInteger[1]);
        return saatFarki;
    }

    private int[] musteriSaatConvert(String[] musteriSaat) {
        int[] musteriSaatInteger = new int[2];
        musteriSaatInteger[0] = Integer.parseInt(musteriSaat[0]);
        musteriSaatInteger[1] = Integer.parseInt(musteriSaat[1]);
        return musteriSaatInteger;
    }

    private int[] sistemSaatConvert(String[] sistemSaat) {
        int[] sistemSaatInteger = new int[2];
        sistemSaatInteger[0] = Integer.parseInt(sistemSaat[0]);
        sistemSaatInteger[1] = Integer.parseInt(sistemSaat[1]);
        return sistemSaatInteger;
    }
}
