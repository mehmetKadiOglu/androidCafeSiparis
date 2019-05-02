package Kullanici;

public class Musteri extends KullaniciB {
    private static Musteri musteri;

    public static KullaniciB getObjeck() {
        //  olurda sayfalar arası geçiş olursa kullanıcı sınıfı tek olsun uğraşmayalım diye yapıldı.
        if (musteri == null)
            musteri = new Musteri();
        return musteri;
    }

}
