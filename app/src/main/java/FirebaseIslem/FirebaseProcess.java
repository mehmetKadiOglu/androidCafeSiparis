package FirebaseIslem;

import java.util.HashMap;

import FirebaseIslem.firebaseVeriEkleme.firebaseAddData;
import FirebaseIslem.firebaseVeriSilme.firebaseDeteleData;

public class FirebaseProcess {
    public void firebaseDelete(firebaseDeteleData DeleteData, HashMap MapHash)
    {
        DeleteData.firebaseDelete(MapHash);
    }

    public void firebaseAdd(firebaseAddData AddData, HashMap MapHash)
    {
        AddData.firebaseAdd(MapHash);
    }

}
