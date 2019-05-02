package Kullanici;

import FirebaseIslem.FirebaseProcess;
import GetFirebaseData.FirebaseData;
import GetFirebaseData.GetMenuData;
import GetFirebaseData.GetTablesData;

public class KullaniciA extends Kullanici {
    //admin
    // adminde masalar listelencek
    // müzik eklemeler olcak
    // müziklerde listelencek
    private FirebaseProcess firebaseProcess;
    public FirebaseProcess getProcess() {
        if ( firebaseProcess == null )
            firebaseProcess = new FirebaseProcess();
        return firebaseProcess;
    }

    @Override
    public void createList() {
        super.createList();

        FirebaseData data = new FirebaseData();
        data.BringData(new GetTablesData(), this.getCafeId());
    }

}
