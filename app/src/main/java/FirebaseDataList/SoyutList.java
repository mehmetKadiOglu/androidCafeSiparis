package FirebaseDataList;

import java.util.List;

public abstract class SoyutList {

    // bu sınıfı sadece musicList ve TableList sınıfları kalıtım alıcaktır.
    protected List<String> ValueName; // örneğin muzik ismi, masa numarası
    protected List<String> FirebaseKey;

    abstract void listClear();

    abstract List<String> getValueName();
    abstract String getValueName(int Id);

    abstract  void setValueName(String Name);
    abstract  void setValueName();
    //////////////////

    abstract List<String> getFirebaseKey();
    abstract String getFirebaseKey(int Id);

    abstract  void setFirebaseKey(String Key);
    abstract  void setFirebaseKey();

}
