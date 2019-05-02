package FirebaseDataList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuList {
    private List<String> MenuHashMapKey;

    private HashMap<String, HashMap<String, List<String>>> Menu;

    private static MenuList ListMenu;
    private MenuList(){}
    public static MenuList getListMenu(){
        if ( ListMenu == null )
            ListMenu = new MenuList();
        return ListMenu;
    }

    public  void setMenuHashMapKey()
    {
        MenuHashMapKey = new ArrayList<String>();
    }
    public  void setMenuHashMapKey(String Key)
    {
        MenuHashMapKey.add(Key);
    }
    public List<String> getMenuHashMapKey()
    {
        return MenuHashMapKey;
    }
    public String getMenuHashMapKey(int Id)
    {
        return MenuHashMapKey.get(Id);
    }
    public void clearMenuHashMapKey(){getMenuHashMapKey().clear();}

    public  void setMenu(){
        Menu = new HashMap<String, HashMap<String, List<String>>>();
    }
    public  void setMenuNewElement(String Key)// Soğuk icecekler, Atıştırmalıklar vs ana başlıklar koyuluyor
    {
        Menu.put(Key,new HashMap<String, List<String>>());
    }
    public  void setUrunIsimList(String Key) // urun isim listesi tanımlanıyor
    {
        Menu.get(Key).put("UrunIsim", new ArrayList<String>());
    }
    public  void setUrunFiyatList(String Key)// urun fiyat listesi tanımlanıyor
    {
        Menu.get(Key).put("UrunFiyat", new ArrayList<String>());
    }
    public  void setUrunKeyList(String Key) // // urun key listesi tanımlanıyor
    {
        Menu.get(Key).put("UrunKey", new ArrayList<String>());
    }
    public  void setUrunIsimList(String Key, String Isim) // urun isim listesine ekleme
    {
        Menu.get(Key).get("UrunIsim").add(Isim);
    }
    public  void setUrunFiyatList(String Key, String Fiyat) // urun fiyat listesi tanımlanıyor
    {
        Menu.get(Key).get("UrunFiyat").add(Fiyat);
    }
    public  void setUrunKeyList(String Key, String UrunKey) // urun key listesine ekleme
    {
        Menu.get(Key).get("UrunKey").add(UrunKey);
    }

    public HashMap<String, HashMap<String, List<String>>> getMenu()
    {
        return Menu;
    }
    public List<String> getUrunIsimList(int MapKey)
    {
       return this.getMenu().get( this.getMenuHashMapKey(MapKey) ).get("UrunIsim");
    }
    public String getUrunFiyat(int MapKey, int FiyatIndex)
    {
        return this.getMenu().get( this.getMenuHashMapKey(MapKey) ).get("UrunFiyat").get(FiyatIndex);
    }
    public String getUrunIsim(int MapKey, int UrunIsımIndex)
    {
        return this.getMenu().get( this.getMenuHashMapKey(MapKey) ).get("UrunIsim").get(UrunIsımIndex);
    }

    public String getUrunKey(int MapKey, int UrunKeyIndex)
    {
        return this.getMenu().get( this.getMenuHashMapKey(MapKey) ).get("UrunKey").get(UrunKeyIndex);
    }
}
