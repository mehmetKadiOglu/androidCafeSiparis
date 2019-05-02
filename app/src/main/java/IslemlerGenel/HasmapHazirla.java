package IslemlerGenel;

import java.util.HashMap;

import Kullanici.Musteri;

public class HasmapHazirla {
    HashMap<String, String> hashMap;

    public HasmapHazirla() {
        hashMap = new HashMap<String, String>();
    }

    public HashMap oyverHashmap(String CafeId, String TableId, String oyZamani) {
        hashMap.put("CafeId", CafeId);
        hashMap.put("TableId", TableId);
        hashMap.put("oyZamani", oyZamani);
        return hashMap;
    }

    public HashMap SiparisHasmap(String siparisArray[], String adet) {


        hashMap.put("CafeId", Musteri.getObjeck().getCafeId());
        hashMap.put("adet", adet);
        hashMap.put("fiyat", siparisArray[1]);
        hashMap.put("masaId", Musteri.getObjeck().getTableId());
        hashMap.put("siparis", siparisArray[0]);

        return hashMap;
    }
}
