package Kullanici;

public class Admin extends KullaniciA {

    private static Admin AdminObject;

    private Admin(){
    }

    public static Admin getObject()
    {
        if( AdminObject == null)
            AdminObject = new Admin();
        return AdminObject;
    }
}
