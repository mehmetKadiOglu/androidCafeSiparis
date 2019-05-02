package Kullanici;

import GetFirebaseData.FirebaseData;
import GetFirebaseData.GetMenuData;
import GetFirebaseData.GetMusicsData;

public class Kullanici {
    private String CafeId;

    public String getCafeId() {
        return CafeId;
    }

    public void setCafeId(String cafeId) {
        CafeId = cafeId;
    }

    public void createList()
    {
        FirebaseData getData = new FirebaseData();
        getData.BringData(new GetMenuData(), this.getCafeId());
        getData.BringData(new GetMusicsData(), this.getCafeId()); // Kullanıcı nesnesi oluşturulduğu an müzikler firebaseden cekiliyor.
        // GetMucsData bir sınıf. Statik sınıf elemanlarını dolduruyor
    }
}
